package fr.zmenu.example.button.pagination;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.loader.ButtonLoader;
import fr.zmenu.example.ExamplePlugin;

public class PaginationLoader implements ButtonLoader {

	private final ExamplePlugin plugin;

	/**
	 * @param plugin
	 */
	public PaginationLoader(ExamplePlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public Class<? extends Button> getButton() {
		return PaginationButton.class;
	}

	@Override
	public String getName() {
		return "ZMENUEXAMPLE_PAGINATION";
	}

	@Override
	public Plugin getPlugin() {
		return this.plugin;
	}

	@Override
	public Button load(YamlConfiguration configuration, String path) {
		List<Integer> slots = ButtonLoader.loadSlot(configuration.getStringList(path + "slots"));
		return new ZPaginationButton(slots, this.plugin);
	}

}
