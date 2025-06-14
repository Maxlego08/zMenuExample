package fr.maxlego08.example.loaders;

import fr.maxlego08.menu.api.loader.MaterialLoader;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleMaterialLoader extends MaterialLoader {

    public ExampleMaterialLoader() {
        super("example-material");
    }

    @Override
    public ItemStack load(Player player, YamlConfiguration yamlConfiguration, String path, String materialString) {
        return new ItemStack(Material.DIAMOND);
    }
}
