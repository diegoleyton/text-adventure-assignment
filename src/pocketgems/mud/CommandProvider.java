package pocketgems.mud;

import pocketgems.mud.commands.*;
import pocketgems.mud.exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	private Map<String, ICommand> map;

	public CommandProvider() {
        map = new HashMap<>();
    }

	public void add(String commandName, ICommand command) {
        map.put(commandName, command);
    }

    public ICommand get(String command) throws CommandNotFoundException {
	    if(!map.containsKey(command)) {
	        throw new CommandNotFoundException(command);
        }
	    return map.get(command);
    }

	public void SetDefaultCommands(Game game) {
        add("", new Empty(game));
        add("exit", new Exit(game));
        add("help", new Help());
        add("load", new Load(game));
        add("createroom", new CreateRoom(game));
        add("createexit", new CreateExit(game));
        add("creatething", new CreateThings(game));
        add("setname", new SetName(game));
        add("setdescription", new SetDescription(game));
        add("addexit", new AddExit(game));
        add("setdestination", new SetDestionation(game));
        add("addkeyword", new AddKeyword(game));
        add("movething", new MoveThings(game));
        add("createitem", new CreateItem(game));
        add("get", new GetItem(game));
        add("drop", new DropItem(game));

        ICommand look = new Look(game);
        add("look", look);
        add("l", look);

        ICommand move = new Move(game);
        add("go", move);
        add("move", move);

        ICommand showInventory = new ShowInventory(game);
        add("i", showInventory);
        add("inv", showInventory);
        add("inventory", showInventory);

	}
}
