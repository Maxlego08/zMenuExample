package fr.maxlego08.example.loaders;

import fr.maxlego08.example.buttons.BasicButton;
import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.button.DefaultButtonValue;
import fr.maxlego08.menu.api.loader.ButtonLoader;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class BasicLoader extends ButtonLoader {

    public BasicLoader(Plugin plugin) {
        super(plugin, "BASIC_EXAMPLE");
    }

    @Override
    public Button load(YamlConfiguration configuration, String path, DefaultButtonValue defaultButtonValue) {
        String key = configuration.getString(path + "key-example", "default key");
        return new BasicButton(key);
    }
}
