package Board;

import Minimax.IHeuristics;

import java.util.ArrayList;

public class Board {
    private final Stone[][] boardMatrix;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.boardMatrix = new Stone[boardSize][boardSize];
        resetBoard();
    }

    public void makeMove(Coordinates c, Stone stone) {
        this.boardMatrix[c.x][c.y] = stone;
    }
    // TODO: Implement revertMove?

    public Stone[][] getBoardMatrix() {
        return boardMatrix;
    }

    public int getBoardSize() {
        return boardSize;
    }

    private void resetBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.boardMatrix[i][j] = Stone.BLANK;
            }
        }
    }
    //TODO: Implement getPossibleMoves.
    public ArrayList<Coordinates> getPossibleMoves(){
        ArrayList<Coordinates> possibleMoves = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(this.boardMatrix[i][j] == Stone.BLANK){
                    Coordinates c = new Coordinates(i, j);
                    possibleMoves.add(c);
                }
            }
        }
        return possibleMoves;
    }

    public void printBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("-----");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < boardSize; j++) {
                if(this.boardMatrix[i][j] == Stone.BLANK){
                    System.out.print("    ");
                } else if (this.boardMatrix[i][j] == Stone.BLACK) {
                    System.out.print(" \uD83D\uDDA4 ");
                }
                else {
                    System.out.print(" \uD83E\uDD0D ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void revertMove(Coordinates c) {
        this.boardMatrix[c.x][c.y] = Stone.BLANK;
    }

    public int evaluate(IHeuristics heuristics, Stone color){
        return 0;
    }
}
