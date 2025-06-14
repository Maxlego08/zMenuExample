package fr.maxlego08.example.buttons;

import fr.maxlego08.menu.api.button.PaginateButton;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import fr.maxlego08.menu.api.utils.Placeholders;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.List;

public class BooksButton extends PaginateButton {

    List<String> bestsellers = List.of("The First Gentleman", "Stuart Woods' Finders Keepers", "Badlands", "Hidden Nature", "Atmosphere: A Love Story", "Nightshade", "Project Hail Mary", "Problematic Summer Romance", "The Wedding People", "The Let Them Theory", "Original Sin", "Atomic Habits", "The Alchemist", "Great Big Beautiful Life", "The Emperor of Gladness", "Never Flinch", "Onyx Storm", "Fourth Wing", "Till Summer Do Us Part", "Iron Flame", "My Hero Academia, Vol. 41", "Dandadan, Vol. 13", "The Tenant", "Remarkably Bright Creatures", "Funny Story", "One Golden Summer", "The Wager", "On Tyranny", "Braiding Sweetgrass", "The Body Keeps the Score");
    
    @Override
    public void onRender(Player player, InventoryEngine inventoryEngine) {
        this.paginate(this.bestsellers, inventoryEngine, (slot, book) -> {
            Placeholders placeholders = new Placeholders();
            placeholders.register("book", book);
            inventoryEngine.addItem(slot, this.getItemStack().build(player, false, placeholders)).setClick(event -> {
                player.sendMessage(Component.text("You clicked on ").append(Component.text(book)));
                player.closeInventory();
            });
        });
    }

    @Override
    public int getPaginationSize(Player player) {
        return this.bestsellers.size();
    }
}
