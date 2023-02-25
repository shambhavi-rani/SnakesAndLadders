package entities.dice.context;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiceContext {
    private DiceRollStrategy diceRollStrategy;

    public DiceContext(DiceRollStrategy diceRollStrategy) {
        this.diceRollStrategy = diceRollStrategy;
    }

    public int roll(){
        return diceRollStrategy.roll();
    }
}
