package pocketgems.mud.commands;

import java.util.ArrayList;

public class Help implements ICommand {
    public void execute() {
        execute(new ArrayList<>());
    }
    public void execute(ArrayList<String> arguments) {
        if (arguments.size() > 0 && arguments.get(0).equals("admin")) {
            System.out.print("Create elements in the world with:\n  ");
            String[] adminCommands = {
                    "createroom", "createexit", "creatething", "setname", "setdescription",
                    "addexit", "setdestination", "addkeyword", "createitem", "get", "drop",
                    "inventory", "inv", "i"
            };
            System.out.println(String.join("\n  ", adminCommands));
            System.out.println();
        } else {
            System.out.println("Useful commands:\n" +
                    "  help                       This output\n" +
                    "  movething <thing> <place>  Used to place an object in the world, including the player\n" +
                    "  look [keyword]             Look at the current room or named object\n" +
                    "  go <exit>                  Go to the named exit\n" +
                    "  exit                       Quit the game\n" +
                    "\ntry \"help admin\" for a list of world-building commands");
            System.out.println();
        }
    }
}
