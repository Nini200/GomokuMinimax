package Minimax;

import Board.*;

public interface IHeuristics {
    int evaluate(Stone maxColor, boolean isMax, Board board);
}
