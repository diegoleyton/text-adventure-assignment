package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.components.InventoryComponent;
import pocketgems.mud.components.ItemComponent;
import pocketgems.mud.components.RoomComponent;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class ShowInventory extends BaseCommand {
    public ShowInventory(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException {
        InventoryComponent inventory = getPlayer().getInventoryComponent();

        System.out.println("Your inventory:");
        for(Entity entity : inventory.getItems()) {
            System.out.println("  - " + entity.getDescriptionComponent().description);
        }
    }
}
