package input;

import entities.Ladder;
import entities.Snake;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Input {
    private int numberOfSnakes;
    private int numberOfLadders;
    private List<Snake> snakePositions;
    private List<Ladder> ladderPositions;
    private int numberOfPlayers;
    private List<String> players;
}
