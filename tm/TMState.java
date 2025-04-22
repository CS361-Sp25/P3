package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single state for a Turing Machine.
 *
 * @author Jayce Lowry
 */
public class TMState {
    private Map<Character, TMTransition> transitions;
    private String name;

    /**
     * Creates a new TMState with a given name.
     *
     * @param name the label for this TMState.
     */
    public TMState(String name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    /**
     * @return the name of this TMState.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this TMState to transition to another state when
     * a particular symbol is read from the tape, and to
     * perform a write and move action on the tape.
     *
     * @param toState the state to transition to.
     * @param readSymb the symbol read from the tape.
     * @param writeSymb the symbol to write to the tape.
     * @param move the direction to move on the tape.
     */
    public void setTransition(TMState toState, char readSymb, char writeSymb, Direction move) {
        if (toState == null) {
            return;
        }
        TMTransition transition = new TMTransition(toState, writeSymb, move);
        transitions.put(readSymb, transition);
    }

    /**
     * Gets the TMState to transition to when a given symbol
     * is read.
     *
     * @param readSymb the symbol read from the tape.
     * @return the state to transition to, or null if no
     * transition on the given symbol exists.
     */
    public TMState getTransitionState(char readSymb) {
        TMTransition transitionData = transitions.get(readSymb);
        return (transitionData == null) ? null : transitionData.getNextState();
    }

    /**
     * Gets the symbol to write to the tape when a given
     * symbol is read.
     *
     * @param readSymb the symbol to read from the tape.
     * @return the symbol to write to the tape, or null if no
     * transition on the given symbol exists.
     */
    public Character getWriteSymbol(char readSymb) {
        TMTransition transitionData = transitions.get(readSymb);
        return (transitionData == null) ? null : transitionData.getWriteSymbol();
    }

    /**
     * Gets the direction to move the read/write head for the tape
     * when a given symbol is read.
     *
     * @param readSymb the symbol to read from the tape.
     * @return the direction to move, or null if no transition
     * on the given symbol exists.
     */
    public Direction getMoveDirection(char readSymb) {
        TMTransition transitionData = transitions.get(readSymb);
        return (transitionData == null) ? null : transitionData.getDirection();
    }

    /**
     * Represents a single transition in the machine. Within this is
     * the next state, the element/symbol to write, and the direction
     * to move.
     *
     * @author Chase Stombaugh
     */
    private class TMTransition {
        private final TMState nextState;
        private final char writeSymbol;
        private final Direction direction;

        /**
         * Creates a new TMTransition
         *
         * @param nextState the state to transition to.
         * @param writeSymbol the symbol to write to the tape.
         * @param direction the direction to move on the tape.
         */
        private TMTransition(TMState nextState, char writeSymbol, Direction direction) {
            this.nextState = nextState;
            this.writeSymbol = writeSymbol;
            this.direction = direction;
        }

        /**
         * @return the next state.
         */
        private TMState getNextState() {
            return nextState;
        }

        /**
         * @return the symbol to write to the tape.
         */
        private char getWriteSymbol() {
            return writeSymbol;
        }

        /**
         * @return the direction to move on the tape.
         */
        private Direction getDirection() {
            return direction;
        }
    }
}