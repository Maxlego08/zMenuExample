package fr.maxlego08.example;

import fr.maxlego08.menu.api.button.PaginateButton;
import fr.maxlego08.menu.button.ZButton;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;
import fr.maxlego08.menu.zcore.utils.inventory.Pagination;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * ExamplePaginateButton extends ZButton and implements PaginateButton to provide
 * pagination functionality for a custom inventory within a zMenu.
 */
public class ExamplePaginateButton extends ZButton implements PaginateButton {

    // Reference to the main plugin instance for accessing its functionalities.
    private final ExamplePlugin plugin;

    /**
     * Constructor that casts the generic Plugin type to the specific ExamplePlugin type.
     * @param plugin The plugin instance, passed in as a generic Plugin type.
     */
    public ExamplePaginateButton(Plugin plugin) {
        this.plugin = (ExamplePlugin) plugin;
    }

    /**
     * Indicates that this button has a special render behavior, enabling pagination.
     * @return true to signify that custom rendering logic is used.
     */
    @Override
    public boolean hasSpecialRender() {
        return true;
    }

    /**
     * Custom rendering method for paginated items. It populates the inventory with items
     * based on the current page and available slots.
     * @param player The player viewing the inventory.
     * @param inventory The inventory being rendered.
     */
    @Override
    public void onRender(Player player, InventoryDefault inventory) {
        // Utilize Pagination utility to split itemStacks into pages.
        Pagination<ItemStack> pagination = new Pagination<>();

        // Get paginated list of ItemStacks for the current page.
        List<ItemStack> itemStacks = pagination.paginate(this.plugin.getItemStacks(), this.slots.size(), inventory.getPage());

        // Loop through the paginated items and add them to the inventory.
        for (int i = 0; i != Math.min(itemStacks.size(), this.slots.size()); i++) {
            int slot = slots.get(i); // Get the slot number.
            ItemStack itemStack = itemStacks.get(i); // Get the ItemStack.
            // Add the item to the inventory at the specified slot and set a click listener.
            inventory.addItem(slot, itemStack).setClick(event -> player.sendMessage("§fClick !"));
        }
    }

    /**
     * Determines the total size of pagination based on the total number of items.
     * @param player The player for whom the pagination size is calculated.
     * @return The total number of items to paginate.
     */
    @Override
    public int getPaginationSize(Player player) {
        // Return the total size of itemStacks to determine how many pages are needed.
        return this.plugin.getItemStacks().size();
    }
}
