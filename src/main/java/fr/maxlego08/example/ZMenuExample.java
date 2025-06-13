package fr.maxlego08.example;

import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.InventoryManager;
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


    }

    @Override
    public void onDisable() {

    }

    private <T> T getProvider(Class<T> classz) {
        RegisteredServiceProvider<T> provider = getServer().getServicesManager().getRegistration(classz);
        return provider == null ? null : provider.getProvider() != null ? provider.getProvider() : null;
    }
}
