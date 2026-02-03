package island;

import island.constants.*;

import java.util.Objects;

/**
 * Welcome to Cat Island! A mini-world made using OOP!
 * Run the driver to see the islands, then solve each one in its
 * corresponding method below.
 * 
 * You should use the cat.moveRight(), cat.moveLeft(), cat.moveUp(),
 * and cat.moveDown() methods to traverse the islands and complete
 * their unique objectives
 */
public class CatIsland {

    /**
     * To complete this island, your cat should collect all the yarn and return
     * to the starting position (1,1)
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void island1(Cat cat) throws CatInWaterException {
        cat.moveRight();
        cat.moveDown();
        cat.moveLeft();
        cat.moveUp();
    }

    /**
     * To complete this island, make your cat visit every single land square
     * on this island exactly once. It does not have to return to its starting position
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void island2(Cat cat) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        cat.moveDown();
        cat.moveDown();
        cat.moveRight();
        cat.moveRight();
        cat.moveUp();
        cat.moveRight();
        cat.moveRight();
        cat.moveRight();
        cat.moveDown();
        cat.moveDown();
        cat.moveDown();
        cat.moveLeft();
    }

    /**
     * To complete this island, your cat should collect every yarn ball on the
     * island.
     * It does not have to return to its starting position
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void island3(Cat cat) throws CatInWaterException {
        cat.moveRight();
        cat.moveRight();
        cat.moveDown();
        cat.moveUp();
        cat.moveUp();
        cat.moveLeft();
        cat.moveUp();
        cat.moveLeft();
        cat.moveLeft();
        cat.moveDown();
        cat.moveLeft();
        cat.moveDown();
        cat.moveDown();
        cat.moveRight();
    }

    /**
     * To complete this island, you will need to modify the island
     * instead of moving a cat object.
     * 
     * You can get the 2D array of tiles from the island with .getTiles().
     * 
     * You should bridge the gap between the islands, by setting
     * the type attribute of the tiles at (2,3), (3,2), (3,3), (3,4), and (4,3)
     * equal to Tile.LAND.
     * 
     * You should also add yarn to (3,2) and (3,4), by setting the "hasYarn"
     * attribute of those tiles to true.
     * 
     * Add a cat object to (3,3) using the cat constructor. 
     * This cat can be any color found within Color.java under the constants/ directory 
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void island4(Island islandFour) throws CatInWaterException {
        Tile[][] tiles = islandFour.getTiles();
        tiles[2][3].type = Tile.LAND;
        tiles[3][2].type = Tile.LAND;
        tiles[3][2].hasYarn = true;
        tiles[3][3].type = Tile.LAND;
        tiles[3][4].type = Tile.LAND;
        tiles[3][4].hasYarn = true;
        tiles[4][3].type = Tile.LAND;

        Cat cat = new Cat("cat", islandFour, 3, 3, Color.WHITE);
    }

    /**
     * To complete this island, you will need to write a simple path following
     * algorithm, which will walk the cat along the single wide path.
     * 
     * This method is the caller method, which will call your recursive solution.
     * Do not modify this method
     * 
     * @param cat The path walker cat
     * @throws CatInWaterException
     */
    public static void island5(Cat cat, Island islandFive) throws CatInWaterException {
        // DO NOT EDIT
        CatIsland.island5Recursive(cat, islandFive.getTiles(), islandFive.getTiles()[cat.getRow()][cat.getCol()]);
    }

    /**
     * This recursive method walks a cat on a single wide path from beginning to end
     * 
     * You should check all four directions from the cats current position:
     * 1) if it is in bounds (>= 0 and <= num rows or num cols)
     * 2) if the type of the tile in that direction is land
     * 3) if the tile in that direction != the prev tile
     * If all 3, then move the cat in that direction, recursively call this method
     * 
     * @param c
     * @param tiles
     * @param prev
     * @throws CatInWaterException
     */
    public static void island5Recursive(Cat cat, Tile[][] tiles, Tile prev) throws CatInWaterException {
        int row = cat.getRow();
        int col = cat.getCol();

        if (col == 8 && row == 0) { return; }

        if (col + 1 < tiles.length && Objects.equals(tiles[row][col+1].type, Tile.LAND) && tiles[row][col+1] != prev) {
            cat.moveRight();
            island5Recursive(cat, tiles, tiles[row][col]);
        } else if (row - 1 >= 0 && Objects.equals(tiles[row - 1][col].type, Tile.LAND) && tiles[row-1][col] != prev) {
            cat.moveUp();
            island5Recursive(cat, tiles, tiles[row][col]);
        } else if (row + 1 < tiles.length && Objects.equals(tiles[row + 1][col].type, Tile.LAND) && tiles[row+1][col] != prev) {
            cat.moveDown();
            island5Recursive(cat, tiles, tiles[row][col]);
        } else if (col - 1 >= 0 && Objects.equals(tiles[row][col - 1].type, Tile.LAND) && tiles[row][col-1] != prev) {
            cat.moveLeft();
            island5Recursive(cat, tiles, tiles[row][col]);
        }
    }

}