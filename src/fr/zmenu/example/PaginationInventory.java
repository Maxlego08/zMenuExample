package fr.zmenu.example;

import java.util.List;
import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fr.maxlego08.menu.ZInventory;
import fr.maxlego08.menu.api.button.Button;
import fr.zmenu.example.button.pagination.PaginationButton;

public class PaginationInventory extends ZInventory {

	private final ExamplePlugin plugin;

	public PaginationInventory(Plugin plugin, String name, String fileName, int size, List<Button> buttons) {
		super(plugin, name, fileName, size, buttons);
		this.plugin = (ExamplePlugin) plugin;
	}

	@Override
	public int getMaxPage(Player player, Object... objects) {

		int maxPage = super.getMaxPage(player, objects);
		int currentMaxPage = 1;

		Optional<PaginationButton> optional = this.getButtons(PaginationButton.class).stream().findFirst();
		if (optional.isPresent()) {
			PaginationButton button = optional.get();
			List<ItemStack> elements = this.plugin.getItemstacks();
			int elementSize = elements.size();
			if (elementSize >= 1) {
				int size = button.getSlots().size();
				return ((elementSize / (size)) + (elementSize == (size) ? 0 : 1));
			}
		}

		return Math.max(maxPage, currentMaxPage);
	}

}
