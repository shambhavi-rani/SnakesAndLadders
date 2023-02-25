package entities;

import entities.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class GameBoard {
    private int Size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public GameBoard(){
        this.setSnakes(new HashMap<>());
        this.setLadders(new HashMap<>());
        this.setSize(Constants.BOARD_SIZE);
    }

    public GameBoard(List<Snake> snakes, List<Ladder> ladders){
        AddLadders(ladders);
        AddSnakes(snakes);
    }

    public void AddSnakes(List<Snake> snakes){
        for (Snake snake: snakes) {
            addSnake(snake);
        }
    }

    public void AddLadders(List<Ladder> ladders){
        for(Ladder ladder: ladders){
            addLadder(ladder);
        }
    }

    public void addSnake(Snake snake){
        InitializeSnakesIfNull();
        snakes.put(snake.getHead(), snake.getTail());
    }

    public void addLadder(Ladder ladder){
        InitializeLaddersIfNull();
        ladders.put(ladder.getBottom(), ladder.getTop());
    }

    private void InitializeSnakesIfNull() {
        if(snakes == null){
            snakes = new HashMap<>();
        }
    }

    private void InitializeLaddersIfNull() {
        if(ladders == null){
            ladders = new HashMap<>();
        }
    }
}
