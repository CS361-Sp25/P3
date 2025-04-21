package tm;

/**
 * Represents the tape for a Turing Machine, which has a
 * read/write head capable of moving left or right on the
 * tape.
 *
 * @author Jayce Lowry
 */
public interface TMTapeInterface {

    /**
     * Reads the contents of the current tape
     * cell.
     *
     * @return the character in the current
     * tape cell.
     */
    char read();

    /**
     * Writes a given symbol to the current
     * tape cell.
     *
     * @param symbol the character to write.
     */
    void write(Character symbol);

    /**
     * Moves the read/write head for this tape
     * to one adjacent cell in a given direction.
     *
     * @param direction the direction to move, which
     * is either left or right.
     */
    void move(Direction direction);

    /**
     * Gets the contents of visited tape cells, starting
     * from the leftmost visited cell and ending at the
     * rightmost visited cell.
     *
     * @return a String containing the contents of cells
     * that have been visited by the read/write head.
     */
    String getVisited();
}