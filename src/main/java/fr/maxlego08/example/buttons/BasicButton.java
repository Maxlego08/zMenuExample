package fr.maxlego08.example.buttons;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import fr.maxlego08.menu.api.utils.Placeholders;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BasicButton extends Button {

    private final String key;

    public BasicButton(String key) {
        this.key = key;
    }

    @Override
    public void onClick(Player player, InventoryClickEvent event, InventoryEngine inventory, int slot, Placeholders placeholders) {
        super.onClick(player, event, inventory, slot, placeholders);

        player.sendMessage(Component.text("Hey, it's nice to meet you ! Button key: ").append(Component.text(key)));
    }

    @Override
    public boolean isPermanent() {
        return true;
    }
}
