package tm;

import java.util.Set;

/**
 * An implementation of the TMInterface.
 *
 * @author
 */
public class TM implements TMInterface {

    /**
     * Creates a new Turing Machine.
     */
    public TM() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String run(String inputString) {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addState(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addTransition(TMState fromState, TMState toState, char readSymb, char writeSymb, Direction move) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setStart(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setFinal(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStart(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFinal(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSigma(char symbol) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Character> getSigma() {
        return Set.of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TMState getState(String name) {
        return null;
    }
}