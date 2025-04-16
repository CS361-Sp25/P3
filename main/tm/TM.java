package tm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * An implementation of the TMInterface.
 *
 * @author Jayce Lowry
 */
public class TM implements TMInterface {
    private Set<TMState> states;
    private Set<Character> alphabet;
    private TMState startState;
    private TMState finalState;


    /**
     * Creates a new Turing Machine.
     */
    public TM() {
        states = new LinkedHashSet<>();
        alphabet = new LinkedHashSet<>();
        startState = finalState = null;
        alphabet.add('0');
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String run(String inputString) {
        if (inputString == null || startState == null || finalState == null) {
            return "";
        }
        TMTape tape = new TMTape(inputString);
        TMState currentState = startState;
        boolean isHalted = false;

        while (!isHalted) {
            char readSymb = tape.read();
            TMTransition transition = currentState.getTransition(readSymb);
            if (transition == null) {
                isHalted = true;
                continue;
            }
            tape.write(transition.getWriteSymbol());
            tape.move(transition.getDirection());
            currentState = transition.getNextState();
            if (currentState == finalState) {
                isHalted = true;
            }
        }

        return tape.getVisited();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addState(String name) {
        if (name == null || getState(name) != null) {
            return false;
        }
        TMState state = new TMState(name);
        states.add(state);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addTransition(String fromState, String toState, char readSymb, char writeSymb, Direction move) {
        TMState from = getState(fromState);
        TMState to = getState(toState);

        if (to == null || from == null || !alphabet.contains(readSymb) || !alphabet.contains(writeSymb)) {
            return false;
        }
        from.setTransition(to, readSymb, writeSymb, move);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setStart(String name) {
        TMState state = getState(name);
        if (state == null) {
            return false;
        }
        startState = state;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setFinal(String name) {
        TMState state = getState(name);
        if (state == null) {
            return false;
        }
        finalState = state;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStart(String name) {
        return startState != null && startState.getName().equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFinal(String name) {
        return finalState != null && finalState.getName().equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSigma(char symbol) {
        if (symbol == '0') {
            return;
        }
        alphabet.add(symbol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Character> getSigma() {
        Set<Character> retSet = new LinkedHashSet<>(alphabet);
        retSet.remove('0');
        return retSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TMState getState(String name) {
        if (name == null) {
            return null;
        }
        for (TMState state : states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }
}