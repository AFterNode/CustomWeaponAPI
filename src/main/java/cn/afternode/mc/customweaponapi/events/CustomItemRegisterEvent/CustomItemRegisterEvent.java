package cn.afternode.mc.customweaponapi.events.CustomItemRegisterEvent;

import cn.afternode.mc.customweaponapi.items.CustomItem;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public class CustomItemRegisterEvent extends Event {
    public static HandlerList handlers = new HandlerList();

    private final CustomItem item;
    private final Plugin from;

    public CustomItemRegisterEvent(CustomItem item, Plugin from) {
        this.item = item;
        this.from = from;
    }

    public CustomItem getItem() {
        return item;
    }

    public Plugin getFrom() {
        return from;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
