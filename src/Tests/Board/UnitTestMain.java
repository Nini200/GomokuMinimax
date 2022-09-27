package Board;

public class UnitTestMain {
    public static void main(String[] args) {
        Board board = makeTestBoard();
        board.printBoard();
    }

    private static int[][][] testBoardMatrixData = {
            // Black stones
            {
                    {0, 0}, {0, 2}, {0, 5},
                    {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 6},
                    {2, 0}, {2, 2}, {2, 7},
                    {3, 6}, {3, 8},
                    {4, 5}, {4, 6},
                    {5, 4}, {5, 6},
                    {6, 5},
                    {7, 1}, {7, 5},
                    {8, 0}, {8, 5}

            },
            // White Stones
            {
                    {0, 7}, {0, 8},
                    {1, 7},
                    {2, 6},
                    {3, 5},
                    {4, 1}, {4, 2}, {4, 3},
                    {5, 5},
                    {6, 2}, {6, 6}, {6, 8},
                    {7, 0}, {7, 3}, {7, 7},
                    {8, 1}, {8, 6}, {8, 8}
            }
    };
    static Board makeTestBoard(){
        Board board = new Board(9);
        for (int[] coords : (testBoardMatrixData[0])){
            Coordinates c = new Coordinates(coords[0],coords[1]);
            board.makeMove(c,Stone.BLACK);
        }
        for (int[] coords : (testBoardMatrixData[1])){
            Coordinates c = new Coordinates(coords[0],coords[1]);
            board.makeMove(c,Stone.WHITE);
        }

        return board;
    }
}
