package Minimax;

import Board.Board;
import Board.Color;
import Board.Coordinates;


import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Minimax {

    private static int innerMinimax(Board board, Color color, boolean isMax, int depth, IHeuristics heuristics, int alpha, int beta){
        if(depth == 0){
            return board.evaluate(heuristics, color, isMax);
        }
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        int tempResult;
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1, heuristics, alpha, beta);
                board.revertMove(c);
                if(tempResult > maxResult){
                    maxResult = tempResult;
                }
                alpha = max(alpha, tempResult);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxResult;
        }
        int minResult = Integer.MAX_VALUE;
        for (Coordinates c : possibleMoves) {
            board.makeMove(c, color);
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1, heuristics, alpha, beta);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
            }
            beta = min(beta, tempResult);
            if (beta <= alpha) {
                break;
            }
        }
        return minResult;
    }

    public static Coordinates minimax(Board board, Color color, boolean isMax, int depth, IHeuristics heuristics, int alpha, int beta){
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        if(possibleMoves.isEmpty()){
            return new Coordinates(-1, -1);
        }
        int tempResult;
        Coordinates bestCoords = possibleMoves.get(0);
        if (isMax){
            int maxResult = Integer.MIN_VALUE;
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = innerMinimax(board, color.opposite(), false, depth-1, heuristics, alpha, beta);
                board.revertMove(c);
                if(tempResult > maxResult){
                    maxResult = tempResult;
                    bestCoords = c;
                }
                alpha = max(alpha, tempResult);
                if (beta <= alpha) {
                    break;
                }
            }
            return bestCoords;
        }
        int minResult = Integer.MAX_VALUE;
        for (Coordinates c : possibleMoves) {
            board.makeMove(c, color);
            tempResult = innerMinimax(board, color.opposite(), true, depth - 1, heuristics, alpha, beta);
            board.revertMove(c);
            if (tempResult < minResult) {
                minResult = tempResult;
                bestCoords = c;
            }
            beta = min(beta, tempResult);
            if (beta <= alpha) {
                break;
            }
        }
        return bestCoords;
    }
}
