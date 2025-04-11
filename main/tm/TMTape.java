package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the TMTapeInterface for a bi-infinite tape. This
 * tape can read and write characters and move the head left and right 
 * indefinitely in both directions. The tape is initialized with a string
 * input starting at index 0. Unvisited cells default to the blank symbol 0.
 *
 * @author Jayce Lowry and Chase Stombaugh
 */
public class TMTape implements TMTapeInterface {
    
    private final Map<Integer, Character> tape; //stores the tape values
    private int head;
    private int minVisited;
    private int maxVisited;

    /**
     * Creates a new TMTape with a given string.
     *
     * @param inputString the string on this TMTape.
     */
    public TMTape(String inputString) {
        tape = new HashMap<>();
        head = 0;
        minVisited = 0;
        maxVisited = 0;

        // populating the tape with the given input string
        for (int i = 0; i < inputString.length(); i++) {
            tape.put(i, inputString.charAt(i));
            maxVisited = i;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char read() {
        return tape.getOrDefault(head, '0');
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(char symbol) {
        tape.put(head, symbol);
        updateBounds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(TMInterface.Direction direction) {
        if (direction == TMInterface.Direction.LEFT) {
            head--;
        } else { 
            head++;
        } 
        updateBounds();
    }

    /**
     * {@inheritDoc}
     */
    public String getVisited() {
        StringBuilder visited = new StringBuilder();
        for (int i = minVisited; i <= maxVisited; i++) {
            visited.append(tape.getOrDefault(i, '0'));
        }
        return visited.toString();
    }

    /**
     * Updates the bounds for the visited cells in the tape
     */
    private void updateBounds() {
        if (head < minVisited) {
            minVisited = head;
        }
        if (head > maxVisited) {
            maxVisited = head;
        }
    }
}