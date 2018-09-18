package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.EntityFactory;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;

import java.util.ArrayList;

public class CreateThings extends BaseCommand {
    public CreateThings(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException {
        Entity thing = EntityFactory.createThing();
        thing.getIdentityComponent().id = arguments.get(0);
        addEntity(thing);
    }
}
