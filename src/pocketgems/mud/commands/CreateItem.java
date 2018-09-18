package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.EntityFactory;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;

import java.util.ArrayList;

public class CreateItem extends BaseCommand {
    public CreateItem(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException {
        Entity item = EntityFactory.createItem();
        item.getIdentityComponent().id = arguments.get(0);
        addEntity(item);
    }
}
