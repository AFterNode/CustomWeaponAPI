package cn.afternode.mc.customweaponapi.events.CustomWeaponAttackEvent;

import cn.afternode.mc.customweaponapi.ItemRegistry;
import cn.afternode.mc.customweaponapi.items.CustomWeapon;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class CWAECall implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        if (ItemRegistry.getItemWithMeta(((Player) event.getDamager()).getInventory().getItemInMainHand().getItemMeta()) instanceof CustomWeapon) {
            Player damager = (Player) event.getDamager();
            CustomWeaponAttackEvent e = new CustomWeaponAttackEvent(damager, damager.getInventory().getItemInMainHand());
            Bukkit.getPluginManager().callEvent(e);
        }
    }
}
