package cn.afternode.mc.customweaponapi.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom item
 */
public abstract class CustomItem implements Listener {
    public final String id;
    public final ItemStack stack;
    public ItemMeta meta;

    public List<String> lore;

    public CustomItem(Material material, String id) {
        this.id = id;
        this.stack = new ItemStack(material);
        this.meta = stack.getItemMeta();

        lore = new ArrayList<>();
    }

    public abstract void setupItem();

    public final void registerItem() {
        Bukkit.addRecipe(getRecipe());

        updateMeta();
    }

    public final void updateMeta() {
        stack.setItemMeta(meta);
    }

    public abstract ShapedRecipe getRecipe();

    public final void addLore(String lore) {
        this.lore.add(lore);
        meta.setLore(this.lore);
    }
}
