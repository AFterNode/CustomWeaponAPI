package cn.afternode.mc.customweaponapi;

import cn.afternode.mc.customweaponapi.events.CustomItemRegisterEvent.CustomItemRegisterEvent;
import cn.afternode.mc.customweaponapi.items.CustomItem;
import cn.afternode.mc.customweaponapi.items.CustomWeapon;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemRegistry {
    private static final HashMap<Plugin, List<CustomItem>> registeredItems = new HashMap<>();
    private static final List<CustomItem> registeredList = new ArrayList<>();

    private static final HashMap<ItemMeta, CustomItem> itemMap = new HashMap<>();
    private static final List<ItemMeta> metas = new ArrayList<>();
    private static final List<ItemMeta> weaponMetas = new ArrayList<>();

    public static void registerItem(Plugin plugin, CustomItem item) {
        item.registerItem();
        Bukkit.getPluginManager().registerEvents(item, plugin);

        if (!registeredItems.containsKey(plugin)) {
            List<CustomItem> items = new ArrayList<>();
            items.add(item);
            registeredItems.put(plugin, items);
        } else {
            List<CustomItem> items = registeredItems.get(plugin);
            items.add(item);
            registeredItems.replace(plugin, items);
        }

        registeredList.add(item);
        metas.add(item.meta);

        if (item instanceof CustomWeapon) {
            weaponMetas.add(item.meta);
        }

        CustomItemRegisterEvent event = new CustomItemRegisterEvent(item, plugin);
        Bukkit.getPluginManager().callEvent(event);
    }

    public static List<CustomItem> getRegisteredList() {
        return registeredList;
    }

    public static List<ItemMeta> getMetas() {
        return metas;
    }

    public static List<ItemMeta> getWeaponMetas() {
        return weaponMetas;
    }

    @Nullab   le
    public static List<CustomItem> getPluginItems(Plugin plugin) {
        return registeredItems.get(plugin);
    }

    @Nullable
    public static CustomItem getItemWithMeta(ItemMeta meta) {
        return itemMap.get(meta);
    }
}
