package Minimax;

import Board.ConsecutiveAdvStones;
import Board.ConsecutiveStones;
import Board.ConsecutiveStonesType;

public class TestHeuristics implements IHeuristics {
    @Override
    public int evaluate(ConsecutiveStones playersCs, ConsecutiveStones opponentsCs) {
        return playersCs.getTwosOneEdge() * 2
                + playersCs.getTwosTwoEdges() * 5
                + playersCs.getThreesOneEdge() * 50
                + playersCs.getThreesTwoEdges() * 100
                + playersCs.getFoursOneEdge() * 10000
                + playersCs.getFoursTwoEdges() * 5000000
                + playersCs.getFives() * Integer.MAX_VALUE
                -(opponentsCs.getTwosOneEdge() * 2
                + opponentsCs.getTwosTwoEdges() * 5
                + opponentsCs.getThreesOneEdge() * 50
                + opponentsCs.getThreesTwoEdges() * 100
                + opponentsCs.getFoursOneEdge() * 10000
                + opponentsCs.getFoursTwoEdges() * 5000000
                + opponentsCs.getFives() * Integer.MAX_VALUE);
    }

    @Override
    public ConsecutiveStonesType getConsecutiveStonesType() {
        return ConsecutiveStonesType.SIMPLE;
    }

    @Override
    public int evaluateAdvanced(ConsecutiveAdvStones playersCas, ConsecutiveAdvStones opponentsCas) {
        return 0;
    }
}
