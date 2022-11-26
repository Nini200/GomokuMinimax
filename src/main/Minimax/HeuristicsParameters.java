package Minimax;

import java.util.Random;

public class HeuristicsParameters implements IHeuristicsParameters{
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

    public static HeuristicsParameters getRandomParameters(Random random){
        return new HeuristicsParameters(random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE);
    }

    @Override
    public IHeuristicsParameters swapSecondHalf(IHeuristicsParameters parameters2) {
        return swapSecondHalf((HeuristicsParameters) parameters2);
    }

    @Override
    public IHeuristicsParameters swapFirstHalf(IHeuristicsParameters parameters2) {
        return swapFirstHalf((HeuristicsParameters) parameters2);
    }

    public String toPrint(){
        return this.playersTwosOneEdge + "\n"
                + this.playersTwosTwoEdges + "\n"
                + this.playersThreesOneEdge + "\n"
                + this.playersThreesTwoEdges + "\n"
                + this.playersFoursOneEdge + "\n"
                + this.playersFoursTwoEdges + "\n"
                + this.playersFives + "\n"
                + this.opponentsTwosOneEdge + "\n"
                + this.opponentsTwosTwoEdges + "\n"
                + this.opponentsThreesOneEdge + "\n"
                + this.opponentsThreesTwoEdges + "\n"
                + this.opponentsFoursOneEdge + "\n"
                + this.opponentsFoursTwoEdges + "\n"
                + this.opponentsFives + "\n";
    }
    public void print() {
        System.out.print(this.toPrint());
    }

    @Override
    public IHeuristicsParameters swapOpenEdges(IHeuristicsParameters parameters2) {
        HeuristicsParameters p2 = (HeuristicsParameters) parameters2;
        return new HeuristicsParameters(this.playersTwosOneEdge,
                p2.playersTwosTwoEdges,
                this.playersThreesOneEdge,
                p2.playersThreesTwoEdges,
                this.playersFoursOneEdge,
                p2.playersFoursTwoEdges,
                p2.playersFives,
                this.opponentsTwosOneEdge,
                p2.opponentsTwosTwoEdges,
                this.opponentsThreesOneEdge,
                p2.opponentsThreesTwoEdges,
                this.opponentsFoursOneEdge,
                p2.opponentsFoursTwoEdges,
                p2.opponentsFives);
    }

    @Override
    public IHeuristicsParameters swapOneOpenEdge(IHeuristicsParameters parameters2) {
        HeuristicsParameters p2 = (HeuristicsParameters) parameters2;
        return new HeuristicsParameters(p2.playersTwosOneEdge,
                this.playersTwosTwoEdges,
                p2.playersThreesOneEdge,
                this.playersThreesTwoEdges,
                p2.playersFoursOneEdge,
                this.playersFoursTwoEdges,
                this.playersFives,
                p2.opponentsTwosOneEdge,
                this.opponentsTwosTwoEdges,
                p2.opponentsThreesOneEdge,
                this.opponentsThreesTwoEdges,
                p2.opponentsFoursOneEdge,
                this.opponentsFoursTwoEdges,
                this.opponentsFives);
    }
}
