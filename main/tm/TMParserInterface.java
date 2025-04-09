package tm;

/**
 * An interface for a file parser that processes file-encoded deterministic
 * Turing Machines. The expected format for an encoded Turing Machine is as
 * follows:
 *
 * 1. First Line: An integer `q` representing the number of states in the
 * Turing Machine.
 *
 * 2. Second Line: An integer `n` representing the number of alphabet symbols.
 *
 * 3. Next (q - 1) x (n + 1) Lines: For each state q (except the final accepting state),
 * there are n + 1 lines that encode transitions on symbols 0, 1, ..., n. State transition
 * information is in a CSV format with the following fields:
 * - `next_state`: The state to transition to.
 * - `write_symbol`: The symbol to write to the tape.
 * - `move`: The direction to move the read/write head ('L' for left, 'R' for right).
 *
 * 4. Final Line: A String that represents the input for the Turing Machine, or blank if
 * the input string is the empty string.
 *
 * @author Jayce Lowry
 */
public interface TMParserInterface {

    /**
     * Gets the Turing Machine created by this parser.
     *
     * @return an instance of the Turing Machine, constructed
     * from a parsed file.
     */
    public TMInterface getMachine();

    /**
     * Gets the input string processed by this parser.
     *
     * @return the input string.
     */
    public String getInputString();
}