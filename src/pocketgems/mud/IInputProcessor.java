package pocketgems.mud;

import pocketgems.mud.components.DescriptionComponent;
import pocketgems.mud.components.IdentityComponent;
import pocketgems.mud.components.LocationComponent;
import pocketgems.mud.components.RoomComponent;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * InputProcessor
 * ==============
 * Processes input, which is either entered into the command line during game play, or read
 * from a text file when loading a game state. An input usually consists of a single token
 * command, sometimes followed by arguments. For example, "go north".
 * 
 * Both world creation and game play are handled through inputs.
 */
public interface IInputProcessor {
	void processInput(String input);
}
