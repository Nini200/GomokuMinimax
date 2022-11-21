package Minimax;

import Board.*;

public interface IHeuristics {
    int evaluate(ConsecutiveStones playersCs, ConsecutiveStones opponentsCs);
    ConsecutiveStonesType getConsecutiveStonesType();
    int evaluateAdvanced(ConsecutiveAdvStones playersCas, ConsecutiveAdvStones opponentsCas);

}
