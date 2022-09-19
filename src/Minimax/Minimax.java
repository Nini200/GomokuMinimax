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

    public MinimaxResult minimax(Board board, Stone color, boolean isMax, int depth){
        if(depth == 0 || isGameOver){
            return heuristics.evaluate(color, isMax, board);
        }
        ArrayList<Coordinates> possibleMoves = board.getPossibleMoves();
        MinimaxResult tempResult;
        if (isMax){
            MinimaxResult maxResult = new MinimaxResult(Integer.MIN_VALUE, possibleMoves.get(0));
            for (Coordinates c : possibleMoves) {
                board.makeMove(c,color);
                tempResult = minimax(board, color.opposite(), false, depth-1);
                board.revertMove(c);
                if(tempResult.getScore() > maxResult.getScore() ){
                    maxResult = tempResult;
                }
            }
            return maxResult;
        }
        MinimaxResult minResult = new MinimaxResult(Integer.MAX_VALUE, possibleMoves.get(0));
        for (Coordinates c : possibleMoves) {
            board.makeMove(c, color);
            tempResult = minimax(board, color.opposite(), true, depth - 1);
            board.revertMove(c);
            if (tempResult.getScore() < minResult.getScore()) {
                minResult = tempResult;
            }
        }
        return minResult;
    }
}
