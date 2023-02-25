package entities;

import entities.dice.context.DiceContext;
import entities.dice.context.SingleDiceRandomRollStrategy;
import exceptions.InvalidPlayerException;
import exceptions.NoPlayersFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private GameBoard board;
    private List<Player> Players;
    private Map<UUID, Integer> PlayerPositions;
    private GameState state;
    private Player Winner;
    private DiceContext dice;

    public Game(GameBoard board, List<Player> players){
        this.board = board;
        this.Players = players;
        InitializePlayerPositions();
        this.state = GameState.NOT_STARTED;
        this.dice = new DiceContext(new SingleDiceRandomRollStrategy());
    }

    private void InitializePlayerPositions() {
        if(Players == null){
            throw new NoPlayersFoundException();
        }
        this.PlayerPositions = new HashMap<>();
        for (Player player: Players){
            PlayerPositions.put(player.getId(), 0);
        }
    }

    public void setPlayerPosition(UUID playerId, int newPosition){
        validatePlayerId(playerId);
        PlayerPositions.put(playerId, newPosition);
    }

    private void validatePlayerId(UUID playerId) {
        if(!PlayerPositions.containsKey(playerId))
        {
            throw new InvalidPlayerException();
        }
    }
}
