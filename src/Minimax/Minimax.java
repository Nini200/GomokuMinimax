package Minimax;

import Board.Board;
import Board.Stone;
import Board.Coordinates;


import java.util.ArrayList;

public class Minimax {
    private final IHeuristics heuristics;
    private boolean isGameOver = false;

    public Minimax(IHeuristics heuristics){
        this.heuristics = heuristics;
    }

    private int innerMinimax(Board board, Stone color, boolean isMax, int depth){
        if(depth == 0 || isGameOver){
            return board.evaluate(this.heuristics, color);
        }
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        int tempResult;
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1);
                board.revertMove(c);
                if(tempResult > maxResult){
                    maxResult = tempResult;
                }
            }
            return maxResult;
        }
        int minResult = Integer.MAX_VALUE;
        for (Coordinates c : possibleMoves) {
            board.makeMove(c, color);
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
            }
        }
        return minResult;
    }

    public Coordinates minimax(Board board, Stone color, boolean isMax, int depth){
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        int tempResult;
        Coordinates bestCoords = possibleMoves.get(0);
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1);
                board.revertMove(c);
                if(tempResult > maxResult){
                    maxResult = tempResult;
                    bestCoords = c;
                }
            }
            return bestCoords;
        }
        int minResult = Integer.MAX_VALUE;
        for (Coordinates c : possibleMoves) {
            board.makeMove(c, color);
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
                bestCoords = c;
            }
        }
        return bestCoords;
    }
}
