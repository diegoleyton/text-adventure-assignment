package pocketgems.mud.commands;

import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public interface ICommand {
    void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException;
    void execute() throws ComponentNotFoundException, EntityNotFoundException;
}
