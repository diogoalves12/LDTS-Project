import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {
    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testDefaultCell() {
        Assertions.assertFalse(cell.hasMine());
        Assertions.assertFalse(cell.isFlagged());
        Assertions.assertFalse(cell.isRevealed());
        Assertions.assertEquals(0, cell.getAdjacentMines());
    }


    @Test
    public void testSetMine() {
        cell.setHasMine(true);
        Assertions.assertTrue(cell.hasMine());
    }

    @Test
    public void testRevealCell(){
        cell.setRevealed(true);
        Assertions.assertTrue(cell.isRevealed());
    }

    @Test
    public void testFlaggedCell() {
        cell.setFlagged(true);
        Assertions.assertTrue(cell.isFlagged());
    }

}
