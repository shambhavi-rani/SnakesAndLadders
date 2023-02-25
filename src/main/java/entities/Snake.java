/*
* GameBoard
*   1-* snake
*   1-* ladder
*   1-* player
*   1-1 game
*
* Snake
* Ladder
* Player
* Dice
* Game
*
* APIs:
* add ladders to board
* add snakes to board
* add players to game
* start game
* check if game over
* player turn -> roll dice, move for given player
* one turn for all -> every player moves one turn
* */

package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Snake {
    private int Head;
    private int Tail;
}
