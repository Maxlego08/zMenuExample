package fr.maxlego08.example.permissibles;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import fr.maxlego08.menu.api.requirement.Action;
import fr.maxlego08.menu.api.requirement.Permissible;
import fr.maxlego08.menu.api.utils.Placeholders;
import org.bukkit.entity.Player;

import java.util.List;

public class ExamplePermissible extends Permissible {

    public ExamplePermissible(List<Action> denyActions, List<Action> successActions) {
        super(denyActions, successActions);
    }

    @Override
    public boolean hasPermission(Player player, Button button, InventoryEngine inventoryEngine, Placeholders placeholders) {
        return true;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
