package Minimax;

import Board.*;

public interface IHeuristics {
    int evaluate(ConsecutiveStones cs);
}