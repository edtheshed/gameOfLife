public class AliveCell extends Cell implements ICellState{
    @Override
    public void setNextState(int amountOfNeighbours) {
        nextCell = this;
        if (overcrowded(amountOfNeighbours) || lonely(amountOfNeighbours))
            nextCell = new DeadCell();
    }

    @Override
    public ICellState setCellState() {
        return nextCell;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    private boolean lonely(int amountOfNeighbours) {
        return amountOfNeighbours < 2;
    }

    private boolean overcrowded(int amountOfNeighbours) {
        return amountOfNeighbours > 3;
    }
}
