package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.World;
import pocketgems.mud.components.RoomComponent;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class Look extends BaseCommand {
    public Look(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        if (arguments.size() == 0) {
            World world = getWorld();
            Entity room = getPlayerRoom();
            if (room != null) {
                System.out.println(room.getDescriptionComponent().name);
                System.out.println();
                System.out.println(room.getDescriptionComponent().description);
                System.out.println();

                RoomComponent roomComponent = room.getRoomComponent();
                if (roomComponent.inhabitantIds.size() > 1) {
                    // There is at least one thing here that isn't the player.
                    System.out.println("You see the following:");

                    for (String inhabitantId : roomComponent.inhabitantIds) {
                        Entity inhabitant = getWorldEntity(inhabitantId);
                        if (inhabitant != getPlayer()) {
                            System.out.println("  - " + inhabitant.getDescriptionComponent().description);
                        }
                    }
                }
                System.out.println();

                System.out.print("Exits:");
                for (String exitId : roomComponent.exitIds) {
                    Entity exit = world.GetEntity(exitId);
                    System.out.print(" " + exit.getDescriptionComponent().name);
                }
                System.out.println();
            } else {
                System.out.println("You float in the void. Join a room with the command 'movething player <room-id>'.");
            }

            System.out.println();
        } else {
            Entity target = entityInRoom(arguments.get(0));
            if (target == null) {
                System.out.println("You do not see that here.");
            } else {
                System.out.println("You look at the " + target.getDescriptionComponent().name + ".");
            }

            System.out.println();
        }
    }
}
