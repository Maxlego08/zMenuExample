package fr.maxlego08.example;

// Import statements
import fr.maxlego08.menu.MenuItemStack;
import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.button.ButtonOption;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;
import fr.maxlego08.menu.zcore.utils.loader.Loader;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * CustomAction implements ButtonOption to provide custom button behavior within the plugin's zMenu.
 */
public class CustomAction implements ButtonOption {

    // A reference to the main plugin instance to access its functionalities and configurations.
    private final ExamplePlugin plugin;
    // A flag to enable or disable the custom action, controlled through the configuration file.
    private boolean enableCustomAction;

    /**
     * Constructor for CustomAction.
     * @param plugin The instance of the main plugin class.
     */
    public CustomAction(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Returns the unique name for this custom action.
     * @return A string identifier for this action.
     */
    @Override
    public String getName() {
        return "custom_action_example";
    }

    /**
     * Returns the plugin instance associated with this custom action.
     * @return The plugin instance.
     */
    @Override
    public Plugin getPlugin() {
        return this.plugin;
    }

    /**
     * Loads button settings from a configuration file.
     * This method is called automatically to apply configuration settings to the button.
     *
     * @param button The button being configured.
     * @param yamlConfiguration The YamlConfiguration loaded from the file.
     * @param path The path prefix to read configuration values.
     * @param inventoryManager The inventory manager instance.
     * @param buttonManager The button manager instance.
     * @param loader The loader used for loading item stacks.
     * @param file The file from which the configuration is loaded.
     */
    @Override
    public void loadButton(Button button, YamlConfiguration yamlConfiguration, String path, InventoryManager inventoryManager, ButtonManager buttonManager, Loader<MenuItemStack> loader, File file) {
        // Loads the enableCustomAction value from the configuration file. Defaults to false if not specified.
        this.enableCustomAction = yamlConfiguration.getBoolean(path + "enableCustomAction", false);
    }

    /**
     * Handles the click event on the button.
     * This method is triggered when a player clicks on a button that has this custom action assigned.
     *
     * @param button The button that was clicked.
     * @param player The player who clicked the button.
     * @param inventoryClickEvent The event associated with the inventory click.
     * @param inventoryDefault The inventory where the click occurred.
     * @param slot The slot index where the click occurred.
     * @param hasPermission A flag indicating if the player has permission to use this action.
     */
    @Override
    public void onClick(Button button, Player player, InventoryClickEvent inventoryClickEvent, InventoryDefault inventoryDefault, int slot, boolean hasPermission) {
        // If the player has permission and the custom action is enabled, send them a custom message.
        if (hasPermission && enableCustomAction) {
            player.sendMessage("§aHey, it's a custom action here !");
        }
    }
}
