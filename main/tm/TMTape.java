package tm;

/**
 * An implementation of the TMTapeInterface.
 *
 * @author
 */
public class TMTape implements TMTapeInterface {

    /**
     * Creates a new TMTape with a given string.
     *
     * @param inputString the string on this TMTape.
     */
    public TMTape(String inputString) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char read() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(char symbol) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(TMInterface.Direction direction) {

    }

    /**
     * {@inheritDoc}
     */
    public String getVisited() {
        return "";
    }
}