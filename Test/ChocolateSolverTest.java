import com.tiy.ChocolateSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localdom on 6/3/2016.
 */
public class ChocolateSolverTest {

    ChocolateSolver solver = new ChocolateSolver();

    @Before
    public void setUp() {
    }


    @Test
    public void testWithEnoughSmalls() throws Exception {
        assertEquals(1, solver.makeChocolate(1, 1, 6).smalls);
        assertEquals(1, solver.makeChocolate(1, 1, 6).bigs);
        assertTrue(solver.makeChocolate(1, 1, 6).hasSolution);
        assertEquals(0, solver.makeChocolate(5, 5, 25).smalls);
        assertEquals(5, solver.makeChocolate(5, 5, 25).bigs);
        assertEquals(1, solver.makeChocolate(5, 5, 26).smalls);
        assertEquals(5, solver.makeChocolate(5, 5, 26).bigs);
        assertEquals(2, solver.makeChocolate(5, 5, 27).smalls);
        assertEquals(5, solver.makeChocolate(5, 5, 27).bigs);
        assertEquals(3, solver.makeChocolate(5, 5, 28).smalls);
        assertEquals(5, solver.makeChocolate(5, 5, 28).bigs);
        assertEquals(4, solver.makeChocolate(5, 5, 29).smalls);
        assertEquals(5, solver.makeChocolate(5, 5, 29).bigs);
    }

    @Test
    public void testNotEnough() throws Exception {
        assertEquals(-1, solver.makeChocolate(1, 1, 7).smalls);
        assertFalse(solver.makeChocolate(1, 1, 7).hasSolution);
        assertEquals(-1, solver.makeChocolate(1, 1, 7).bigs);
        assertEquals(-1, solver.makeChocolate(5, 5, 31).smalls);
        assertEquals(-1, solver.makeChocolate(5, 5, 31).bigs);
    }

    @Test
    public void testNotEnoughSmalls() throws Exception {
        assertEquals(-1, solver.makeChocolate(1, 2, 8).smalls);
        assertEquals(-1, solver.makeChocolate(1, 2, 8).bigs);
    }

    @Test
    public void testOnlyWithSmalls() throws Exception {
        assertEquals(6, solver.makeChocolate(10, 0, 6).smalls);
        assertEquals(0, solver.makeChocolate(10, 0, 6).bigs);
    }

    @Test
    public void testOnlyWithBigs() throws Exception {
        assertEquals(0, solver.makeChocolate(0, 10, 20).smalls);
        assertEquals(4, solver.makeChocolate(0, 10, 20).bigs);
    }

    @Test
    public void testNotEnoughBigs() throws Exception {
        assertEquals(-1, solver.makeChocolate(4, 1, 10).smalls);
        assertFalse(solver.makeChocolate(4, 1, 10).hasSolution);
    }

    @Test
    public void testMakeChocolateNotEnoughBigsButEnoughSmalls() throws Exception {
        assertEquals(6, solver.makeChocolate(7, 2, 16).smalls);
    }

    @Test
    public void testMakeChocolateUseLotsOfSmalls() throws Exception {
        assertEquals(6, solver.makeChocolate(12, 7, 41).smalls);
    }

}