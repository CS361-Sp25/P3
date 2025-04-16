package tm;

/**
 * Represents a single transition in the machine. Within this is
 * the next state, the element/symbol to write, and the direction
 * to move.
 *
 * @author Chase Stombaugh, Jayce Lowry
 */
public class TMTransition {
    private final TMState nextState;
    private final char writeSymbol;
    private final TMInterface.Direction direction;

    /**
     * Creates a new TMTransition
     *
     * @param nextState the state to transition to.
     * @param writeSymbol the symbol to write to the tape.
     * @param direction the direction to move on the tape.
     */
    public TMTransition(TMState nextState, char writeSymbol, TMInterface.Direction direction) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }

    /**
     * @return the next state.
     */
    public TMState getNextState() {
        return nextState;
    }

    /**
     * @return the symbol to write to the tape.
     */
    public char getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * @return the direction to move on the tape.
     */
    public TMInterface.Direction getDirection() {
        return direction;
    }
}
