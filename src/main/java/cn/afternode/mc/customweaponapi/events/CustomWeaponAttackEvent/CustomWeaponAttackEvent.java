package cn.afternode.mc.customweaponapi.events.CustomWeaponAttackEvent;

import cn.afternode.mc.customweaponapi.ItemRegistry;
import cn.afternode.mc.customweaponapi.items.CustomWeapon;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomWeaponAttackEvent extends PlayerEvent {
    public static HandlerList handlers = new HandlerList();
    private final ItemStack stack;
    private final CustomWeapon weapon;

    public CustomWeaponAttackEvent(Player who, ItemStack stack) {
        super(who);

        this.stack = stack;
        this.weapon = (CustomWeapon) ItemRegistry.getItemWithMeta(stack.getItemMeta());
    }

    public CustomWeapon getWeapon() {
        return weapon;
    }

    public ItemStack getStack() {
        return stack;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
