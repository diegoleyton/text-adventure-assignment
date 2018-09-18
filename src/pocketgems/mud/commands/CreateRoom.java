package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.EntityFactory;
import pocketgems.mud.Game;
import pocketgems.mud.exceptions.ComponentNotFoundException;

import java.util.ArrayList;

public class CreateRoom extends BaseCommand {
    public CreateRoom(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) throws ComponentNotFoundException {
        Entity room = EntityFactory.createRoom();
        room.getIdentityComponent().id = arguments.get(0);
        addEntity(room);
    }
}
