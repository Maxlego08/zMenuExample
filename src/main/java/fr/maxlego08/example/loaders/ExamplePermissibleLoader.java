package fr.maxlego08.example.loaders;

import fr.maxlego08.example.permissibles.ExamplePermissible;
import fr.maxlego08.menu.api.ButtonManager;
import fr.maxlego08.menu.api.loader.PermissibleLoader;
import fr.maxlego08.menu.api.requirement.Action;
import fr.maxlego08.menu.api.requirement.Permissible;
import fr.maxlego08.menu.api.utils.TypedMapAccessor;

import java.io.File;
import java.util.List;

public class ExamplePermissibleLoader extends PermissibleLoader {

    private final ButtonManager buttonManager;

    public ExamplePermissibleLoader(ButtonManager buttonManager) {
        super("example-permissible");
        this.buttonManager = buttonManager;
    }

    @Override
    public Permissible load(String path, TypedMapAccessor accessor, File file) {
        List<Action> denyActions = this.loadAction(this.buttonManager, accessor, "deny", path, file);
        List<Action> successActions = this.loadAction(this.buttonManager, accessor, "success", path, file);
        return new ExamplePermissible(denyActions, successActions);
    }
}
