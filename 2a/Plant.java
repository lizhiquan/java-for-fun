import java.util.ArrayList;

/**
 * Represents a plant.
 */
public class Plant implements Lifeform {
    @Override
    public void eat(World.Cell currentCell, World.Cell destCell) throws Exception {
        throw new Exception();
    }

    @Override
    public void move(World.Cell currentCell) throws Exception {
        throw new Exception();
    }

    @Override
    public void reproduce(World.Cell currentCell) throws Exception {
        ArrayList<World.Cell> neighbours = currentCell.getNeighbours();
        if (canReproduce(neighbours)) {
            World.Cell emptyCell = getRandomRaidableCell(neighbours);
            if (emptyCell != null)
                emptyCell.setLifeform(new Plant());
        }
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void die(World.Cell currentCell) throws Exception {
        throw new Exception();
    }

    @Override
    public String getColor() {
        return "MediumSeaGreen";
    }

    /**
     * Gets a random cell to raid.
     * @param cells list of cells
     * @return a random raidable cell
     */
    private World.Cell getRandomRaidableCell(ArrayList<World.Cell> cells) {
        ArrayList<World.Cell> emptyCells = new ArrayList<>();

        for (World.Cell cell : cells)
            if (cell.getLifeform() == null)
                emptyCells.add(cell);

        if (emptyCells.isEmpty())
            return null;

        return emptyCells.get(RandomGenerator.nextNumber(emptyCells.size()));
    }

    /**
     * Checks if a plant can reproduce.
     * @param neighbours neighboring cells
     * @return true if this plant can reproduce in this neighbor
     */
    private boolean canReproduce(ArrayList<World.Cell> neighbours) {
        int nEmptyCells = 0;
        int nPlants = 0;

        // Count the number of empty cells and plants surrounding the cell
        for (World.Cell cell : neighbours) {
            Lifeform lf = cell.getLifeform();
            if (lf == null)
                nEmptyCells++;
            else if (lf instanceof Plant) {
                nPlants++;
            }
        }

        return nEmptyCells >= 3 && nPlants == 4;
    }
}
