package entities.dice.context;

import java.util.Random;

public class SingleDiceRandomRollStrategy implements DiceRollStrategy {
    private Random rand = new Random();
    public int roll(){
        return 1 + rand.nextInt(6);
    }
}
