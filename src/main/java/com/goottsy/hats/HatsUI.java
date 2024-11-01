package com.goottsy.hats;

import com.goottsy.Game;
import com.goottsy.Hats;
import com.goottsy.Utils.ItemBuilder;
import com.goottsy.Utils.Tools;
import lombok.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.goottsy.Game.*;
import static com.goottsy.Utils.Tools.CustomItem;
import static com.goottsy.Utils.Tools.gold;

public class HatsUI implements InventoryHolder {

    private Inventory inventory;
    private Hats instance;
    private FileConfiguration config;

    public HatsUI(Hats instance) {
        this.instance = instance;
        this.config = instance.getConfig();

        createInventory();
    }

    public void createInventory() {
        config = instance.getConfig();
        if (inventory != null) {
            inventory.clear();
            inventory = null;
        }

        loadHatData();

        this.inventory = Bukkit.createInventory(this, 54, GUITitle);
        List<HatsType> hats = getHats();
        if (hats.isEmpty()) {
            instance.getLogger().warning("La lista de sombreros está vacía");
        } else {
            for (HatsType hatData : hats) {
                ItemStack item = Tools.CustomItem(hatData.getName(), hatData.getMaterial(), hatData.getCmd());
                inventory.addItem(item);
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    private List<HatsType> hatDataList = new ArrayList<>();

    public static int hatsLoaded = 0;
    public void loadHatData() {
        hatDataList.clear();
        if (config.isList("hats")) {
            List<?> hatsConfigList = config.getList("hats");
            if (hatsConfigList != null) {
                hatsLoaded = 0;

                for (Object obj : hatsConfigList) {
                    if (obj instanceof Map) {
                        Map<?, ?> hatMap = (Map<?, ?>) obj;
                        hatsLoaded++;
                        String id = (String) hatMap.get("id");
                        String name = (String) hatMap.get("name");
                        Material material = Material.matchMaterial((String) hatMap.get("material"));
                        int cmd = (int) hatMap.get("cmd");
                        HatsType hatData = new HatsType(id, name, material, cmd);
                        hatDataList.add(hatData);
                    }
                }
                instance.getLogger().warning(prefix + reload_items+gold(" "+hatsLoaded));
            }
        }
    }


    public List<HatsType> getHats() {
        return hatDataList;
    }
}
