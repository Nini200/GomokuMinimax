package DummyTests;

import Board.*;

public class DummyTestMain {
    public static void main(String[] args) {
        Board board = new Board(13);
        board.makeMove(1,2, Stone.BLACK);
    }
}
