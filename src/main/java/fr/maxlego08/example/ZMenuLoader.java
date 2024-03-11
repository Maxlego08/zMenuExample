package fr.maxlego08.example;

import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.api.event.events.ButtonLoaderRegisterEvent;
import fr.maxlego08.menu.button.loader.NoneLoader;
import fr.maxlego08.menu.exceptions.InventoryException;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;

public class ZMenuLoader implements Listener {

    private final ExamplePlugin plugin;
    // Manager for handling button-related actions
    private ButtonManager buttonManager;
    // Manager for handling inventory-related actions
    private InventoryManager inventoryManager;

    public ZMenuLoader(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles the ButtonLoaderRegisterEvent to initialize button and inventory managers,
     * then registers buttons and loads inventories.
     *
     * @param event The event triggered when button loading is ready to be handled.
     */
    @EventHandler
    public void onButtonLoad(ButtonLoaderRegisterEvent event) {
        this.buttonManager = event.getButtonManager(); // Initialize the button manager from the event
        this.inventoryManager = event.getInventoryManager(); // Initialize the inventory manager from the event

        this.registerButtons(); // Register custom buttons
        this.loadInventories(); // Load custom inventories
    }

    /**
     * Registers custom buttons with their respective actions using the button manager.
     */
    private void registerButtons() {
        // Registering buttons without a specific loader, providing the plugin instance, button class, and an identifier
        this.buttonManager.register(new NoneLoader(this.plugin, ExamplePaginateButton.class, "zmenuexample_pagination"));
        this.buttonManager.register(new NoneLoader(this.plugin, SpecialButton.class, "zmenuexample_special"));

        // Registering a custom option/action with the inventory manager
        this.inventoryManager.registerOption(this.plugin, CustomAction.class);
    }

    /**
     * Loads custom inventories from configuration files or saves default ones if they don't exist.
     */
    private void loadInventories() {
        try {
            // Attempt to load or save a custom inventory configuration from a YAML file
            this.inventoryManager.loadInventoryOrSaveResource(this.plugin, "inventories/paginate_inventory.yml");
        } catch (InventoryException exception) {
            // Log any exceptions that occur during inventory loading
            exception.printStackTrace();
        }
    }

    /**
     * A utility method to retrieve service providers registered with the server's service manager.
     *
     * @param classProvider The class of the service provider to retrieve.
     * @param <T>           The type of the service provider.
     * @return The service provider instance or null if not found.
     */
    private <T> T getProvider(Class<T> classProvider) {
        RegisteredServiceProvider<T> provider = Bukkit.getServer().getServicesManager().getRegistration(classProvider);
        return provider == null ? null : provider.getProvider();
    }

}
