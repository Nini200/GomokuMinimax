package Board;

import junit.framework.TestCase;
import org.junit.Assert;

import static Board.UnitTestMain.makeTestBoard;

public class BoardTest extends TestCase {

    private Board testBoard = makeTestBoard();

    public void testMakeMove() {

    }

    public void testGetBoardSize() {

    }

    public void testGetPossibleMoves() {
    }

    public void testRevertMove() {

    }

    public void testCountHorizontalLine() {
        int expected = 2;
        int actual = testBoard.countHorizontalLine(0,6,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }

    public void testCountHorizontalLineLeftSide(){
        int expected = 4;
        int actual = testBoard.countHorizontalLine(1,0,Stone.BLACK);
    }

    public void testCountVerticalLine() {
    }

    public void testCountDiagonalLine() {
    }

    public void testCountHorizontally() {
    }

    public void testEvaluate() {
    }
}