package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.components.*;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class GetItem extends BaseCommand {
    public GetItem(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        if (getPlayerRoom() != null) {
            try {
                //TODO(dleytons): Assuming that players can only grab items from the current room.
                //to look in the entire world use Entity target = getWorld().GetEntity(arguments.get(0));
                //then we would have to look in all the rooms in order to remove it.
                Entity target = entityInRoom(arguments.get(0));
                ItemComponent itemComponent = target.getItemComponent();
                if (itemComponent != null) {
                    addToInventory(target);
                    System.out.println("“You acquire " + target.getDescriptionComponent().description + ".");
                } else {
                    System.out.println("You cannot take that.");
                }
            }
            catch(EntityNotFoundException e) {
                System.out.println("Item not found.");
            }
        } else {
            System.out.println("You float in the void. Join a room with the command 'movething player <room-id>'.");
        }

        System.out.println();
    }

    protected void addToInventory(Entity itemEntity)
            throws ComponentNotFoundException, EntityNotFoundException {

        InventoryComponent inventory = getPlayer().getInventoryComponent();
        RoomComponent room = getPlayerRoom().getRoomComponent();
        inventory.add(itemEntity);
        room.inhabitantIds.remove(itemEntity.getIdentityComponent().id);
    }
}
