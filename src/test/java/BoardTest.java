import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        Board board = new Board(10,10,10);

        Assertions.assertEquals(10,board.getRows());
        Assertions.assertEquals(10,board.getCols());
    }

}
