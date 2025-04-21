package tm;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the TMTape class.
 *
 * @author Jayce Lowry
 */
public class TMTapeTest {

    @Test
    public void testEmpty() {
        TMTape tape = new TMTape("");
        assertEquals('0', tape.read());
        assertEquals("0", tape.getVisited());
    }

    @Test
    public void testEmpty_Move() {
        TMTape tape = new TMTape("");
        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("000", tape.getVisited());
    }

    @Test
    public void testEmpty_Write() {
        TMTape tape = new TMTape("");
        tape.write('1');
        assertEquals('1', tape.read());
        assertEquals("1", tape.getVisited());
    }

    @Test
    public void testEmpty_WriteMove() {
        TMTape tape = new TMTape("");
        tape.write('1');
        tape.move(Direction.LEFT);

        assertEquals('0', tape.read());
        assertEquals("01", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        assertEquals("01", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("010", tape.getVisited());
    }

    @Test
    public void testEmpty_MoveWrite() {
        TMTape tape = new TMTape("");
        tape.move(Direction.RIGHT);
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("01", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("11", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("111", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        tape.write('0');
        assertEquals('0', tape.read());
        assertEquals("101", tape.getVisited());
    }

    @Test
    public void testEmpty_MoveFarLeft() {
        TMTape tape = new TMTape("");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.LEFT);
        }

        assertEquals('0', tape.read());
        assertEquals("0".repeat(numTimes + 1), tape.getVisited());
    }

    @Test
    public void testEmpty_MoveFarRight() {
        TMTape tape = new TMTape("");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.RIGHT);
        }

        assertEquals('0', tape.read());
        assertEquals("0".repeat(numTimes + 1), tape.getVisited());
    }

    @Test
    public void test1() {
        TMTape tape = new TMTape("1");
        assertEquals('1', tape.read());
        assertEquals("1", tape.getVisited());
    }

    @Test
    public void test1_Move() {
        TMTape tape = new TMTape("1");
        tape.move(Direction.RIGHT);

        assertEquals('0', tape.read());
        assertEquals("10", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('1', tape.read());
        assertEquals("10", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        assertEquals("010", tape.getVisited());
    }

    @Test
    public void test1_Write() {
        TMTape tape = new TMTape("1");
        tape.write('0');
        assertEquals('0', tape.read());
        assertEquals("0", tape.getVisited());
    }

    @Test
    public void test1_WriteMove() {
        TMTape tape = new TMTape("1");
        tape.write('0');
        tape.move(Direction.LEFT);

        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("000", tape.getVisited());
    }

    @Test
    public void test1_MoveWrite() {
        TMTape tape = new TMTape("1");
        tape.move(Direction.LEFT);
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("11", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("111", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        tape.write('0');

        assertEquals('0', tape.read());
        assertEquals("101", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        tape.write('0');
        assertEquals('0', tape.read());
        assertEquals("100", tape.getVisited());
    }

    @Test
    public void test1_MoveFarLeft() {
        TMTape tape = new TMTape("1");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.LEFT);
        }

        assertEquals('0', tape.read());
        assertEquals("0".repeat(numTimes) + "1", tape.getVisited());
    }

    @Test
    public void test1_MoveFarRight() {
        TMTape tape = new TMTape("1");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.RIGHT);
        }

        assertEquals('0', tape.read());
        assertEquals("1" + "0".repeat(numTimes), tape.getVisited());
    }

    @Test
    public void test2() {
        TMTape tape = new TMTape("11");
        assertEquals('1', tape.read());
        assertEquals("1", tape.getVisited());
    }

    @Test
    public void test2_Move() {
        TMTape tape = new TMTape("11");
        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        assertEquals("01", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        assertEquals("01", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        assertEquals("011", tape.getVisited());
    }

    @Test
    public void test2_Write() {
        TMTape tape = new TMTape("11");
        tape.write('0');
        assertEquals('0', tape.read());
        assertEquals("0", tape.getVisited());
    }

    @Test
    public void test2_WriteMove() {
        TMTape tape = new TMTape("11");
        tape.write('0');
        tape.move(Direction.LEFT);

        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('0', tape.read());
        assertEquals("00", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        assertEquals("001", tape.getVisited());
    }

    @Test
    public void test2_MoveWrite() {
        TMTape tape = new TMTape("11");
        tape.move(Direction.LEFT);
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("11", tape.getVisited());

        tape.move(Direction.LEFT);
        assertEquals('0', tape.read());
        tape.write('1');

        assertEquals('1', tape.read());
        assertEquals("111", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        tape.write('0');

        assertEquals('0', tape.read());
        assertEquals("101", tape.getVisited());

        tape.move(Direction.RIGHT);
        assertEquals('1', tape.read());
        tape.write('0');
        assertEquals('0', tape.read());
        assertEquals("100", tape.getVisited());
    }

    @Test
    public void test2_MoveFarLeft() {
        TMTape tape = new TMTape("11");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.LEFT);
        }

        assertEquals('0', tape.read());
        assertEquals("0".repeat(numTimes) + "1", tape.getVisited());
    }

    @Test
    public void test2_MoveFarRight() {
        TMTape tape = new TMTape("11");
        int numTimes = 50;

        for (int i = 0; i < numTimes; i++) {
            tape.move(Direction.RIGHT);
        }

        assertEquals('0', tape.read());
        assertEquals("11" + "0".repeat(numTimes - 1), tape.getVisited());
    }
}
