public class DeadCell extends Cell implements ICellState {
    @Override
    public void setNextState(int amountOfNeighbours) {
        if (amountOfNeighbours == 3)
            nextCell = new AliveCell();
        else
            nextCell = this;
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
