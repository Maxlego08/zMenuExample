package fr.maxlego08.example;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class extends JavaPlugin and implements Listener to handle custom events and functionalities
 * for a Minecraft plugin. It demonstrates dynamic item stack creation, button and inventory management.
 */
public class ExamplePlugin extends JavaPlugin {

    // A list to hold dynamically created item stacks
    private final List<ItemStack> itemStacks = new ArrayList<>();

    /**
     * Called when the plugin is enabled.
     * This method demonstrates how to dynamically create item stacks and add custom meta data to them.
     */
    @Override
    public void onEnable() {
        // Creates a random number of item stacks (between 5 and 34) with custom names and adds them to the list
        for (int a = 0; a < 5 + new Random().nextInt(30); a++) {
            ItemStack itemStack = new ItemStack(Material.STONE); // Create a new ItemStack of STONE
            ItemMeta itemMeta = itemStack.getItemMeta(); // Get the ItemMeta to set custom properties
            itemMeta.setDisplayName("§aItem #§d" + (a + 1)); // Set a custom display name with color codes
            itemStack.setItemMeta(itemMeta); // Apply the ItemMeta back to the ItemStack
            this.itemStacks.add(itemStack); // Add the customized ItemStack to the list
        }

        this.getServer().getPluginManager().registerEvents(new ZMenuLoader(this), this);
    }

    /**
     * Getter for the list of dynamically created item stacks.
     *
     * @return The list of item stacks.
     */
    public List<ItemStack> getItemStacks() {
        return itemStacks;
    }
}
