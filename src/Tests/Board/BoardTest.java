package Board;

import junit.framework.TestCase;
import org.junit.Assert;

import static Board.UnitTestMain.*;

public class BoardTest extends TestCase {

    private Board testBoard = makeBasicTestBoard();
    private final Board testFiveBoard = makeFivesTestBoard();

    public void testMakeMove() {
        Stone expectedStone = Stone.BLACK;
        testBoard.makeMove(new Coordinates(3,4), expectedStone);
        Stone actualStone = testBoard.getBoardMatrix()[3][4];
        Assert.assertEquals(expectedStone,actualStone);
        testBoard = makeBasicTestBoard();

    }

    public void testGetBoardSize() {
        int expectedSize = 9;
        int actualSize = testBoard.getBoardSize();
        Assert.assertEquals(expectedSize,actualSize);
    }

    public void testGetPossibleMoves() {
        int expectedMovesNumber = 40;
        int actualMovesNumber = testBoard.getPossibleMoves().size();
        Assert.assertEquals(expectedMovesNumber,actualMovesNumber);
    }

    public void testRevertMove() {
        Stone expectedStone = Stone.BLANK;
        testBoard.revertMove(new Coordinates(6,6));
        Stone actualStone = testBoard.getBoardMatrix()[6][6];
        Assert.assertEquals(expectedStone,actualStone);
        testBoard = makeBasicTestBoard();
    }

