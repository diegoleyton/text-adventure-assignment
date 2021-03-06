package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public class AddKeyword extends BaseCommand {
    public AddKeyword(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException {
        Entity entity = getWorldEntity(arguments.get(0));
        entity.getDescriptionComponent().keywords.add(arguments.get(1));
    }
}
