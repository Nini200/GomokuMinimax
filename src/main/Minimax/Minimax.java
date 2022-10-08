package Minimax;

import Board.Board;
import Board.Stone;
import Board.Coordinates;


import java.util.ArrayList;

public class Minimax {

    private static int innerMinimax(Board board, Stone color, boolean isMax, int depth, IHeuristics heuristics){
        if(depth == 0){
            return board.evaluate(heuristics, color, isMax);
        }
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        int tempResult;
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1, heuristics);
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
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1, heuristics);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
            }
        }
        return minResult;
    }

    public static Coordinates minimax(Board board, Stone color, boolean isMax, int depth, IHeuristics heuristics){
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        int tempResult;
        Coordinates bestCoords = possibleMoves.get(0);
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1, heuristics);
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
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1, heuristics);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
                bestCoords = c;
            }
        }
        return bestCoords;
    }
}