    public void testCountHorizontalLine() {
        int expected = 3;
        int actual = testBoard.countHorizontalLine(4,1,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }

    public void testCountHorizontalLineLeftSide(){
        int expected = 5;
        int actual = testBoard.countHorizontalLine(1,0,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }
    public void testCountHorizontalLineRightSide(){
        int expected = 2;
        int actual = testBoard.countHorizontalLine(0,7,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }

    public void testCountVerticalLine() {
        int expected = 3;
        int actual = testBoard.countVerticalLine(3,6,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }
    public void testCountVerticalLineUpSide() {
        int expected = 3;
        int actual = testBoard.countVerticalLine(0,2,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }
    public void testCountVerticalLineBottomSide() {
        int expected = 3;
        int actual = testBoard.countVerticalLine(6,5,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }

    public void testCountDiagonalLineDown() {
        int expected = 2;
        int actual = testBoard.countDiagonalLineDown(5,4,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }

    public void testCountDiagonalLineDownLeftUpperCorner() {
        int expected = 3;
        int actual = testBoard.countDiagonalLineDown(0,0,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }

    public void testCountDiagonalLineDownRightLowerCorner() {
        int expected = 4;
        int actual = testBoard.countDiagonalLineDown(5,5,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }
    public void testCountDiagonalLineDownLeftDownEdges() {
        int expected = 2;
        int actual = testBoard.countDiagonalLineDown(7,0,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }
    public void testCountDiagonalLineDownUpRightEdges() {
        int expected = 4;
        int actual = testBoard.countDiagonalLineDown(0,5,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }

    public void testCountDiagonalLineUp() {
        int expected = 4;
        int actual = testBoard.countDiagonalLineUp(5,4,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }

    public void testCountDiagonalLineUpRightUpperCorner() {
        int expected = 4;
        int actual = testBoard.countDiagonalLineUp(3,5,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }
    public void testCountDiagonalLineUpLeftLowerCorner() {
        int expected = 2;
        int actual = testBoard.countDiagonalLineUp(8,0,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }
    public void testCountDiagonalLineUpLeftUpEdges() {
        int expected = 3;
        int actual = testBoard.countDiagonalLineUp(2,0,Stone.BLACK);
        Assert.assertEquals(expected,actual);
    }
    public void testCountDiagonalLineUpDownRightEdges() {
        int expected = 3;
        int actual = testBoard.countDiagonalLineUp(8,6,Stone.WHITE);
        Assert.assertEquals(expected,actual);
    }

    public void testCountHorizontally() {
        ConsecutiveStones expected = new ConsecutiveStones(0,1,0,0,0);
        ConsecutiveStones actualCS = new ConsecutiveStones();
        testBoard.countHorizontally(actualCS,Stone.WHITE);
        boolean areEqual = compareConsecutiveStones(expected,actualCS);
        Assert.assertTrue(areEqual);
    }

    public void testCountVertically() {
        ConsecutiveStones expected = new ConsecutiveStones(2,0,0,0,0);
        ConsecutiveStones actualCS = new ConsecutiveStones();
        testBoard.countVertically(actualCS,Stone.BLACK);
        boolean areEqual = compareConsecutiveStones(expected,actualCS);
        Assert.assertTrue(areEqual);
    }

    public void testEvaluate() {
    }

    public void testCountDiagonallyDown() {
        ConsecutiveStones expected = new ConsecutiveStones(0,0,1,0,0);
        ConsecutiveStones actualCS = new ConsecutiveStones();
        testBoard.countDiagonallyDown(actualCS,Stone.WHITE);
        boolean areEqual = compareConsecutiveStones(expected,actualCS);
        Assert.assertTrue(areEqual);
    }

    public void testCountDiagonallyUp() {
        ConsecutiveStones expected = new ConsecutiveStones(0,0,0,1,0);
        ConsecutiveStones actualCS = new ConsecutiveStones();
        testBoard.countDiagonallyUp(actualCS,Stone.BLACK);
        boolean areEqual = compareConsecutiveStones(expected,actualCS);
        Assert.assertTrue(areEqual);
    }

    public void testCountAll() {
        ConsecutiveStones expected = new ConsecutiveStones(3,0,0,1,1);
        ConsecutiveStones actualCS = new ConsecutiveStones();
        testBoard.countAll(actualCS,Stone.BLACK);
        boolean areEqual = compareConsecutiveStones(expected,actualCS);
        Assert.assertTrue(areEqual);
    }

    public void testMakesFiveHorizontally() {
        boolean makesFive = testFiveBoard.makesFiveHorizontally(new Coordinates(2,3), Stone.WHITE);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveHorizontallyRight() {
        boolean makesFive = testFiveBoard.makesFiveHorizontally(new Coordinates(5,5), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveHorizontallyNot() {
        boolean makesFive = testFiveBoard.makesFiveHorizontally(new Coordinates(7,3), Stone.BLACK);
        Assert.assertFalse(makesFive);
    }
    public void testMakesFiveVertically() {
        boolean makesFive = testFiveBoard.makesFiveVertically(new Coordinates(4,1), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveVerticallyUp() {
        boolean makesFive = testFiveBoard.makesFiveVertically(new Coordinates(1,2), Stone.WHITE);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveVerticallyDown() {
        boolean makesFive = testFiveBoard.makesFiveVertically(new Coordinates(5,7), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveVerticallyNot() {
        boolean makesFive = testFiveBoard.makesFiveVertically(new Coordinates(7,0), Stone.WHITE);
        Assert.assertFalse(makesFive);
    }
    public void testMakesFiveDiagonallyUp() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyUp(new Coordinates(6,1), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveDiagonallyUpRightUpper() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyUp(new Coordinates(2,6), Stone.WHITE);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveDiagonallyUpLeftLower() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyUp(new Coordinates(6,5), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveDiagonallyUpNot() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyUp(new Coordinates(6,3), Stone.BLACK);
        Assert.assertFalse(makesFive);
    }
    public void testMakesFiveDiagonallyDown() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyDown(new Coordinates(5,4), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveDiagonallyDownLeftUpper() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyDown(new Coordinates(2,2), Stone.WHITE);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveDiagonallyDownNot() {
        boolean makesFive = testFiveBoard.makesFiveDiagonallyDown(new Coordinates(6,3), Stone.BLACK);
        Assert.assertFalse(makesFive);
    }

    public void testMakesFive() {
        boolean makesFive = testBoard.makesFive(new Coordinates(1,2), Stone.BLACK);
        Assert.assertTrue(makesFive);
    }
    public void testMakesFiveNot() {
        boolean makesFive = testBoard.makesFive(new Coordinates(5,4), Stone.BLACK);
        Assert.assertFalse(makesFive);
    }
}