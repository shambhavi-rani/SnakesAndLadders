package input;

import entities.Ladder;
import entities.Snake;
import exceptions.InvalidUserInputException;

import java.util.*;

public class CommandLineInputMode implements InputMode{
    @Override
    public Input processInput() {
        Input input = new Input();
        Scanner in = new Scanner(System.in);
        try{
            //get snakes
            input = getSnakePositions(input, in);
            //get ladders
            input = getLadderPositions(input, in);
            //get players
            input = getPlayers(input, in);
        }
        catch (Exception e){
            throw new InvalidUserInputException(e);
        }
        return input;
    }

    private Input getSnakePositions(Input input, Scanner in) {
        int snakesCount = Integer.parseInt(in.nextLine());
        input.setNumberOfSnakes(snakesCount);
        List<Snake> snakes = getSnakes(in, snakesCount);
        input.setSnakePositions(snakes);
        return input;
    }

    private static List<Snake> getSnakes(Scanner in, int snakesCount) {
        List<Snake> snakes = new ArrayList<>();
        for(int i = 0; i< snakesCount; ++i){
            int head = Integer.parseInt(in.nextLine());
            int tail = Integer.parseInt(in.nextLine());
            snakes.add(new Snake(head, tail));
        }
        return snakes;
    }
    private Input getLadderPositions(Input input, Scanner in) {
        int laddersCount = Integer.parseInt(in.nextLine());
        input.setNumberOfLadders(laddersCount);
        List<Ladder> ladders = getLadders(in, laddersCount);
        input.setLadderPositions(ladders);
        return input;
    }

    private static List<Ladder> getLadders(Scanner in, int laddersCount) {
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i< laddersCount; ++i){
            int bottom = Integer.parseInt(in.nextLine());
            int top = Integer.parseInt(in.nextLine());
            ladders.add(new Ladder(bottom, top));
        }
        return ladders;
    }

    private Input getPlayers(Input input, Scanner in) {
        int playersCount = Integer.parseInt(in.nextLine());
        input.setNumberOfPlayers(playersCount);

        List<String> players = getPlayerNames(in, playersCount);
        input.setPlayers(players);
        return input;
    }

    private static List<String> getPlayerNames(Scanner in, int playersCount) {
        List<String> players = new ArrayList<>();
        for(int i = 0; i< playersCount; ++i){
            String player = in.nextLine();
            players.add(player);
        }
        return players;
    }
}
