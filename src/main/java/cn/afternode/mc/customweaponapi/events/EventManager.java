package cn.afternode.mc.customweaponapi.events;

import cn.afternode.mc.customweaponapi.CustomWeaponAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventManager {
    private Listener[] listeners;

    public EventManager() {
        listeners = new Listener[]{

        };
    }

    public void registerAll(){
        for (Listener listener: listeners) {
            register(listener);
        }
    }

    public void register(Listener listener){
        Bukkit.getPluginManager().registerEvents(listener, CustomWeaponAPI.instance);
    }
}
