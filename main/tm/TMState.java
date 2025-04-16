package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single state for a deterministic Turing Machine.
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
    public void setTransition(TMState toState, char readSymb, char writeSymb, TMInterface.Direction move) {
        if (toState == null) {
            return;
        }
        TMTransition transition = new TMTransition(toState, writeSymb, move);
        transitions.put(readSymb, transition);
    }

    /**
     * Gets the transition data for this TMState on
     * a particular read symbol.
     *
     * @param readSymb the symbol read from the tape.
     * @return the transition information for this
     * TMState.
     */
    public TMTransition getTransition(char readSymb) {
        return transitions.get(readSymb);
    }
}