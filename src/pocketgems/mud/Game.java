package pocketgems.mud;

import java.io.Console;
import java.util.Scanner;

/*
 * Game is a top level class that contains the game loop and the game state. Nothing related to
 * game logic and state should retain a reference to Game. Instead pass a reference to Game as
 * a method parameter, as needed.
 */
public class Game {

	public boolean isRunning;
	private World world;
	private IInputProcessor inputProcessor;
	
	public Game(IInputProcessor inputProcessor, Entity player) {
		this.inputProcessor = inputProcessor;
		world = new World(player);

		isRunning = false;
	}

    public void loadState(String gameStateFileName) {
        if (!gameStateFileName.equals("")) {
            inputProcessor.processInput("load " + gameStateFileName);
        }
    }
	
	public void run() {
		inputProcessor.processInput("look");

		isRunning = true;
		Scanner scanner = new Scanner(System.in);
		
		// Game loop.
		while (isRunning) {
			System.out.print("> ");
			String input = scanner.nextLine();
			inputProcessor.processInput(input);
		}

		scanner.close();
	}
	
	public World getWorld() {
		return world;
	}
	
	public IInputProcessor getInputProcessor() {
		return inputProcessor;
	}
}
