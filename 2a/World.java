import java.util.ArrayList;

/**
 * A board that represents the world.
 * Life forms can move and reproduce in this world.
 */
public class World {
    private int width;
    private int height;
    private Cell[][] cells;

    /**
     * A class represents a cell in the world.
     */
    public class Cell {
        /**
         * Row position of this cell.
         */
        private int row;

        /**
         * Column position of this cell.
         */
        private int col;

        /**
         * A life form that this cell holds.
         */
        private Lifeform lifeform;

        /**
         * Constructs a Cell object.
         * @param row row position
         * @param col column position
         * @param lifeform a life form in this cell
         */
        public Cell(final int row, final int col, Lifeform lifeform) {
            this.row = row;
            this.col = col;
            this.lifeform = lifeform;
        }

        /**
         * Returns current life form.
         * @return life form
         */
        public Lifeform getLifeform() {
            return lifeform;
        }

        /**
         * Set a new life form.
         * @param lifeform new life form to set
         */
        public void setLifeform(Lifeform lifeform) {
            this.lifeform = lifeform;
        }

        /**
         * Gets neighbor cells of this cell.
         * @return neighbor cells
         */
        ArrayList<Cell> getNeighbours() {
            ArrayList<Cell> neighbours = new ArrayList<>();
            int[] directions = {-1, 0, 1};

            for (int x : directions) {
                int r = row + x;

                // out of bound
                if (r < 0 || r == height)
                    continue;

                for (int y : directions) {
                    // ignore same position
                    if (x == 0 && y == 0)
                        continue;

                    int c = col + y;

                    // out of bound
                    if (c < 0 || c == width)
                        continue;

                    neighbours.add(getCell(r, c));
                }
            }

            return neighbours;
        }
    }

    /**
     * Constructs a World object.
     * @param width the width of the world
     * @param height the height of the world
     */
    public World(final int width, final int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                cells[i][j] = new Cell(i, j, generateRandomLifeform());
    }

    /**
     * Gets the height of the world.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the world.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets a cell in the world given its row and column.
     * @param row row
     * @param col column
     * @return cell
     */
    public Cell getCell(final int row, final int col) {
        return cells[row][col];
    }

    /**
     * Generates a random life form.
     * @return a random life form
     */
    private Lifeform generateRandomLifeform() {
        int value = RandomGenerator.nextNumber(100);
        if (value >= 85) {
            return new Herbivore();
        } else if (value >= 65) {
            return new Plant();
        }
        return null;
    }
}
