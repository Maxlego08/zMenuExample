package fr.zmenu.example.button.special;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import fr.maxlego08.menu.button.ZPlaceholderButton;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;
import fr.zmenu.example.ExamplePlugin;

public class SpecialButton extends ZPlaceholderButton {

	private final ExamplePlugin plugin;

	/**
	 * @param plugin
	 */
	public SpecialButton(Plugin plugin) {
		super();
		this.plugin = (ExamplePlugin) plugin;
	}

	@Override
	public void onClick(Player player, InventoryClickEvent event, InventoryDefault inventory, int slot) {

		player.closeInventory();
		player.sendMessage("§fWhoosshh §5" + plugin.getItemstacks().size());
		
		Vector vector = player.getVelocity();
		vector.add(new Vector(0, 2, 0));
		player.setVelocity(vector);

	}

}
