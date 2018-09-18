package pocketgems.mud.commands;

import pocketgems.mud.Game;

import java.util.ArrayList;

public class Exit extends BaseCommand {
    public Exit(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) {
        game.isRunning = false;
    }
}
