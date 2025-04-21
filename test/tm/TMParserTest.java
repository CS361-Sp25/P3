package tm;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Unit tests for the file parser
 *
 * @author Jayce Lowry
 */
public class TMParserTest {

    @Test
    public void testParseMachine1() throws IOException {
        TMParser parser = new TMParser(new File("test/machines/file0.txt"));
        TM machine = parser.getMachine();
        String input = parser.getInputString();

        TMState state0 = machine.getState("0");
        TMState state1 = machine.getState("1");
        TMState state2 = machine.getState("2");
        TMState state3 = machine.getState("3");

        assertEquals("0", state0.getName());
        assertEquals("1", state1.getName());
        assertEquals("2", state2.getName());
        assertEquals("3", state3.getName());

        assertTrue(machine.isStart(state0.getName()));
        assertTrue(machine.isFinal(state3.getName()));

        // State 0, read '0'
        assertEquals(state1, state0.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state0.getWriteSymbol('0'));
        assertEquals(Direction.RIGHT, state0.getMoveDirection('0'));
        // State 0, read '1'
        assertEquals(state2, state0.getTransitionState('1'));
        assertEquals(Character.valueOf('1'), state0.getWriteSymbol('1'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('1'));

        // State 1, read '0'
        assertEquals(state0, state1.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state1.getWriteSymbol('0'));
        assertEquals(Direction.LEFT, state1.getMoveDirection('0'));
        // State 1, read '1'
        assertEquals(state1, state1.getTransitionState('1'));
        assertEquals(Character.valueOf('1'), state1.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state1.getMoveDirection('1'));

        // State 2, read '0'
        assertEquals(state1, state2.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state2.getWriteSymbol('0'));
        assertEquals(Direction.LEFT, state2.getMoveDirection('0'));
        // State 2, read '1'
        assertEquals(state3, state2.getTransitionState('1'));
        assertEquals(Character.valueOf('1'), state2.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('1'));

        // State 3, read '0'
        assertNull(state3.getTransitionState('0'));
        assertNull(state3.getWriteSymbol('0'));
        assertNull(state3.getMoveDirection('0'));
        // State 3, read '1'
        assertNull(state3.getTransitionState('1'));
        assertNull(state3.getWriteSymbol('1'));
        assertNull(state3.getMoveDirection('1'));

        assertEquals(Set.of('1'), machine.getSigma());

        assertEquals("", input);
    }

    @Test
    public void testParseMachine2() throws IOException {
        TMParser parser = new TMParser(new File("test/machines/file2.txt"));
        TM machine = parser.getMachine();
        String input = parser.getInputString();

        TMState state0 = machine.getState("0");
        TMState state1 = machine.getState("1");
        TMState state2 = machine.getState("2");
        TMState state3 = machine.getState("3");
        TMState state4 = machine.getState("4");

        assertEquals("0", state0.getName());
        assertEquals("1", state1.getName());
        assertEquals("2", state2.getName());
        assertEquals("3", state3.getName());
        assertEquals("4", state4.getName());

        assertTrue(machine.isStart(state0.getName()));
        assertTrue(machine.isFinal(state4.getName()));

        // State 0, read '0'
        assertEquals(state2, state0.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state0.getWriteSymbol('0'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('0'));
        // State 0, read '1'
        assertEquals(state4, state0.getTransitionState('1'));
        assertEquals(Character.valueOf('2'), state0.getWriteSymbol('1'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('1'));
        // State 0, read '2'
        assertEquals(state1, state0.getTransitionState('2'));
        assertEquals(Character.valueOf('0'), state0.getWriteSymbol('2'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('2'));
        // State 0, read '3'
        assertEquals(state3, state0.getTransitionState('3'));
        assertEquals(Character.valueOf('0'), state0.getWriteSymbol('3'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('3'));

        // State 1, read '0'
        assertEquals(state3, state1.getTransitionState('0'));
        assertEquals(Character.valueOf('3'), state1.getWriteSymbol('0'));
        assertEquals(Direction.RIGHT, state1.getMoveDirection('0'));
        // State 1, read '1'
        assertEquals(state3, state1.getTransitionState('1'));
        assertEquals(Character.valueOf('3'), state1.getWriteSymbol('1'));
        assertEquals(Direction.LEFT, state1.getMoveDirection('1'));
        // State 1, read '2'
        assertEquals(state3, state1.getTransitionState('2'));
        assertEquals(Character.valueOf('3'), state1.getWriteSymbol('2'));
        assertEquals(Direction.LEFT, state1.getMoveDirection('2'));
        // State 1, read '3'
        assertEquals(state1, state1.getTransitionState('3'));
        assertEquals(Character.valueOf('1'), state1.getWriteSymbol('3'));
        assertEquals(Direction.RIGHT, state1.getMoveDirection('3'));

        // State 2, read '0'
        assertEquals(state1, state2.getTransitionState('0'));
        assertEquals(Character.valueOf('3'), state2.getWriteSymbol('0'));
        assertEquals(Direction.LEFT, state2.getMoveDirection('0'));
        // State 2, read '1'
        assertEquals(state2, state2.getTransitionState('1'));
        assertEquals(Character.valueOf('3'), state2.getWriteSymbol('1'));
        assertEquals(Direction.LEFT, state2.getMoveDirection('1'));
        // State 2, read '2'
        assertEquals(state0, state2.getTransitionState('2'));
        assertEquals(Character.valueOf('1'), state2.getWriteSymbol('2'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('2'));
        // State 2, read '3'
        assertEquals(state2, state2.getTransitionState('3'));
        assertEquals(Character.valueOf('1'), state2.getWriteSymbol('3'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('3'));

        // State 3, read '0'
        assertEquals(state0, state3.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state3.getWriteSymbol('0'));
        assertEquals(Direction.RIGHT, state3.getMoveDirection('0'));
        // State 3, read '1'
        assertEquals(state1, state3.getTransitionState('1'));
        assertEquals(Character.valueOf('0'), state3.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state3.getMoveDirection('1'));
        // State 3, read '2'
        assertEquals(state0, state3.getTransitionState('2'));
        assertEquals(Character.valueOf('2'), state3.getWriteSymbol('2'));
        assertEquals(Direction.RIGHT, state3.getMoveDirection('2'));
        // State 3, read '3'
        assertEquals(state2, state3.getTransitionState('3'));
        assertEquals(Character.valueOf('2'), state3.getWriteSymbol('3'));
        assertEquals(Direction.RIGHT, state3.getMoveDirection('3'));

        // State 4, read '0'
        assertNull(state4.getTransitionState('0'));
        assertNull(state4.getWriteSymbol('0'));
        assertNull(state4.getMoveDirection('0'));
        // State 4, read '1'
        assertNull(state4.getTransitionState('1'));
        assertNull(state4.getWriteSymbol('1'));
        assertNull(state4.getMoveDirection('1'));
        // State 4, read '2'
        assertNull(state4.getTransitionState('2'));
        assertNull(state4.getWriteSymbol('2'));
        assertNull(state4.getMoveDirection('2'));
        // State 4, read '3'
        assertNull(state4.getTransitionState('3'));
        assertNull(state4.getWriteSymbol('3'));
        assertNull(state4.getMoveDirection('3'));

        assertEquals(Set.of('1', '2', '3'), machine.getSigma());

        assertEquals("", input);
    }

    @Test
    public void testParseMachine3() throws IOException {
        TMParser parser = new TMParser(new File("test/machines/file5.txt"));
        TM machine = parser.getMachine();
        String input = parser.getInputString();

        TMState state0 = machine.getState("0");
        TMState state1 = machine.getState("1");
        TMState state2 = machine.getState("2");
        TMState state3 = machine.getState("3");

        assertEquals("0", state0.getName());
        assertEquals("1", state1.getName());
        assertEquals("2", state2.getName());
        assertEquals("3", state3.getName());

        assertTrue(machine.isStart(state0.getName()));
        assertTrue(machine.isFinal(state3.getName()));

        // State 0, read '0'
        assertEquals(state1, state0.getTransitionState('0'));
        assertEquals(Character.valueOf('3'), state0.getWriteSymbol('0'));
        assertEquals(Direction.RIGHT, state0.getMoveDirection('0'));
        // State 0, read '1'
        assertEquals(state0, state0.getTransitionState('1'));
        assertEquals(Character.valueOf('0'), state0.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state0.getMoveDirection('1'));
        // State 0, read '2'
        assertEquals(state2, state0.getTransitionState('2'));
        assertEquals(Character.valueOf('0'), state0.getWriteSymbol('2'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('2'));
        // State 0, read '3'
        assertEquals(state2, state0.getTransitionState('3'));
        assertEquals(Character.valueOf('2'), state0.getWriteSymbol('3'));
        assertEquals(Direction.LEFT, state0.getMoveDirection('3'));

        // State 1, read '0'
        assertEquals(state2, state1.getTransitionState('0'));
        assertEquals(Character.valueOf('1'), state1.getWriteSymbol('0'));
        assertEquals(Direction.LEFT, state1.getMoveDirection('0'));
        // State 1, read '1'
        assertEquals(state2, state1.getTransitionState('1'));
        assertEquals(Character.valueOf('0'), state1.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state1.getMoveDirection('1'));
        // State 1, read '2'
        assertEquals(state1, state1.getTransitionState('2'));
        assertEquals(Character.valueOf('3'), state1.getWriteSymbol('2'));
        assertEquals(Direction.LEFT, state1.getMoveDirection('2'));
        // State 1, read '3'
        assertEquals(state2, state1.getTransitionState('3'));
        assertEquals(Character.valueOf('2'), state1.getWriteSymbol('3'));
        assertEquals(Direction.RIGHT, state1.getMoveDirection('3'));

        // State 2, read '0'
        assertEquals(state0, state2.getTransitionState('0'));
        assertEquals(Character.valueOf('3'), state2.getWriteSymbol('0'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('0'));
        // State 2, read '1'
        assertEquals(state1, state2.getTransitionState('1'));
        assertEquals(Character.valueOf('0'), state2.getWriteSymbol('1'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('1'));
        // State 2, read '2'
        assertEquals(state3, state2.getTransitionState('2'));
        assertEquals(Character.valueOf('3'), state2.getWriteSymbol('2'));
        assertEquals(Direction.RIGHT, state2.getMoveDirection('2'));
        // State 2, read '3'
        assertEquals(state1, state2.getTransitionState('3'));
        assertEquals(Character.valueOf('0'), state2.getWriteSymbol('3'));
        assertEquals(Direction.LEFT, state2.getMoveDirection('3'));

        // State 4, read '0'
        assertNull(state3.getTransitionState('0'));
        assertNull(state3.getWriteSymbol('0'));
        assertNull(state3.getMoveDirection('0'));
        // State 4, read '1'
        assertNull(state3.getTransitionState('1'));
        assertNull(state3.getWriteSymbol('1'));
        assertNull(state3.getMoveDirection('1'));
        // State 4, read '2'
        assertNull(state3.getTransitionState('2'));
        assertNull(state3.getWriteSymbol('2'));
        assertNull(state3.getMoveDirection('2'));
        // State 4, read '3'
        assertNull(state3.getTransitionState('3'));
        assertNull(state3.getWriteSymbol('3'));
        assertNull(state3.getMoveDirection('3'));

        assertEquals(Set.of('1', '2', '3'), machine.getSigma());

        assertEquals("", input);
    }
}
