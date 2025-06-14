package fr.maxlego08.example.actions;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import fr.maxlego08.menu.api.requirement.Action;
import fr.maxlego08.menu.api.utils.Placeholders;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class ExampleAction extends Action {

    @Override
    protected void execute(Player player, Button button, InventoryEngine inventoryEngine, Placeholders placeholders) {
        player.sendMessage(Component.text("You clicked on me"));
    }
}
