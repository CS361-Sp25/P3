package tm;

import java.io.File;

/**
 * An implementation of the TMParserInterface.
 *
 * @author Jayce Lowry
 */
public class TMParser implements TMParserInterface {

    /**
     * TODO Docs
     *
     * @param file the file to parse.
     */
    public TMParser(File file) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TM getMachine() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInputString() {
        return "";
    }
}