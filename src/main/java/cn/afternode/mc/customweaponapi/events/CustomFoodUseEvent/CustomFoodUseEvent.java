package cn.afternode.mc.customweaponapi.events.CustomFoodUseEvent;

import cn.afternode.mc.customweaponapi.items.CustomFood;
import com.google.common.annotations.Beta;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

@Beta
public class CustomFoodUseEvent extends PlayerEvent {
    public static HandlerList handlers = new HandlerList();

    public CustomFood food;

    public CustomFoodUseEvent(@NotNull Player who, CustomFood food) {
        super(who);

        this.food = food;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
