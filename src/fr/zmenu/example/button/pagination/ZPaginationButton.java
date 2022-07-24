package fr.zmenu.example.button.pagination;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.menu.button.buttons.ZSlotButton;
import fr.maxlego08.menu.inventory.inventories.InventoryDefault;
import fr.maxlego08.menu.zcore.utils.inventory.Pagination;
import fr.zmenu.example.ExamplePlugin;

public class ZPaginationButton extends ZSlotButton implements PaginationButton{

	private final ExamplePlugin plugin;

	/**
	 * @param slots
	 * @param plugin
	 */
	public ZPaginationButton(List<Integer> slots, ExamplePlugin plugin) {
		super(slots);
		this.plugin = plugin;
	}

	@Override
	public void onRender(Player player, InventoryDefault inventory) {

		Pagination<ItemStack> pagination = new Pagination<>();
		List<Integer> slots = new ArrayList<Integer>(this.getSlots());
		List<ItemStack> itemStacks = pagination.paginate(this.plugin.getItemstacks(), slots.size(),
				inventory.getPage());

		for (int i = 0; i != Math.min(itemStacks.size(), slots.size()); i++) {

			int slot = slots.get(i);
			ItemStack itemStack = itemStacks.get(i);
			inventory.addItem(slot, itemStack).setClick(event -> {
				player.sendMessage("§fClick !");
			});
		}
	}
}
