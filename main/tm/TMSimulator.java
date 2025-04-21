package tm;

import java.io.File;

/**
 * Simulates a deterministic Turing Machine, constructed
 * from an encoded file.
 *
 * @author Jayce Lowry
 */
public class TMSimulator {
    private final String PROGRAM_NAME = this.getClass().getName();
    private final String USAGE = "Usage: java " + PROGRAM_NAME + " <filename>\n" +
            "       <filename>: The name of a file containing\n" +
            "                   an encoded Turing Machine";

    private File inputFile;
    private TM machine;
    private String input;

    /**
     * Creates a new TMSimulator.
     *
     * @param args command-line arguments
     */
    public TMSimulator(String[] args) {
        if (!parseArgs(args)) {
            System.err.println(USAGE);
            System.exit(1);
        }

        try {
            TMParser parser = new TMParser(inputFile);
            machine = parser.getMachine();
            input = parser.getInputString();
        } catch (Exception e) {
            System.err.println("Error while parsing or initializing the Turing Machine:");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Runs the Turing Machine simulation and
     * outputs results to stdout.
     */
    public void runSimulation() {
        String results = machine.run(input);
        System.out.println(results);
    }

    /**
     * Parses command-line arguments.
     *
     * @param args command-line arguments.
     * @return true if parsing succeeded,
     * false otherwise.
     */
    private boolean parseArgs(String[] args) {
        if (args.length != 1) {
            return false;
        }
        boolean retVal = true;
        String filename = args[0];

        inputFile = new File(filename);
        if (!inputFile.exists() || !inputFile.canRead() || inputFile.isDirectory()) {
            retVal = false;
            System.err.println("File \"" + filename + "\" does not exist or is inaccessible");
        }
        return retVal;
    }

    public static void main(String[] args) {
        TMSimulator simulator = new TMSimulator(args);
        simulator.runSimulation();
    }
}