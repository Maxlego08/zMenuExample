package fr.maxlego08.example.loaders;

import fr.maxlego08.example.actions.ExampleAction;
import fr.maxlego08.menu.api.loader.ActionLoader;
import fr.maxlego08.menu.api.requirement.Action;
import fr.maxlego08.menu.api.utils.TypedMapAccessor;

import java.io.File;

public class ExampleActionLoader extends ActionLoader {

    public ExampleActionLoader() {
        super("example-action", "example action");
    }

    @Override
    public Action load(String path, TypedMapAccessor typedMapAccessor, File file) {
        return new ExampleAction();
    }
}
