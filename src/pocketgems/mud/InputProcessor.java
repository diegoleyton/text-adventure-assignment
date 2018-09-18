package pocketgems.mud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pocketgems.mud.commands.ICommand;
import pocketgems.mud.components.*;
import pocketgems.mud.exceptions.*;

/*
 * InputProcessor
 * ==============
 * Processes input, which is either entered into the command line during game play, or read
 * from a text file when loading a game state. An input usually consists of a single token
 * command, sometimes followed by arguments. For example, "go north".
 * 
 * Both world creation and game play are handled through inputs.
 */
public class InputProcessor implements IInputProcessor {
	private CommandProvider commandProvider;

	public InputProcessor(CommandProvider commandProvider) {
		this.commandProvider = commandProvider;
	}

	public void processInput(String input) {
		if (input.equals("") || input.equals("exit")) {
            try {
                this.commandProvider.get(input).execute();
            } catch (CommandNotFoundException e) {
                System.out.println("Unrecognized command: " + e.getCommandName());
                System.out.println("Type 'help' for a full list of commands");
                System.out.println();
		    } catch (Exception e) {
                System.out.println("Something unexpected happened processing the command: " + input);
                System.out.println();
            }
        } else {
			String regex = "\"([^\"]*)\"|(\\S+)";

			ArrayList<String> tokens = new ArrayList<String>();
			Matcher matcher = Pattern.compile(regex).matcher(input);
			while (matcher.find()) {
				if (matcher.group(1) != null) {
					tokens.add(matcher.group(1));
				} else {
					tokens.add(matcher.group(2));
				}
			}

			if (tokens.size() > 0) {
				String command = tokens.get(0);
				tokens.remove(0);
				
				try {
                    this.commandProvider.get(command).execute(tokens);
				} catch (CommandNotFoundException e) {
                    System.out.println("Unrecognized command: " + e.getCommandName());
                    System.out.println("Type 'help' for a full list of commands");
                    System.out.println();
                }
				catch (EntityNotFoundException e) {
					System.out.println("The entity '" + e.getEntityId() + "' could not be understood");
					System.out.println();
				} catch (ComponentNotFoundException e) {
					IdentityComponent identityComponent = e.getEntity().getComponentOrNull(IdentityComponent.class);
					String entityId = identityComponent != null ? identityComponent.id : "<unknown>";
					String componentName = e.getComponentType().getSimpleName();
					System.out.println("The entity '" + entityId + "' is missing '" + componentName + "'");
					System.out.println();
				} catch (Exception exception) {
					System.out.println("Something unexpected happened processing command: " + command);
					System.out.println();
				}
			}
		}
	}
}
