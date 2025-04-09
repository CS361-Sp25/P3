package tm;

import java.util.Set;

/**
 * An interface for a deterministic Turing Machine with one start
 * state and one final state.
 *
 * @author Jayce Lowry
 */
public interface TMInterface {

    /**
     * Enum representing possible movement directions for the
     * read/write head.
     */
    public enum Direction {LEFT, RIGHT};

    /**
     * Runs a simulation of this Turing Machine with a given
     * String input.
     *
     * @param inputString the input string.
     * @return a string containing the contents of the tape
     * cells visited during the simulation.
     */
    public String run(String inputString);

    /**
     * Adds a new state with a given name
     * to this Turing Machine.
     *
     * @param name the name of the state.
     * @return true if the new state was added, false if
     * the state already exists.
     */
    public boolean addState(String name);

    /**
     * Adds a transition between two states in this
     * Turing Machine, which includes a symbol to read
     * from the tape, a symbol to write to the tape, and
     * a direction to move the read/write head.
     *
     * @param fromState the state to transition from.
     * @param toState the state to transition to.
     * @param readSymb the symbol to read from the tape.
     * @param writeSymb the symbol to write to the tape.
     * @param move the direction to move the read/write head.
     * @return true if successful, false if the states don't exist or if
     * the read or write symbols are not in the tape alphabet.
     */
    public boolean addTransition(TMState fromState, TMState toState, char readSymb, char writeSymb, Direction move);

    /**
     * Marks a state with a given name as the initial state.
     *
     * @param name the name of the state to mark as initial.
     * @return true if successful, false if a state with the
     * given name does not exist.
     */
    public boolean setStart(String name);

    /**
     * Marks a state with a given name as the accepting state.
     *
     * @param name the name of the state to mark as final.
     * @return true if successful, false if a state with the
     * given name does not exist.
     */
    public boolean setFinal(String name);

    /**
     * Determines if a state with the given name is an initial
     * state.
     *
     * @param name the name of the state.
     * @return true if a state with the given
     * name exists and is the initial state.
     */
    public boolean isStart(String name);

    /**
     * Determines if a state with the given name is the final
     * state.
     *
     * @param name the name of the state.
     * @return true if a state with the given
     * name exists and is the final state.
     */
    public boolean isFinal(String name);

    /**
     * Adds a symbol to the alphabet. The symbol
     * '0' is reserved for the blank symbol and will
     * not be added to the alphabet.
     *
     * @param symbol the symbol to add to the
     * alphabet.
     */
    public void addSigma(char symbol);

    /**
     * Gets the alphabet for this Turing Machine.
     *
     * @return the alphabet of this Turing Machine.
     */
    public Set<Character> getSigma();

    /**
     * Returns state with the given name, or null if
     * none exists.
     *
     * @param name the name of the state
     * @return TMState object or null if the state
     * doesn't exist.
     */
    public TMState getState(String name);
}