package tm;

/**
 * Represents a single transition in the machine. Within this is 
 * the next state, the element/symbol to write, and the direction 
 * to move. 
 * 
 * @author Chase Stombaugh
 */
public class TMTransition {
    private final TMState nextState;
    private final char writeSymbol;
    private final TMInterface.Direction direction;

    public TMTransition(TMState nextState, char writeSymbol, TMInterface.Direction direction) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }

    public TMState getNextState() {
        return nextState;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public TMInterface.Direction getDirection() {
        return direction;
    }
}
