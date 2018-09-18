package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.components.InventoryComponent;
import pocketgems.mud.components.RoomComponent;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class DropItem extends BaseCommand {
    public DropItem(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        Entity room = getPlayerRoom();
        if (room != null) {
            InventoryComponent inventory = getPlayer().getInventoryComponent();
            Entity entity = inventory.getOrNull(arguments.get(0));
            if (entity != null) {
                removeFromInventory(entity);
                System.out.println("“You drop a " + entity.getDescriptionComponent().description + ".");
            } else {
                System.out.println("You do not have that.");
            }
        } else {
            System.out.println("You float in the void. Join a room with the command 'movething player <room-id>'.");
        }

        System.out.println();
    }

    protected void removeFromInventory(Entity entity)
            throws ComponentNotFoundException, EntityNotFoundException {
        InventoryComponent inventory = getPlayer().getInventoryComponent();
        RoomComponent room = getPlayerRoom().getRoomComponent();
        inventory.remove(entity);
        room.inhabitantIds.add(entity.getIdentityComponent().id);
    }
}
