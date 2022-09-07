package Board;

public class Board {
    private final Stone[][] boardMatrix;
    private final int boardSize;

    public Board (int boardSize){
        this.boardSize = boardSize;
        // TODO: Maybe extract to some kind of separate function? Like resetBoard?
        this.boardMatrix = new Stone[boardSize][boardSize];
        for (int i = 0; i<boardSize; i++) {
            for(int j = 0; j< boardSize; j++){
                this.boardMatrix[i][j] = Stone.BLANK;
            }
        }
    }

    public void makeMove(int x, int y, Stone stone){
        this.boardMatrix[x][y] = stone;
    }

    public Stone[][] getBoardMatrix() {
        return boardMatrix;
    }

    public int getBoardSize() {
        return boardSize;
    }

    //TODO: Implement getPossibleMoves.
}
