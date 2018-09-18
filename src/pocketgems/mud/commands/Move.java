package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.components.RoomComponent;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class Move extends BaseCommand {
    public Move(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        Entity room = getPlayerRoom();
        if (room != null) {
            RoomComponent roomComponent = room.getRoomComponent();
            for (String exitId : roomComponent.exitIds) {
                Entity exit = getWorldEntity(exitId);
                if (exit.getDescriptionComponent().keywords.contains(arguments.get(0))) {
                    moveToRoom(getPlayer(), exit.getPortalComponent().destinationRoomId);
                    getInputProcessor().processInput("look");
                    return;
                }
            }
        }
        // Room not found
        throw new EntityNotFoundException(arguments.get(0));
    }
}
