import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Wraps the logic of the game.
 */
public class Game {
    /**
     * The width of the world board.
     */
    public static final int WORLD_WIDTH = 40;

    /**
     * The height of the world board.
     */
    public static final int WORLD_HEIGHT = 40;

    /**
     * The world board.
     */
    private World world;

    /**
     * Constructs a game object.
     */
    public Game() {
        world = new World(WORLD_WIDTH, WORLD_HEIGHT);
    }

    /**
     * Simulates time passing by.
     */
    public void passTime() {
        moveLifeforms();
        reproduceLifeforms();
    }

    /**
     * Moves all life forms on the world board if they are movable.
     */
    private void moveLifeforms() {
        ArrayList<World.Cell> cells = new ArrayList<>();
        for (int i = 0; i < WORLD_HEIGHT; i++)
            for (int j = 0; j < WORLD_WIDTH; j++) {
                World.Cell cell = world.getCell(i, j);
                if (cell.getLifeform() instanceof Herbivore) {
                    cells.add(cell);
                }
            }
        for (World.Cell cell: cells) {
            try {
                cell.getLifeform().move(cell);
            } catch (Exception ignored) {}
        }
    }

    /**
     * Reproduces life forms on the world board if they are reproducible.
     */
    private void reproduceLifeforms() {
        ArrayList<World.Cell> cells = new ArrayList<>();
        for (int i = 0; i < WORLD_HEIGHT; i++)
            for (int j = 0; j < WORLD_WIDTH; j++) {
                World.Cell cell = world.getCell(i, j);
                if (cell.getLifeform() instanceof Plant) {
                    cells.add(cell);
                }
            }
        for (World.Cell cell: cells) {
            try {
                cell.getLifeform().reproduce(cell);
            } catch (Exception ignored) {}
        }
    }

    /**
     * Returns the color of a life form in a given row and col.
     * @param row row
     * @param col column
     * @return color of a life form
     */
    public Color getColor(final int row, final int col) {
        Lifeform lf = world.getCell(row, col).getLifeform();
        if (lf != null)
            return Color.valueOf(lf.getColor());
        return Color.GRAY;
    }
}
