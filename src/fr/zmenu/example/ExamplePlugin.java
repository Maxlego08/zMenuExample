package fr.zmenu.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.button.loader.NoneLoader;
import fr.maxlego08.menu.exceptions.InventoryException;
import fr.zmenu.example.button.pagination.PaginationLoader;
import fr.zmenu.example.button.special.SpecialButton;

public class ExamplePlugin extends JavaPlugin {

	private ButtonManager buttonManager;
	private InventoryManager inventoryManager;
	private final List<ItemStack> itemstacks = new ArrayList<>();

	@Override
	public void onEnable() {

		// Get service provider for ButtonManager and InventoryManager
		this.buttonManager = this.getProvider(ButtonManager.class);
		this.inventoryManager = this.getProvider(InventoryManager.class);

		this.loadInventories();

		for (int a = 0; a != ThreadLocalRandom.current().nextInt(5, 35); a++) {
			ItemStack itemStack = new ItemStack(Material.STONE);
			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.setDisplayName("§aItem #§d" + (a + 1));
			itemStack.setItemMeta(itemMeta);
			this.itemstacks.add(itemStack);
		}
	}
	
	/**
	 * Open an inventory 
	 * 
	 * @param player
	 */
	public void openInventory(Player player){
	
		this.inventoryManager.openInventory(player, this, "paginate_inventory");
		
	}

	private void loadInventories() {

		// Check if file exist
		File file = new File(this.getDataFolder(), "examples/paginate_inventory.yml");
		if (!file.exists()) {
			this.saveResource("examples/paginate_inventory.yml", false);
		}

		// Unregister buttons
		this.buttonManager.unregisters(this);
		this.buttonManager.register(new PaginationLoader(this));
		this.buttonManager.register(new NoneLoader(this, SpecialButton.class, "ZMENUEXAMPLE_SPECIAL"));

		try {
			// Unregister inventories
			this.inventoryManager.deleteInventories(this);

			// Load inventory file with custom inventory class
			this.inventoryManager.loadInventory(this, file, PaginationInventory.class);
		} catch (InventoryException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onDisable() {

	}

	private <T> T getProvider(Class<T> classz) {
		RegisteredServiceProvider<T> provider = getServer().getServicesManager().getRegistration(classz);
		return provider == null ? null : provider.getProvider() != null ? (T) provider.getProvider() : null;
	}

	public ButtonManager getButtonManager() {
		return buttonManager;
	}

	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}

	public List<ItemStack> getItemstacks() {
		return itemstacks;
	}
	
}
