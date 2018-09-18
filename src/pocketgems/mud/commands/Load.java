package pocketgems.mud.commands;

import pocketgems.mud.Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Load extends BaseCommand {
    public Load(Game game) {
        super(game);
    }

    public void execute(ArrayList<String> arguments) {
        try {
            FileReader fileReader = new FileReader(arguments.get(0));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                getInputProcessor().processInput(input);
            }

            bufferedReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: " + arguments.get(0));
        } catch (IOException exception) {
            System.out.println("Error reading file: " + arguments.get(0));
        }
    }
}
