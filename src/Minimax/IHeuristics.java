package Minimax;

import Board.*;

public interface IHeuristics {
    MinimaxResult evaluate(Stone maxColor, boolean isMax, Board board);
}
