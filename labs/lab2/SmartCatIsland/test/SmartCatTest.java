package test;

import static org.junit.Assert.*;
import org.junit.*;

import island.*;
import island.constants.Color;

/**
 * This is a JUnit test class, used to test code
 * 
 * You should test the SmartCat class by designing Island test cases
 * and filling in the JUnit tests according to the assignment
 * description.
 * 
 * @author Colin Sullivan
 */
public class SmartCatTest {

    public static Island pathIsland = new Island(new String[][] {
            // WRITE YOUR CODE HERE
            { "L", "W", "L", "L", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L" },
            { "L", "L", "L", "W", "L", "L", "L" },
    });

    public static Island yarnIsland = new Island(new String[][] {
            // WRITE YOUR CODE HERE
            { "L", "W", "L", "L", "L", "W", "L", "L", "L" },
            { "Y", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "Y", "W", "L", "W", "L", "W", "L" },
            { "Y", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "Y", "W", "L", "W", "L" },
            { "Y", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "Y", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "Y", "W", "L" },
            { "L", "Y", "L", "W", "L", "L", "L", "W", "Y" },
    });

    public static Island mazeIsland = new Island(new String[][] {
            // WRITE YOUR CODE HERE
            { "L", "W", "L", "L", "L", "W", "L", "L", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "W", "L" },
            { "L", "L", "L", "W", "L", "L", "L", "W", "L", "L", "L" },
    });

    @Test
    public void testWalkPath() {
        // WRITE YOUR CODE HERE
        SmartCat cat = new SmartCat("cat", pathIsland, 0, 0, Color.WHITE);
        cat.walkPath();

        assertEquals(pathIsland.getTiles().length - 1, cat.getCol());
        assertEquals(0, cat.getRow());
    }

    @Test
    public void testCollectAllYarn() {
        SmartCat cat = new SmartCat("cat", yarnIsland, 0, 0, Color.WHITE);
        cat.collectAllYarn();

        Tile[][] tiles = yarnIsland.getTiles();
        for (Tile[] row : tiles) {
            for (Tile col : row) {
                assertFalse(col.hasYarn);
            }
        }
    }

    @Test
    public void testSolveMaze() {
        // WRITE YOUR CODE HERE
            SmartCat cat = new SmartCat("cat", mazeIsland, 0, 0, Color.WHITE);
            cat.solveMaze();

            assertEquals(0, cat.getRow());
            assertEquals(mazeIsland.getTiles().length - 1, cat.getCol());
            assertTrue(cat.numStepsTaken() >= 30);
    }
}
