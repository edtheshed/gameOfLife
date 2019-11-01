public class DeadCell extends Cell implements ICellState {
    @Override
    public void setNextState(int amountOfNeighbours) {
        nextCell = this;
        if (amountOfNeighbours == 3)
            nextCell = new AliveCell();
    }

    @Override
    public ICellState setCellState() {
        return nextCell;
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
