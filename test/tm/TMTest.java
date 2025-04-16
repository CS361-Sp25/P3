package tm;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for a Turing Machine
 *
 * @author Jayce Lowry
 */
public class TMTest {

    @Test
    public void testMachine1() {
        TM machine = new TM();
        assertTrue(machine.addState("0"));
        assertTrue(machine.addState("1"));
        assertTrue(machine.addState("2"));
        assertTrue(machine.addState("3"));

        assertTrue(machine.setStart("0"));
        assertTrue(machine.setFinal("3"));

        machine.addSigma('1');

        assertTrue(machine.addTransition("0", "1", '0', '1', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("0", "2", '1', '1', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("1", "0", '0', '1', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("1", "1", '1', '1', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("2", "1", '0', '1', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("2", "3", '1', '1', TMInterface.Direction.RIGHT));

        assertEquals("111111", machine.run(""));
    }

    @Test
    public void testMachine2() {
        TM machine = new TM();
        for (int i = 0; i < 5; i++) {
            assertTrue(machine.addState(Integer.toString(i)));
        }
        assertTrue(machine.setStart("0"));
        assertTrue(machine.setFinal("4"));

        for (int i = 1; i <= 3; i++) {
            machine.addSigma(Character.forDigit(i, 10));
        }

        assertTrue(machine.addTransition("0", "2", '0', '1', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("0", "4", '1', '2', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("0", "1", '2', '0', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("0", "3", '3', '0', TMInterface.Direction.LEFT));

        assertTrue(machine.addTransition("1", "3", '0', '3', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("1", "3", '1', '3', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("1", "3", '2', '3', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("1", "1", '3', '1', TMInterface.Direction.RIGHT));

        assertTrue(machine.addTransition("2", "1", '0', '3', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("2", "2", '1', '3', TMInterface.Direction.LEFT));
        assertTrue(machine.addTransition("2", "0", '2', '1', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("2", "2", '3', '1', TMInterface.Direction.RIGHT));

        assertTrue(machine.addTransition("3", "0", '0', '1', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("3", "1", '1', '0', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("3", "0", '2', '2', TMInterface.Direction.RIGHT));
        assertTrue(machine.addTransition("3", "2", '3', '2', TMInterface.Direction.RIGHT));

        String expected = "03123333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333";

        assertEquals(expected, machine.run(""));
    }

    @Test
    public void testMachine3() {
        TM machine = new TM();

        for (int i = 0; i < 4; i++) {
            assertTrue(machine.addState(Integer.toString(i)));
        }
        assertTrue(machine.setStart("0"));
        assertTrue(machine.setFinal("3"));

        for (int i = 1; i <= 3; i++) {
            machine.addSigma(Character.forDigit(i, 10));
        }

        machine.addTransition("0", "1", '0', '3', TMInterface.Direction.RIGHT);
        machine.addTransition("0", "0", '1', '0', TMInterface.Direction.RIGHT);
        machine.addTransition("0", "2", '2', '0', TMInterface.Direction.LEFT);
        machine.addTransition("0", "2", '3', '2', TMInterface.Direction.LEFT);

        machine.addTransition("1", "2", '0', '1', TMInterface.Direction.LEFT);
        machine.addTransition("1", "2", '1', '0', TMInterface.Direction.RIGHT);
        machine.addTransition("1", "1", '2', '3', TMInterface.Direction.LEFT);
        machine.addTransition("1", "2", '3', '2', TMInterface.Direction.RIGHT);

        machine.addTransition("2", "0", '0', '3', TMInterface.Direction.RIGHT);
        machine.addTransition("2", "1", '1', '0', TMInterface.Direction.RIGHT);
        machine.addTransition("2", "3", '2', '3', TMInterface.Direction.RIGHT);
        machine.addTransition("2", "1", '3', '0', TMInterface.Direction.LEFT);

        String out = machine.run("");

        assertEquals(20430, out.length());
        assertEquals(47189, sumString(out));
    }

    /**
     * Sums the characters in a given string.
     * Characters are assumed to be numerical digits.
     *
     * @param input a string of numerical digits.
     * @return the sum of numerical digits in the string.
     */
    private int sumString(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            sum += digit;
        }
        return sum;
    }
}