package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.EntityFactory;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;

import java.util.ArrayList;

public class CreateExit extends BaseCommand {
    public CreateExit(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException {
        Entity exit = EntityFactory.createExit();
        exit.getIdentityComponent().id = arguments.get(0);
        addEntity(exit);
    }
}
