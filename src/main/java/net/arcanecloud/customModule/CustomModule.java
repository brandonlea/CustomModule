package net.arcanecloud.customModule;

import me.pikamug.quests.BukkitQuestsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.AbstractMap;
import java.util.Map;

public final class CustomModule extends JavaPlugin {

    private static final BukkitQuestsPlugin quests = (BukkitQuestsPlugin) Bukkit.getServer().getPluginManager().getPlugin("Quests");
    private static final String moduleName = "ArcaneModule";
    private static final Map.Entry<String, Short> moduleItem = new AbstractMap.SimpleEntry<>("DIAMOND", (short)0);

    public static BukkitQuestsPlugin getQuests() {
        return quests;
    }

    public static String getModuleName() {
        return moduleName;
    }

    public static Map.Entry<String, Short> getModuleItem() {
        return moduleItem;
    }

    @Override
    public void onEnable() {
        getLogger().severe(ChatColor.RED + "Move this jar to your " + File.separatorChar + "Quests" + File.separatorChar
                + "modules folder!");
        getServer().getPluginManager().disablePlugin(this);
        setEnabled(false);
    }

    @Override
    public void onDisable() {
    }
}
