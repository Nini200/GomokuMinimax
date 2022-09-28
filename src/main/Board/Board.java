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

    public int countHorizontalLine(int i, int j, Stone color){
        int count = 1;
        while (j < boardSize) {
            if(j+1==boardSize||boardMatrix[i][j+1]!=color){
                j = boardSize;
            }
            else{
                count++;
                j++;
            }
        }
        return count;
    }
    public int countVerticalLine(int i, int j, Stone color){
        int count = 1;
        while (i < boardSize) {
            if(i+1==boardSize||boardMatrix[i+1][j]!=color){
                i = boardSize;
            }
            else{
                count++;
                i++;
            }
        }
        return count;
    }

    public int countDiagonalLineDown(int i, int j, Stone color){
        int count = 1;
        while (i < boardSize && j < boardSize) {
            if (j + 1 == boardSize || i + 1 == boardSize || boardMatrix[i+1][j+1] != color) {
                j = boardSize;
            } else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }

    public int countDiagonalLineUp(int i, int j, Stone color){
        int count = 1;
        while (i > -1 && j < boardSize){
            if (i - 1 == -1 || j + 1 == boardSize || boardMatrix[i - 1][j + 1] != color) {
                i = -1;
            }
            else {
                count++;
                i--;
                j++;
            }
        }
        return count;
    }

    public void countHorizontally(ConsecutiveStones cs, Stone color){
        int i = 0;
        int j = 0;
        while(i<boardSize){
            while (j<boardSize){
                if(boardMatrix[i][j]==color) {
                    int openEnds = 2;
                    // TODO: Check that :)
                    if (j == 0 || boardMatrix[i][j - 1] != Stone.BLANK) {
                        openEnds--;
                    }
                    int stones = countHorizontalLine(i, j, color);
                    j += stones;
                    if (j >= boardSize || boardMatrix[i][j] != Stone.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                }
                else {
                    j++;
                }
            }
            j=0;
            i++;
        }
    }

    public int evaluate(IHeuristics heuristics, Stone color){
        return 0;
    }
}
