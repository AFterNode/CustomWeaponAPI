package cn.afternode.mc.customweaponapi;

import cn.afternode.mc.customweaponapi.items.CustomItem;
import com.sun.istack.internal.Nullable;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemRegistry {
    private static final HashMap<Plugin, List<CustomItem>> registeredItems = new HashMap<>();
    private static final List<CustomItem> registeredList = new ArrayList<>();

    public static void registerItem(Plugin plugin, CustomItem item) {
        item.registerItem();
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
    }

    public static List<CustomItem> getRegisteredList() {
        return registeredList;
    }

    @Nullable
    public static List<CustomItem> getPluginItems(Plugin plugin) {
        return registeredItems.get(plugin);
    }
}
