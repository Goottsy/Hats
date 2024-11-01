package com.goottsy.hats;

import com.goottsy.Hats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static com.goottsy.Game.*;
import static com.goottsy.Utils.Tools.*;

public class HatsListener implements Listener {

    private Hats instance;
    public HatsListener(Hats instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() != null &&
                event.getClickedInventory().getHolder() instanceof HatsUI) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getItemMeta() != null) {
                player.getInventory().setHelmet(clickedItem);
                String itemName = clickedItem.getItemMeta().getDisplayName();
                player.sendMessage(prefix + equip + itemName );

                player.closeInventory();
            }
        }
    }
}
