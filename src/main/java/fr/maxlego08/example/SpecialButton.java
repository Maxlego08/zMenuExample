package fr.maxlego08.example;

import fr.maxlego08.menu.api.utils.Placeholders;
import fr.maxlego08.menu.button.ZButton;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.util.Vector;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.util.Vector;
import fr.maxlego08.menu.button.ZButton;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;

/**
 * SpecialButton extends ZButton to implement a custom click action.
 */
public class SpecialButton extends ZButton {

    /**
     * Handles the click event on this special button.
     *
     * @param player The player who clicked the button.
     * @param event The inventory click event details.
     * @param inventory The inventory where the click occurred.
     * @param slot The slot number where the click happened.
     * @param placeholders Placeholders for dynamic text replacement, not used in this method.
     */
    @Override
    public void onClick(Player player, InventoryClickEvent event, InventoryDefault inventory, int slot, Placeholders placeholders) {
        // Close the inventory interface for the player.
        player.closeInventory();

        // Send a message to the player.
        player.sendMessage("§fWhoosshh");

        // Get the current velocity of the player.
        Vector vector = player.getVelocity();

        // Add to the player's current velocity to make them move upwards.
        // Here, 'new Vector(0, 2, 0)' adds no motion on the X and Z axes, but adds upward motion on the Y axis.
        vector.add(new Vector(0, 2, 0));

        // Apply the new velocity to the player, effectively causing a "jump" or "boost" effect.
        player.setVelocity(vector);

        // Call the superclass method if necessary. This call might be redundant if the superclass does not implement further action.
        super.onClick(player, event, inventory, slot, placeholders);
    }
}
