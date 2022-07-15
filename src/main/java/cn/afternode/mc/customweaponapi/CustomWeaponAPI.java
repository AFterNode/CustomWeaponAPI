package cn.afternode.mc.customweaponapi;

import cn.afternode.mc.customweaponapi.events.CustomFoodUseEvent.CFUECall;
import cn.afternode.mc.customweaponapi.events.CustomWeaponAttackEvent.CWAECall;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class CustomWeaponAPI extends JavaPlugin {
    public static Plugin instance;
    public static Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            instance = this;
            logger = Bukkit.getLogger();

            // EventHandlers
            logger.log(Level.INFO, "[CustomWeaponAPI] Loading events");
            Bukkit.getPluginManager().registerEvents(new CWAECall(), this);
//            Bukkit.getPluginManager().registerEvents(new CFUECall(), this);
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.resetRecipes();
    }
}
