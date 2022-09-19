package DummyTests;

import Board.*;

public class DummyTestMain {
    public static void main(String[] args) {
        Board board = new Board(13);
        Coordinates c = new Coordinates(1,2);
        board.makeMove(c, Stone.BLACK);
        Coordinates c1 = new Coordinates(6,2);
        board.makeMove(c1, Stone.BLACK);
        Coordinates c2= new Coordinates(0,6);
        board.makeMove(c2, Stone.WHITE);
        board.printBoard();
    }
}
