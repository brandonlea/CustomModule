package net.arcanecloud.customModule;

import com.artillexstudios.axgens.AxGens;
import com.artillexstudios.axgens.api.AxGensAPI;
import com.artillexstudios.axgens.api.events.AxGensHookReloadEvent;
import com.artillexstudios.axgens.api.events.GeneratorPostPlaceEvent;
import com.artillexstudios.axgens.generators.Generator;
import com.artillexstudios.axgens.user.AxGensUser;
import me.pikamug.quests.module.BukkitCustomObjective;
import me.pikamug.quests.quests.Quest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import java.util.Map;

public class GenObjective extends BukkitCustomObjective
{
    public GenObjective() {
        setName("Generator Objective");
        setAuthor("ArcaneCloud");
        setItem("DIAMOND_BLOCK", (short) 0);
        setShowCount(true);
        setCountPrompt("How many Generators would you like to place?");
        addStringPrompt("Tier", "Please choose a tier", "None");
        addStringPrompt("Name of generator", "Please select a name", "None");
        setDisplay("%Name of generator%: %count%");
    }

    @Override
    public String getModuleName() {
        return CustomModule.getModuleName();
    }

    @Override
    public Map.Entry<String, Short> getModuleItem() {
        return CustomModule.getModuleItem();
    }

    @EventHandler(priority = EventPriority.LOW)
    public void PlaceGeneratorEvent(GeneratorPostPlaceEvent event) {
        final Player player = event.getPlayer();
        final Generator generator = event.getGenerator();
        for(Quest quest : CustomModule.getQuests().getQuester(player.getUniqueId()).getCurrentQuests().keySet()) {
            Map<String, Object> map = getDataForPlayer(player.getUniqueId(), this, quest);


            if(map != null) {
                int tier = Integer.parseInt((String) map.get("Tier"));
                if(generator.getTier() == tier) {
                    incrementObjective(player.getUniqueId(), this, quest, 1);
                }
            }
        }
    }
}
