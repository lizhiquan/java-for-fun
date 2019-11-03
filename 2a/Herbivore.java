import java.util.ArrayList;

/**
 * Represents a herbivore.
 */
public class Herbivore implements Lifeform {
    /**
     * Max health point.
     */
    private static final int MAX_HP = 5;

    /**
     * Current health point.
     */
    private int currentHP;

    /**
     * Constructs a herbivore object.
     */
    public Herbivore() {
        this.currentHP = MAX_HP;
    }

    @Override
    public void eat(World.Cell currentCell, World.Cell destCell) throws Exception {
        Lifeform lf = destCell.getLifeform();
        if (lf instanceof Plant) {
            destCell.setLifeform(this);
            currentCell.setLifeform(null);
            currentHP = MAX_HP;
        } else {
            throw new Exception();
        }
    }

    @Override
    public void move(World.Cell currentCell) throws Exception {
        ArrayList<World.Cell> neighbours = currentCell.getNeighbours();
        World.Cell cellToMove = getRandomRaidableCell(neighbours);

        if (cellToMove == null) {
            throw new Exception();
        }

        if (cellToMove.getLifeform() == null) {
            cellToMove.setLifeform(this);
            currentCell.setLifeform(null);
            currentHP--;

            if (!isAlive()) {
                die(cellToMove);
            }
        } else {
            eat(currentCell, cellToMove);
        }
    }

    @Override
    public void reproduce(World.Cell currentCell) throws Exception {
        throw new Exception();
    }

    @Override
    public boolean isAlive() {
        return currentHP > 0;
    }

    @Override
    public void die(World.Cell currentCell) throws Exception {
        currentCell.setLifeform(null);
    }

    @Override
    public String getColor() {
        return "Yellow";
    }

    /**
     * Gets a random cell to raid.
     * @param cells list of cells
     * @return a random raidable cell
     */
    private World.Cell getRandomRaidableCell(ArrayList<World.Cell> cells) {
        ArrayList<World.Cell> possibleCells = new ArrayList<>();

        for (World.Cell cell : cells) {
            Lifeform lf = cell.getLifeform();
            if (lf == null || lf instanceof Plant)
                possibleCells.add(cell);
        }

        if (possibleCells.isEmpty())
            return null;

        return possibleCells.get(RandomGenerator.nextNumber(possibleCells.size()));
    }
}
