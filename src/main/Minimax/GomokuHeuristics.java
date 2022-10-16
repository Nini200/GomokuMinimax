package Minimax;

import Board.ConsecutiveStones;

public class GomokuHeuristics implements IHeuristics {
    HeuristicsParameters parameters;

    public GomokuHeuristics(HeuristicsParameters parameters) {
        this.parameters = parameters;
    }
    public GomokuHeuristics(int playersTwosOneEdge,
                            int playersTwosTwoEdges,
                            int playersThreesOneEdge,
                            int playersThreesTwoEdges,
                            int playersFoursOneEdge,
                            int playersFoursTwoEdges,
                            int playersFives,
                            int opponentsTwosOneEdge,
                            int opponentsTwosTwoEdges,
                            int opponentsThreesOneEdge,
                            int opponentsThreesTwoEdges,
                            int opponentsFoursOneEdge,
                            int opponentsFoursTwoEdges,
                            int opponentsFives) {

        this.parameters.playersTwosOneEdge=playersTwosOneEdge;
        this.parameters.playersTwosTwoEdges=playersTwosTwoEdges;
        this.parameters.playersThreesOneEdge=playersThreesOneEdge;
        this.parameters.playersThreesTwoEdges=playersThreesTwoEdges;
        this.parameters.playersFoursOneEdge=playersFoursOneEdge;
        this.parameters.playersFoursTwoEdges=playersFoursTwoEdges;
        this.parameters.playersFives=playersFives;
        this.parameters.opponentsTwosOneEdge=opponentsTwosOneEdge;
        this.parameters.opponentsTwosTwoEdges=opponentsTwosTwoEdges;
        this.parameters.opponentsThreesOneEdge=opponentsThreesOneEdge;
        this.parameters.opponentsThreesTwoEdges=opponentsThreesTwoEdges;
        this.parameters.opponentsFoursOneEdge = opponentsFoursOneEdge;
        this.parameters.opponentsFoursTwoEdges = opponentsFoursTwoEdges;
        this.parameters.opponentsFives = opponentsFives;
    }
    public int evaluate(ConsecutiveStones playersCs, ConsecutiveStones opponentsCs) {
        return playersCs.getTwosOneEdge() * parameters.playersTwosOneEdge
                + playersCs.getTwosTwoEdges() * parameters.playersTwosTwoEdges
                + playersCs.getThreesOneEdge() * parameters.playersThreesOneEdge
                + playersCs.getThreesTwoEdges() * parameters.playersThreesTwoEdges
                + playersCs.getFoursOneEdge() * parameters.playersFoursOneEdge
                + playersCs.getFoursTwoEdges() * parameters.playersFoursTwoEdges
                + playersCs.getFives() * parameters.playersFives
                -(opponentsCs.getTwosOneEdge() * parameters.opponentsTwosOneEdge
                + opponentsCs.getTwosTwoEdges() * parameters.opponentsTwosTwoEdges
                + opponentsCs.getThreesOneEdge() * parameters.opponentsThreesOneEdge
                + opponentsCs.getThreesTwoEdges() * parameters.opponentsThreesTwoEdges
                + opponentsCs.getFoursOneEdge() * parameters.opponentsFoursOneEdge
                + opponentsCs.getFoursTwoEdges() * parameters.opponentsFoursTwoEdges
                + opponentsCs.getFives() * parameters.opponentsFives);
    }
}
