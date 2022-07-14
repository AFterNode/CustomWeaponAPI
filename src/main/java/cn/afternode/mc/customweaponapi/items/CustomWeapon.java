package cn.afternode.mc.customweaponapi.items;

import cn.afternode.mc.customweaponapi.events.CustomWeaponAttackEvent.CustomWeaponAttackEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;

public abstract class CustomWeapon extends CustomItem {
    public CustomWeapon(Material material, String id) {
        super(material, id);
    }

    @EventHandler
    public abstract void onCustomWeaponAttack(CustomWeaponAttackEvent event);
}
