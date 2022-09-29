package Board;

public class UnitTestMain {
    public static void main(String[] args) {
        Board board = makeBasicTestBoard();
        ConsecutiveStones cs = new ConsecutiveStones();
        board.countHorizontally(cs, Stone.WHITE);
        System.out.print(cs.getThreesOneEdge());
        System.out.print(cs.getThreesTwoEdges());
        System.out.print(cs.getFoursOneEdge());
        System.out.print(cs.getFoursTwoEdges());
        System.out.print(cs.getFives());
        board.printBoard();
        System.out.println();
        board = makeFivesTestBoard();
        board.printBoard();
    }


    static boolean compareConsecutiveStones(ConsecutiveStones cs1, ConsecutiveStones cs2){
        return cs1.getFives() == cs2.getFives()
                && cs1.getFoursTwoEdges() == cs2.getFoursTwoEdges()
                && cs1.getFoursOneEdge() == cs2.getFoursOneEdge()
                && cs1.getThreesTwoEdges() == cs2.getThreesTwoEdges()
                && cs1.getThreesOneEdge() == cs2.getThreesOneEdge();
    }
    private static final int[][][] testBoardMatrixData = {
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
    private static final int[][][] testBoardMatrixFivesData = {
            // Black stones
            {
                    {0, 3},
                    {1, 4}, {1, 8},
                    {2, 5}, {2, 7},
                    {3, 1}, {3, 4}, {3, 6},
                    {4, 1}, {4, 3}, {4, 5}, {4, 7},
                    {5, 1}, {5, 2}, {5, 4}, {5, 5}, {5, 6}, {5, 7}, {5, 8},
                    {6, 1}, {6, 3}, {6, 5}, {6, 7},
                    {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7},
                    {8, 3}, {8, 7}

            },
            // White Stones
            {
                    {0, 0}, {0, 2}, {0, 8},
                    {1, 1}, {1, 2}, {1, 7},
                    {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 6},
                    {3, 0}, {3, 2}, {3, 3}, {3, 5},
                    {4, 0}, {4, 2}, {4, 4},
                    {5, 0},
                    {6, 0},
                    {7, 0},
                    {8, 0},
            }
    };
    static Board makeTestBoard(int [][][] testMatrixData){
        Board board = new Board(9);
        for (int[] coords : (testMatrixData[0])){
            Coordinates c = new Coordinates(coords[0],coords[1]);
            board.makeMove(c,Stone.BLACK);
        }
        for (int[] coords : (testMatrixData[1])){
            Coordinates c = new Coordinates(coords[0],coords[1]);
            board.makeMove(c,Stone.WHITE);
        }

        return board;
    }

    static  Board makeBasicTestBoard(){
        return makeTestBoard(testBoardMatrixData);
    }

    static  Board makeFivesTestBoard(){
        return makeTestBoard(testBoardMatrixFivesData);
    }
}
