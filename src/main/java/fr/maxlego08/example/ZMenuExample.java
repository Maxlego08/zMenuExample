package fr.maxlego08.example;

import fr.maxlego08.example.buttons.BooksButton;
import fr.maxlego08.example.loaders.BasicLoader;
import fr.maxlego08.example.loaders.ExampleActionLoader;
import fr.maxlego08.example.loaders.ExampleMaterialLoader;
import fr.maxlego08.example.loaders.ExamplePermissibleLoader;
import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.api.exceptions.InventoryException;
import fr.maxlego08.menu.api.loader.NoneLoader;
import fr.maxlego08.menu.api.pattern.PatternManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZMenuExample extends JavaPlugin {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        InventoryManager inventoryManager = getProvider(InventoryManager.class);
        ButtonManager buttonManager = getProvider(ButtonManager.class);
        PatternManager patternManager = getProvider(PatternManager.class);

        inventoryManager.registerMaterialLoader(new ExampleMaterialLoader());

        buttonManager.register(new BasicLoader(this));
        buttonManager.register(new NoneLoader(this, BooksButton.class, "PAGINATION_EXAMPLE"));

        buttonManager.registerAction(new ExampleActionLoader());
        buttonManager.registerPermissible(new ExamplePermissibleLoader(buttonManager));

        try {
            inventoryManager.loadInventoryOrSaveResource(this, "inventories/example.yml");
        } catch (InventoryException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }

    private <T> T getProvider(Class<T> classz) {
        RegisteredServiceProvider<T> provider = getServer().getServicesManager().getRegistration(classz);
        if (provider == null) {
            throw new RuntimeException("Unable to retrieve the provider " + classz);
        }
        return provider.getProvider();
    }
}
