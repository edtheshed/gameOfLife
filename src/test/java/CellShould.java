import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellShould {

    private ICellState cell;

    @Test
    void comeToLifeIfItIsDeadAndHasExactly3Neighbours() {
        cell = new DeadCell();
        cell.setNextState(3);
        cell = cell.setCellState();
        assertTrue(cell.isAlive());
    }

    @Test
    void dieIfItIsAliveAndHasMoreThan3Neighbours() {
        cell = new AliveCell();
        cell.setNextState(4);
        cell = cell.setCellState();
        assertFalse(cell.isAlive());
    }

    @Test
    void dieIfItIsAliveAndHasFewerThan2Neighbours() {
        cell = new AliveCell();
        cell.setNextState(1);
        cell = cell.setCellState();
        assertFalse(cell.isAlive());
    }
}
