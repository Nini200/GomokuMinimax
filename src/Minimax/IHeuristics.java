package Minimax;

import Board.Board;

public interface IHeuristics {
    int evaluate(int depth, int maxColor, Board board);
}
