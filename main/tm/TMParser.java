package tm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * An implementation of the TMParserInterface.
 * Parses a TM input file then builds the TM and input string 
 * that correspond with the file
 *
 * @author Jayce Lowry and Chase Stombaugh
 */
public class TMParser implements TMParserInterface {

    private final TM tm;
    private final String inputString;
    
    /**
     * Constructs a parser that reads and then builds the Turing Machine from
     * the input file.
     *
     * @param file the file to parse.
     */
    public TMParser(File file) {
        TM machine = new TM();
        String input = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int numStates = Integer.parseInt(reader.readLine().trim());
            int numAlphabet = Integer.parseInt(reader.readLine().trim());
            int tapeSymbols = numAlphabet + 1;

            // Adding the states
            for (int i = 0; i < numStates; i++) {
                machine.addState(String.valueOf(i));
            }

            // Start/final states
            machine.setStart("0");
            machine.setFinal(String.valueOf(numStates - 1));

            // Adding the input alphabet symbols 
            for (int i = 0; i < numAlphabet; i++) {
                machine.addSigma((char)(i + '0'));
            }

            // Parsing the transitions
            for (int i = 0; i < (numStates - 1) * tapeSymbols; i++) {
                String line = reader.readLine().trim();
                if (line.isEmpty()) continue;

                String[] stringParts = line.split(",");
                int fromStateIndex = i / tapeSymbols;
                int readSymbolIndex = i % tapeSymbols;

                String from = String.valueOf(fromStateIndex);
                String to = stringParts[0];
                char write = stringParts[1].charAt(0);
                TMInterface.Direction direction = stringParts[2].equals("L")
                    ? TMInterface.Direction.LEFT : TMInterface.Direction.RIGHT;
                char read = (char)(readSymbolIndex + '0');

                machine.addTransition(from, to, read, write, direction);
            }

            // Read the final input line
            String lastLine = null;
            while ((lastLine = reader.readLine()) != null) {
                if (!lastLine.trim().isEmpty()) {
                    input = lastLine.trim();
                    break;
                }
            }

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("There was an error parsing TM input file: " + e.getMessage());
            System.exit(1);
        }

        this.tm = machine;
        this.inputString = input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TM getMachine() {
        return tm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInputString() {
        return inputString;
    }
}