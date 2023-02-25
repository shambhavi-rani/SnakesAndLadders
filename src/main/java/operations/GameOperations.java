package operations;

import entities.*;
import entities.constants.Constants;
import exceptions.InvalidGameStateException;
import input.Input;

import java.util.*;

public class GameOperations {
    public static Game createNewGame(Input input){
        List<Player> players = getPlayersFromNames(input.getPlayers());
        GameBoard board = new GameBoard(input.getSnakePositions(), input.getLadderPositions());
        Game game = new Game(board, players);
        return game;
    }

    private static List<Player> getPlayersFromNames(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String name: playerNames){
            players.add(new Player(UUID.randomUUID(), name));
        }
        return players;
    }

    public static void startGame(Game game){
        ValidateGameState(game);
        while(!isGameOver(game.getState())){
            game = playTurnForAllPlayers(game);
        }
    }

    private static Game playTurnForAllPlayers(Game game) {
        for(Player player: game.getPlayers()){
            if(isGameOver(game.getState())) return game;
            game = playTurnForPlayer(game, player);
            game = checkIfGameFinished(game, player);
        }
        return game;
    }

    private static Game checkIfGameFinished(Game game, Player player){
        if(didPlayerWin(game.getPlayerPositions(), player.getId())){
            game.setState(GameState.FINISHED);
            printPlayerWins(player.getName());
        }
        return game;
    }

    private static void printPlayerWins(String playerName) {
        System.out.println(playerName + " wins the game");
    }

    private static Game playTurnForPlayer(Game game, Player player) {
        int currentPosition = game.getPlayerPositions().get(player.getId());
        int diceRoll = game.getDice().roll();
        int newPosition = getNewPositionAfterDiceRoll(diceRoll, currentPosition);
        game.setPlayerPosition(player.getId(), newPosition);
        printPlayerMove(player.getName(), diceRoll, currentPosition, newPosition);
        return game;
    }

    private static void printPlayerMove(String playerName, int diceRoll, int currentPosition, int newPosition) {
        System.out.println(playerName
                + " rolled a "
                + diceRoll
                + " and moved from "
                + currentPosition
                +" to "
                + newPosition);
    }

    private static int getNewPositionAfterDiceRoll(int diceRoll, int currentPosition) {
        if(diceRoll + currentPosition <= Constants.BOARD_SIZE){
            return currentPosition + diceRoll;
        }
        return currentPosition;
    }

    private static boolean didPlayerWin(Map<UUID, Integer> playerPositions, UUID playerId) {
        return playerPositions.get(playerId) == Constants.BOARD_SIZE;
    }

    private static boolean isGameOver(GameState state) {
        return state == GameState.FINISHED;
    }

    private static void ValidateGameState(Game game) {
        if(game.getState() != GameState.NOT_STARTED){
            throw new InvalidGameStateException();
        }
    }
}
