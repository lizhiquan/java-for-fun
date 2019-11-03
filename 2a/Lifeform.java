import java.util.ArrayList;

/**
 * Represents a life form.
 */
interface Lifeform {
    /**
     * Eats another life form.
     * @param currentCell current cell
     * @param destCell destination cell
     * @throws Exception throws if it can't eat
     */
    void eat(World.Cell currentCell, World.Cell destCell) throws Exception;

    /**
     * Moves to a new position.
     * @param currentCell current cell
     * @throws Exception throws if it can't move
     */
    void move(World.Cell currentCell) throws Exception;

    /**
     * Reproduces a new life form.
     * @param currentCell current cell
     * @throws Exception throws if it can't reproduce
     */
    void reproduce(World.Cell currentCell) throws Exception;

    /**
     * Checks if this life form is alive.
     * @return true if the life form is still alive
     */
    boolean isAlive();

    /**
     * Dies.
     * @param currentCell current cell
     * @throws Exception throws if it can't die
     */
    void die(World.Cell currentCell) throws Exception;

    /**
     * Returns the color of a life form.
     * @return css color string
     */
    String getColor();
}
