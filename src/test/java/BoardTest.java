import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(10,10,10);
    }

    @Test
    public void testBoardInitialization() {
        Assertions.assertEquals(10, board.getRows());
        Assertions.assertEquals(10, board.getCols());
        Assertions.assertEquals(10, board.getNumMines());
    }

    @Test
    public void testMinePlacement(){
        int expectedMines = board.getNumMines();
        int mineCount = 0;

        for(int row = 0; row < board.getRows(); row++){
            for(int col = 0; col < board.getCols(); col++){
                if(board.getCell(row,col).hasMine()){
                    mineCount++;
                }
            }
        }
        Assertions.assertEquals(expectedMines, mineCount);
    }

}
