package pocketgems.mud.exceptions;

/*
 * CommandNotFoundException
 * ======
 * Thrown when a user tries to execute a command that does not exist.
 */
public class CommandNotFoundException extends Exception {
	private String commandName;

	public CommandNotFoundException(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}
}
