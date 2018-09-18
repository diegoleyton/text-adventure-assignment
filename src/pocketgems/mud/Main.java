package pocketgems.mud;

public class Main {

	/*
	 * Main
	 * ====
	 * Optionally takes one argument, which is the file path for the file defining the initial game state.
	 */
	public static void main(String[] args) {
		String gameStateFileName = "";
		if (args.length > 0) {
			gameStateFileName = args[0];
		}

		CommandProvider commandProvider = new CommandProvider();
		IInputProcessor inputProcessor = new InputProcessor(commandProvider);
		Game game = new Game(inputProcessor, EntityFactory.createPlayer());

		commandProvider.SetDefaultCommands(game);
        game.loadState("worlds/world_basic_4");
		game.run();
	}
}
