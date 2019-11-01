public interface ICellState {
    void setNextState(int amountOfNeighbours);
    ICellState setCellState();
    boolean isAlive();
}
