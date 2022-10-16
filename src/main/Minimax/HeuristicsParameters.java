package Minimax;

public class HeuristicsParameters {
    int playersTwosOneEdge;
    int playersTwosTwoEdges;
    int playersThreesOneEdge;
    int playersThreesTwoEdges;
    int playersFoursOneEdge;
    int playersFoursTwoEdges;
    int playersFives;
    int opponentsTwosOneEdge;
    int opponentsTwosTwoEdges;
    int opponentsThreesOneEdge;
    int opponentsThreesTwoEdges;
    int opponentsFoursOneEdge;
    int opponentsFoursTwoEdges;
    int opponentsFives;

    public HeuristicsParameters(int playersTwosOneEdge,
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

        this.playersTwosOneEdge = playersTwosOneEdge;
        this.playersTwosTwoEdges = playersTwosTwoEdges;
        this.playersThreesOneEdge = playersThreesOneEdge;
        this.playersThreesTwoEdges = playersThreesTwoEdges;
        this.playersFoursOneEdge = playersFoursOneEdge;
        this.playersFoursTwoEdges = playersFoursTwoEdges;
        this.playersFives = playersFives;
        this.opponentsTwosOneEdge = opponentsTwosOneEdge;
        this.opponentsTwosTwoEdges = opponentsTwosTwoEdges;
        this.opponentsThreesOneEdge = opponentsThreesOneEdge;
        this.opponentsThreesTwoEdges = opponentsThreesTwoEdges;
        this.opponentsFoursOneEdge = opponentsFoursOneEdge;
        this.opponentsFoursTwoEdges = opponentsFoursTwoEdges;
        this.opponentsFives = opponentsFives;
    }

    public HeuristicsParameters swapFirstHalf(HeuristicsParameters parameters2){
        return new HeuristicsParameters(parameters2.playersTwosOneEdge,
                parameters2.playersTwosTwoEdges,
                parameters2.playersThreesOneEdge,
                parameters2.playersThreesTwoEdges,
                parameters2.playersFoursOneEdge,
                parameters2.playersFoursTwoEdges,
                parameters2.playersFives,
                this.opponentsTwosOneEdge,
                this.opponentsTwosTwoEdges,
                this.opponentsThreesOneEdge,
                this.opponentsThreesTwoEdges,
                this.opponentsFoursOneEdge,
                this.opponentsFoursTwoEdges,
                this.opponentsFives);
    }
    public HeuristicsParameters swapSecondHalf(HeuristicsParameters parameters2){
        return new HeuristicsParameters(this.playersTwosOneEdge,
                this.playersTwosTwoEdges,
                this.playersThreesOneEdge,
                this.playersThreesTwoEdges,
                this.playersFoursOneEdge,
                this.playersFoursTwoEdges,
                this.playersFives,
                parameters2.opponentsTwosOneEdge,
                parameters2.opponentsTwosTwoEdges,
                parameters2.opponentsThreesOneEdge,
                parameters2.opponentsThreesTwoEdges,
                parameters2.opponentsFoursOneEdge,
                parameters2.opponentsFoursTwoEdges,
                parameters2.opponentsFives);
    }
    public void mutateParameter(int parameterNumber, double size, boolean isNegative){
        double mutationMultiplier = isNegative ? (1-size) : (1 + size);
        switch (parameterNumber){
            case 0 -> this.playersTwosOneEdge = (int)(this.playersTwosOneEdge * mutationMultiplier);
            case 1 -> this.playersTwosTwoEdges = (int)(this.playersTwosTwoEdges * mutationMultiplier);
            case 2 -> this.playersThreesOneEdge = (int)(this.playersThreesOneEdge * mutationMultiplier);
            case 3 -> this.playersThreesTwoEdges = (int)(this.playersThreesTwoEdges * mutationMultiplier);
            case 4 -> this.playersFoursOneEdge = (int)(this.playersFoursOneEdge * mutationMultiplier);
            case 5 -> this.playersFoursTwoEdges = (int)(this.playersFoursTwoEdges * mutationMultiplier);
            case 6 -> this.playersFives = (int)(this.playersFives * mutationMultiplier);
            case 7 -> this.opponentsTwosOneEdge = (int)(this.opponentsTwosOneEdge * mutationMultiplier);
            case 8 -> this.opponentsTwosTwoEdges = (int)(this.opponentsTwosTwoEdges * mutationMultiplier);
            case 9 -> this.opponentsThreesOneEdge = (int)(this.opponentsThreesOneEdge * mutationMultiplier);
            case 10 -> this.opponentsThreesTwoEdges = (int)(this.opponentsThreesTwoEdges * mutationMultiplier);
            case 11 -> this.opponentsFoursOneEdge = (int)(this.opponentsFoursOneEdge * mutationMultiplier);
            case 12 -> this.opponentsFoursTwoEdges = (int)(this.opponentsFoursTwoEdges * mutationMultiplier);
            case 13 -> this.opponentsFives = (int)(this.opponentsFives * mutationMultiplier);
        }
    }
}
