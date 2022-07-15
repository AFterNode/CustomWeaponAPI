package cn.afternode.mc.customweaponapi.items;

import org.bukkit.Material;

/**
 * Material of CustomFood must be food in vanilla
 * Or CustomFoodUseEvent won't work
 */
public abstract class CustomFood extends CustomItem{
    public CustomFood(Material material, String id) {
        super(material, id);
    }
}
