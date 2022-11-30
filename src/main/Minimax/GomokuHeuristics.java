package Minimax;

import Board.ConsecutiveAdvStones;
import Board.ConsecutiveStones;
import Board.ConsecutiveStonesType;

public class GomokuHeuristics implements IHeuristics {
    HeuristicsParameters parameters;

    AdvancedHeuristicsParameters advancedHeuristicsParameters;

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

    public GomokuHeuristics(AdvancedHeuristicsParameters advancedHeuristicsParameters) {
        this.advancedHeuristicsParameters = advancedHeuristicsParameters;
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

    @Override
    public ConsecutiveStonesType getConsecutiveStonesType() {
        if (advancedHeuristicsParameters != null) {
            return ConsecutiveStonesType.ADVANCED;
        }
        return ConsecutiveStonesType.SIMPLE;

    }

    @Override
    public int evaluateAdvanced(ConsecutiveAdvStones playersCas, ConsecutiveAdvStones opponentsCas) {

        return playersCas.getFourHoleAfter2() * advancedHeuristicsParameters.playersFourHoleAfter2
                + playersCas.getFourHoleAfter3() * advancedHeuristicsParameters.playersFourHoleAfter3
                + playersCas.getThree2OpenMax5() * advancedHeuristicsParameters.playersThree2OpenMax5
                + playersCas.getThreeHoleAfter2Blocked1() * advancedHeuristicsParameters.playersThreeHoleAfter2Blocked1
                + playersCas.getThreeHoleAfter2Blocked2() * advancedHeuristicsParameters.playersThreeHoleAfter2Blocked2
                + playersCas.getThreeHoleAfter2Open2() * advancedHeuristicsParameters.playersThreeHoleAfter2Open2
                + playersCas.getThreeHoles2InRow() * advancedHeuristicsParameters.playersThreeHoles2InRow
                + playersCas.getThreeHoles2Separated() * advancedHeuristicsParameters.playersThreeHoles2Separated
                + playersCas.getTwoOn3Open1() * advancedHeuristicsParameters.playersTwoOn3Open1
                + playersCas.getTwoOn3Open2() * advancedHeuristicsParameters.playersTwoOn3Open2
                + playersCas.getTwoOn4Open1() * advancedHeuristicsParameters.playersTwoOn4Open1
                + playersCas.getTwoOn4Open2() * advancedHeuristicsParameters.playersTwoOn4Open2
                + playersCas.getTwoOn5() * advancedHeuristicsParameters.opponentsTwoOn5
                + playersCas.getFives() * advancedHeuristicsParameters.playersFives
                + playersCas.getFoursTwoEdges() * advancedHeuristicsParameters.playersFoursTwoEdges
                + playersCas.getFoursOneEdge() * advancedHeuristicsParameters.playersFoursOneEdge
                + playersCas.getThreesTwoEdges() * advancedHeuristicsParameters.playersThreesTwoEdges
                + playersCas.getThreesOneEdge() * advancedHeuristicsParameters.playersThreesOneEdge
                + playersCas.getTwosTwoEdges() * advancedHeuristicsParameters.playersTwosTwoEdges
                + playersCas.getTwosOneEdge() * advancedHeuristicsParameters.playersTwosOneEdge
                -
                (opponentsCas.getFourHoleAfter2() * advancedHeuristicsParameters.opponentsFourHoleAfter2
                + opponentsCas.getFourHoleAfter3() * advancedHeuristicsParameters.opponentsFourHoleAfter3
                + opponentsCas.getThree2OpenMax5() * advancedHeuristicsParameters.opponentsThree2OpenMax5
                + opponentsCas.getThreeHoleAfter2Blocked1() * advancedHeuristicsParameters.opponentsThreeHoleAfter2Blocked1
                + opponentsCas.getThreeHoleAfter2Blocked2() * advancedHeuristicsParameters.opponentsThreeHoleAfter2Blocked2
                + opponentsCas.getThreeHoleAfter2Open2() * advancedHeuristicsParameters.opponentsThreeHoleAfter2Open2
                + opponentsCas.getThreeHoles2InRow() * advancedHeuristicsParameters.opponentsThreeHoles2InRow
                + opponentsCas.getThreeHoles2Separated() * advancedHeuristicsParameters.opponentsThreeHoles2Separated
                + opponentsCas.getTwoOn3Open1() * advancedHeuristicsParameters.opponentsTwoOn3Open1
                + opponentsCas.getTwoOn3Open2() * advancedHeuristicsParameters.opponentsTwoOn3Open2
                + opponentsCas.getTwoOn4Open1() * advancedHeuristicsParameters.opponentsTwoOn4Open1
                + opponentsCas.getTwoOn4Open2() * advancedHeuristicsParameters.opponentsTwoOn4Open2
                + opponentsCas.getTwoOn5() * advancedHeuristicsParameters.opponentsTwoOn5
                + opponentsCas.getFives() * advancedHeuristicsParameters.opponentsFives
                + opponentsCas.getFoursTwoEdges() * advancedHeuristicsParameters.opponentsFoursTwoEdges
                + opponentsCas.getFoursOneEdge() * advancedHeuristicsParameters.opponentsFoursOneEdge
                + opponentsCas.getThreesTwoEdges() * advancedHeuristicsParameters.opponentsThreesTwoEdges
                + opponentsCas.getThreesOneEdge() * advancedHeuristicsParameters.opponentsThreesOneEdge
                + opponentsCas.getTwosTwoEdges() * advancedHeuristicsParameters.opponentsTwosTwoEdges
                + opponentsCas.getTwosOneEdge() * advancedHeuristicsParameters.opponentsTwosOneEdge);

    }
}
