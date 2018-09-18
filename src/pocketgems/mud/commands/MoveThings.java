package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class MoveThings extends BaseCommand {
    public MoveThings(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        Entity thing = getWorldEntity(arguments.get(0));
        Entity room = getWorldEntity(arguments.get(1));
        moveToRoom(thing, room.getIdentityComponent().id);
    }
}
