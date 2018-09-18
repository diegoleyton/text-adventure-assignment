package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class AddExit extends BaseCommand {
    public AddExit(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        Entity room = getWorldEntity(arguments.get(0));
        Entity exit = getWorldEntity(arguments.get(1));
        room.getRoomComponent().exitIds.add(exit.getIdentityComponent().id);
    }
}
