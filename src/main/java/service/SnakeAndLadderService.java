package service;

import entities.Game;
import input.Input;
import operations.GameOperations;
import operations.ServiceOperations;

public class SnakeAndLadderService {
    public static void main(String[] args) {
        System.out.println("Welcome to Snakes and Ladders!");
        Input input = ServiceOperations.processFileOrCommandInput(args);

        //create game
        Game game = GameOperations.createNewGame(input);

        //start game
        GameOperations.startGame(game);
    }
}
