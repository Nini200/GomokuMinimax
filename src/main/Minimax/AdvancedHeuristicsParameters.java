package Minimax;

import java.util.Random;

public class AdvancedHeuristicsParameters implements IHeuristicsParameters{
    int playersTwosOneEdge;
    int playersTwosTwoEdges;
    int playersThreesOneEdge;
    int playersThreesTwoEdges;
    int playersFoursOneEdge;
    int playersFoursTwoEdges;
    int playersFives;
    int playersFourHoleAfter3;
    int playersFourHoleAfter2;
    int playersThreeHoleAfter2Open2;
    int playersThreeHoleAfter2Blocked1; // _OO__OX
    int playersThreeHoleAfter2Blocked2; // XOO__O_
    int playersThreeHoles2InRow; // OO__O
    int playersThreeHoles2Separated; //O_O_O
    int playersThree2OpenMax5; // X_OOO_X
    int playersTwoOn5; // O___O
    int playersTwoOn4Open2; //_O__O_
    int playersTwoOn4Open1; //XO__O_
    int playersTwoOn3Open2; //_O_O_
    int playersTwoOn3Open1; //XO_O_

    int opponentsTwosOneEdge;
    int opponentsTwosTwoEdges;
    int opponentsThreesOneEdge;
    int opponentsThreesTwoEdges;
    int opponentsFoursOneEdge;
    int opponentsFoursTwoEdges;
    int opponentsFives;
    int opponentsFourHoleAfter3;
    int opponentsFourHoleAfter2;
    int opponentsThreeHoleAfter2Open2;
    int opponentsThreeHoleAfter2Blocked1; // _OO__OX
    int opponentsThreeHoleAfter2Blocked2; // XOO__O_
    int opponentsThreeHoles2InRow; // OO__O
    int opponentsThreeHoles2Separated; //O_O_O
    int opponentsThree2OpenMax5; // X_OOO_X
    int opponentsTwoOn5; // O___O
    int opponentsTwoOn4Open2; //_O__O_
    int opponentsTwoOn4Open1; //XO__O_
    int opponentsTwoOn3Open2; //_O_O_
    int opponentsTwoOn3Open1; //XO_O_

    public AdvancedHeuristicsParameters(int playersTwosOneEdge,
                                        int playersTwosTwoEdges,
                                        int playersThreesOneEdge,
                                        int playersThreesTwoEdges,
                                        int playersFoursOneEdge,
                                        int playersFoursTwoEdges,
                                        int playersFives,
                                        int playersFourHoleAfter3,
                                        int playersFourHoleAfter2,
                                        int playersThreeHoleAfter2Open2,
                                        int playersThreeHoleAfter2Blocked1, // _OO__OX
                                        int playersThreeHoleAfter2Blocked2, // XOO__O_
                                        int playersThreeHoles2InRow, // OO__O
                                        int playersThreeHoles2Separated, //O_O_O
                                        int playersThree2OpenMax5, // X_OOO_X
                                        int playersTwoOn5, // O___O
                                        int playersTwoOn4Open2, //_O__O_
                                        int playersTwoOn4Open1, //XO__O_
                                        int playersTwoOn3Open2, //_O_O_
                                        int playersTwoOn3Open1, //XO_O_

                                        int opponentsTwosOneEdge,
                                        int opponentsTwosTwoEdges,
                                        int opponentsThreesOneEdge,
                                        int opponentsThreesTwoEdges,
                                        int opponentsFoursOneEdge,
                                        int opponentsFoursTwoEdges,
                                        int opponentsFives,
                                        int opponentsFourHoleAfter3,
                                        int opponentsFourHoleAfter2,
                                        int opponentsThreeHoleAfter2Open2,
                                        int opponentsThreeHoleAfter2Blocked1, // _OO__OX
                                        int opponentsThreeHoleAfter2Blocked2, // XOO__O_
                                        int opponentsThreeHoles2InRow, // OO__O
                                        int opponentsThreeHoles2Separated, //O_O_O
                                        int opponentsThree2OpenMax5, // X_OOO_X
                                        int opponentsTwoOn5, // O___O
                                        int opponentsTwoOn4Open2, //_O__O_
                                        int opponentsTwoOn4Open1,//XO__O_
                                        int opponentsTwoOn3Open2, //_O_O_
                                        int opponentsTwoOn3Open1) {
        this.playersTwosOneEdge = playersTwosOneEdge;
        this.playersTwosTwoEdges = playersTwosTwoEdges;
        this.playersThreesOneEdge = playersThreesOneEdge;
        this.playersThreesTwoEdges = playersThreesTwoEdges;
        this.playersFoursOneEdge = playersFoursOneEdge;
        this.playersFoursTwoEdges = playersFoursTwoEdges;
        this.playersFives = playersFives;
        this.playersFourHoleAfter3 = playersFourHoleAfter3;
        this.playersFourHoleAfter2 = playersFourHoleAfter2;
        this.playersThreeHoleAfter2Open2 = playersThreeHoleAfter2Open2;
        this.playersThreeHoleAfter2Blocked1 = playersThreeHoleAfter2Blocked1;
        this.playersThreeHoleAfter2Blocked2 = playersThreeHoleAfter2Blocked2;
        this.playersThreeHoles2InRow = playersThreeHoles2InRow;
        this.playersThreeHoles2Separated = playersThreeHoles2Separated;
        this.playersThree2OpenMax5 = playersThree2OpenMax5;
        this.playersTwoOn5 = playersTwoOn5;
        this.playersTwoOn4Open2 = playersTwoOn4Open2;
        this.playersTwoOn4Open1 = playersTwoOn4Open1;
        this.playersTwoOn3Open2 = playersTwoOn3Open2;
        this.playersTwoOn3Open1 = playersTwoOn3Open1;

        this.opponentsTwosOneEdge = opponentsTwosOneEdge;
        this.opponentsTwosTwoEdges = opponentsTwosTwoEdges;
        this.opponentsThreesOneEdge = opponentsThreesOneEdge;
        this.opponentsThreesTwoEdges = opponentsThreesTwoEdges;
        this.opponentsFoursOneEdge = opponentsFoursOneEdge;
        this.opponentsFoursTwoEdges = opponentsFoursTwoEdges;
        this.opponentsFives = opponentsFives;
        this.opponentsFourHoleAfter3 = opponentsFourHoleAfter3;
        this.opponentsFourHoleAfter2 = opponentsFourHoleAfter2;
        this.opponentsThreeHoleAfter2Open2 = opponentsThreeHoleAfter2Open2;
        this.opponentsThreeHoleAfter2Blocked1 = opponentsThreeHoleAfter2Blocked1;
        this.opponentsThreeHoleAfter2Blocked2 = opponentsThreeHoleAfter2Blocked2;
        this.opponentsThreeHoles2InRow = opponentsThreeHoles2InRow;
        this.opponentsThreeHoles2Separated = opponentsThreeHoles2Separated;
        this.opponentsThree2OpenMax5 = opponentsThree2OpenMax5;
        this.opponentsTwoOn5 = opponentsTwoOn5;
        this.opponentsTwoOn4Open2 = opponentsTwoOn4Open2;
        this.opponentsTwoOn4Open1 = opponentsTwoOn4Open1;
        this.opponentsTwoOn3Open2 = opponentsTwoOn3Open2;
        this.opponentsTwoOn3Open1 = opponentsTwoOn3Open1;
    }
    public static AdvancedHeuristicsParameters getRandomParameters(Random random) {
        return new AdvancedHeuristicsParameters(random.nextInt() & Integer.MAX_VALUE,
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
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE,
                random.nextInt() & Integer.MAX_VALUE);
    }

    @Override
    public String toPrint() {
        return this.playersTwosOneEdge + "\n"
                + this.playersTwosTwoEdges + "\n"
                + this.playersThreesOneEdge + "\n"
                + this.playersThreesTwoEdges + "\n"
                + this.playersFoursOneEdge + "\n"
                + this.playersFoursTwoEdges + "\n"
                + this.playersFives + "\n"
                + this.playersFourHoleAfter3 + "\n"
                + this.playersFourHoleAfter2 + "\n"
                + this.playersThreeHoleAfter2Open2 + "\n"
                + this.playersThreeHoleAfter2Blocked1 + "\n" // _OO__OX
                + this.playersThreeHoleAfter2Blocked2 + "\n" // XOO__O_
                + this.playersThreeHoles2InRow + "\n" // OO__O
                + this.playersThreeHoles2Separated + "\n" //O_O_O
                + this.playersThree2OpenMax5 + "\n" // X_OOO_X
                + this.playersTwoOn5 + "\n" // O___O
                + this.playersTwoOn4Open2 + "\n" //_O__O_
                + this.playersTwoOn4Open1 + "\n" //XO__O_
                + this.playersTwoOn3Open2 + "\n" //_O_O_
                + this.playersTwoOn3Open1 + "\n" //XO_O_

                + this.opponentsTwosOneEdge + "\n"
                + this.opponentsTwosTwoEdges + "\n"
                + this.opponentsThreesOneEdge + "\n"
                + this.opponentsThreesTwoEdges + "\n"
                + this.opponentsFoursOneEdge + "\n"
                + this.opponentsFoursTwoEdges + "\n"
                + this.opponentsFives + "\n"
                + this.opponentsFourHoleAfter3 + "\n"
                + this.opponentsFourHoleAfter2 + "\n"
                + this.opponentsThreeHoleAfter2Open2 + "\n"
                + this.opponentsThreeHoleAfter2Blocked1 + "\n" // _OO__OX
                + this.opponentsThreeHoleAfter2Blocked2 + "\n" // XOO__O_
                + this.opponentsThreeHoles2InRow + "\n" // OO__O
                + this.opponentsThreeHoles2Separated + "\n" //O_O_O
                + this.opponentsThree2OpenMax5 + "\n" // X_OOO_X
                + this.opponentsTwoOn5 + "\n" // O___O
                + this.opponentsTwoOn4Open2 + "\n" //_O__O_
                + this.opponentsTwoOn4Open1 + "\n"//XO__O_
                + this.opponentsTwoOn3Open2 + "\n" //_O_O_
                + this.opponentsTwoOn3Open1 + "\n" ;
    }

    @Override
    public void mutateParameter(int parameterToMutate, double size, boolean isNegative) {
        double mutationMultiplier = isNegative ? (1-size) : (1 + size);
        switch (parameterToMutate) {
        case 0 -> this.playersTwosOneEdge = (int) (this.playersTwosOneEdge * mutationMultiplier);
        case 1 -> this.playersTwosTwoEdges = (int) (this.playersTwosTwoEdges * mutationMultiplier);
        case 2 -> this.playersThreesOneEdge = (int) (this.playersThreesOneEdge * mutationMultiplier);
        case 3 -> this.playersThreesTwoEdges = (int) (this.playersThreesTwoEdges * mutationMultiplier);
        case 4 -> this.playersFoursOneEdge = (int) (this.playersFoursOneEdge * mutationMultiplier);
        case 5 -> this.playersFoursTwoEdges = (int) (this.playersFoursTwoEdges * mutationMultiplier);
        case 6 -> this.playersFives = (int) (this.playersFives * mutationMultiplier);
        case 7 -> this.playersFourHoleAfter3 = (int) (this.playersFourHoleAfter3 * mutationMultiplier);
        case 8 -> this.playersFourHoleAfter2 = (int) (this.playersFourHoleAfter2 * mutationMultiplier);
        case 9 -> this.playersThreeHoleAfter2Open2 = (int) (this.playersThreeHoleAfter2Open2 * mutationMultiplier);
        case 10 -> this.playersThreeHoleAfter2Blocked1 = (int) (this.playersThreeHoleAfter2Blocked1 * mutationMultiplier);
        case 11 -> this.playersThreeHoleAfter2Blocked2 = (int) (this.playersThreeHoleAfter2Blocked2 * mutationMultiplier);
        case 12 -> this.playersThreeHoles2InRow = (int) (this.playersThreeHoles2InRow * mutationMultiplier);
        case 13 -> this.playersThreeHoles2Separated = (int) (this.playersThreeHoles2Separated * mutationMultiplier);
        case 14 -> this.playersThree2OpenMax5 = (int) (this.playersThree2OpenMax5 * mutationMultiplier);
        case 15 -> this.playersTwoOn5 = (int) (this.playersTwoOn5 * mutationMultiplier);
        case 16 -> this.playersTwoOn4Open2 = (int) (this.playersTwoOn4Open2 * mutationMultiplier);
        case 17 -> this.playersTwoOn4Open1 = (int) (this.playersTwoOn4Open1 * mutationMultiplier);
        case 18 -> this.playersTwoOn3Open2 = (int) (this.playersTwoOn3Open2 * mutationMultiplier);
        case 19 -> this.playersTwoOn3Open1 = (int) (this.playersTwoOn3Open1 * mutationMultiplier);

        case 20 -> this.opponentsTwosOneEdge = (int) (this.opponentsTwosOneEdge * mutationMultiplier);
        case 21 -> this.opponentsTwosTwoEdges = (int) (this.opponentsTwosTwoEdges * mutationMultiplier);
        case 22 -> this.opponentsThreesOneEdge = (int) (this.opponentsThreesOneEdge * mutationMultiplier);
        case 23 -> this.opponentsThreesTwoEdges = (int) (this.opponentsThreesTwoEdges * mutationMultiplier);
        case 24 -> this.opponentsFoursOneEdge = (int) (this.opponentsFoursOneEdge * mutationMultiplier);
        case 25 -> this.opponentsFoursTwoEdges = (int) (this.opponentsFoursTwoEdges * mutationMultiplier);
        case 26 -> this.opponentsFives = (int) (this.opponentsFives * mutationMultiplier);
        case 27 -> this.opponentsFourHoleAfter3 = (int) (this.opponentsFourHoleAfter3 * mutationMultiplier);
        case 28 -> this.opponentsFourHoleAfter2 = (int) (this.opponentsFourHoleAfter2 * mutationMultiplier);
        case 29 -> this.opponentsThreeHoleAfter2Open2 = (int) (this.opponentsThreeHoleAfter2Open2 * mutationMultiplier);
        case 30 -> this.opponentsThreeHoleAfter2Blocked1 = (int) (this.opponentsThreeHoleAfter2Blocked1 * mutationMultiplier);
        case 31 -> this.opponentsThreeHoleAfter2Blocked2 = (int) (this.opponentsThreeHoleAfter2Blocked2 * mutationMultiplier);
        case 32 -> this.opponentsThreeHoles2InRow = (int) (this.opponentsThreeHoles2InRow * mutationMultiplier);
        case 33 -> this.opponentsThreeHoles2Separated = (int) (this.opponentsThreeHoles2Separated * mutationMultiplier);
        case 34 -> this.opponentsThree2OpenMax5 = (int) (this.opponentsThree2OpenMax5 * mutationMultiplier);
        case 35 -> this.opponentsTwoOn5 = (int) (this.opponentsTwoOn5 * mutationMultiplier);
        case 36 -> this.opponentsTwoOn4Open2 = (int) (this.opponentsTwoOn4Open2 * mutationMultiplier);
        case 37 -> this.opponentsTwoOn4Open1 = (int) (this.opponentsTwoOn4Open1 * mutationMultiplier);
        case 38 -> this.opponentsTwoOn3Open2 = (int) (this.opponentsTwoOn3Open2 * mutationMultiplier);
        case 39 -> this.opponentsTwoOn3Open1 = (int) (this.opponentsTwoOn3Open1 * mutationMultiplier);
        }
    }

    @Override
    public void print() {
        System.out.println(this.toPrint());
    }

    @Override
    public IHeuristicsParameters swapOneOpenEdge(IHeuristicsParameters parameters2) {
        AdvancedHeuristicsParameters p2 = (AdvancedHeuristicsParameters) parameters2;
        return new AdvancedHeuristicsParameters(p2.playersTwosOneEdge,
                this.playersTwosTwoEdges,
                p2.playersThreesOneEdge,
                this.playersThreesTwoEdges,
                p2.playersFoursOneEdge,
                this.playersFoursTwoEdges,
                this.playersFives,
                this.playersFourHoleAfter3,
                this.playersFourHoleAfter2,
                this.playersThreeHoleAfter2Open2,
                p2.playersThreeHoleAfter2Blocked1, // _OO__OX
                p2.playersThreeHoleAfter2Blocked2, // XOO__O_
                this.playersThreeHoles2InRow, // OO__O
                this.playersThreeHoles2Separated, //O_O_O
                this.playersThree2OpenMax5, // X_OOO_X
                this.playersTwoOn5, // O___O
                this.playersTwoOn4Open2, //_O__O_
                p2.playersTwoOn4Open1, //XO__O_
                this.playersTwoOn3Open2, //_O_O_
                p2.playersTwoOn3Open1, //XO_O_

                p2.opponentsTwosOneEdge,
                this.opponentsTwosTwoEdges,
                p2.opponentsThreesOneEdge,
                this.opponentsThreesTwoEdges,
                p2.opponentsFoursOneEdge,
                this.opponentsFoursTwoEdges,
                this.opponentsFives,
                this.opponentsFourHoleAfter3,
                this.opponentsFourHoleAfter2,
                this.opponentsThreeHoleAfter2Open2,
                p2.opponentsThreeHoleAfter2Blocked1, // _OO__OX
                p2.opponentsThreeHoleAfter2Blocked2, // XOO__O_
                this.opponentsThreeHoles2InRow, // OO__O
                this.opponentsThreeHoles2Separated, //O_O_O
                this.opponentsThree2OpenMax5, // X_OOO_X
                this.opponentsTwoOn5, // O___O
                this.opponentsTwoOn4Open2, //_O__O_
                p2.opponentsTwoOn4Open1, //XO__O_
                this.opponentsTwoOn3Open2, //_O_O_
                p2.opponentsTwoOn3Open1 );
    }

    @Override
    public IHeuristicsParameters swapOpenEdges(IHeuristicsParameters parameters2) {
        AdvancedHeuristicsParameters p2 = (AdvancedHeuristicsParameters) parameters2;
        return new AdvancedHeuristicsParameters(this.playersTwosOneEdge,
                p2.playersTwosTwoEdges,
                this.playersThreesOneEdge,
                p2.playersThreesTwoEdges,
                this.playersFoursOneEdge,
                p2.playersFoursTwoEdges,
                p2.playersFives,
                p2.playersFourHoleAfter3,
                p2.playersFourHoleAfter2,
                p2.playersThreeHoleAfter2Open2,
                this.playersThreeHoleAfter2Blocked1, // _OO__OX
                this.playersThreeHoleAfter2Blocked2, // XOO__O_
                p2.playersThreeHoles2InRow, // OO__O
                p2.playersThreeHoles2Separated, //O_O_O
                p2.playersThree2OpenMax5, // X_OOO_X
                p2.playersTwoOn5, // O___O
                p2.playersTwoOn4Open2, //_O__O_
                this.playersTwoOn4Open1, //XO__O_
                p2.playersTwoOn3Open2, //_O_O_
                this.playersTwoOn3Open1, //XO_O_

                this.opponentsTwosOneEdge,
                p2.opponentsTwosTwoEdges,
                this.opponentsThreesOneEdge,
                p2.opponentsThreesTwoEdges,
                this.opponentsFoursOneEdge,
                p2.opponentsFoursTwoEdges,
                p2.opponentsFives,
                p2.opponentsFourHoleAfter3,
                p2.opponentsFourHoleAfter2,
                p2.opponentsThreeHoleAfter2Open2,
                this.opponentsThreeHoleAfter2Blocked1, // _OO__OX
                this.opponentsThreeHoleAfter2Blocked2, // XOO__O_
                p2.opponentsThreeHoles2InRow, // OO__O
                p2.opponentsThreeHoles2Separated, //O_O_O
                p2.opponentsThree2OpenMax5, // X_OOO_X
                p2.opponentsTwoOn5, // O___O
                p2.opponentsTwoOn4Open2, //_O__O_
                this.opponentsTwoOn4Open1, //XO__O_
                p2.opponentsTwoOn3Open2, //_O_O_
                this.opponentsTwoOn3Open1 );
    }

    @Override
    public IHeuristicsParameters swapSecondHalf(IHeuristicsParameters iParameters2) {
        AdvancedHeuristicsParameters parameters2 = (AdvancedHeuristicsParameters) iParameters2;
        return new AdvancedHeuristicsParameters(this.playersTwosOneEdge,
                this.playersTwosTwoEdges,
                this.playersThreesOneEdge,
                this.playersThreesTwoEdges,
                this.playersFoursOneEdge,
                this.playersFoursTwoEdges,
                this.playersFives,
                this.playersFourHoleAfter3,
                this.playersFourHoleAfter2,
                this.playersThreeHoleAfter2Open2,
                this.playersThreeHoleAfter2Blocked1, // _OO__OX
                this.playersThreeHoleAfter2Blocked2, // XOO__O_
                this.playersThreeHoles2InRow, // OO__O
                this.playersThreeHoles2Separated, //O_O_O
                this.playersThree2OpenMax5, // X_OOO_X
                this.playersTwoOn5, // O___O
                this.playersTwoOn4Open2, //_O__O_
                this.playersTwoOn4Open1, //XO__O_
                this.playersTwoOn3Open2, //_O_O_
                this.playersTwoOn3Open1, //XO_O_

                parameters2.opponentsTwosOneEdge,
                parameters2.opponentsTwosTwoEdges,
                parameters2.opponentsThreesOneEdge,
                parameters2.opponentsThreesTwoEdges,
                parameters2.opponentsFoursOneEdge,
                parameters2.opponentsFoursTwoEdges,
                parameters2.opponentsFives,
                parameters2.opponentsFourHoleAfter3,
                parameters2.opponentsFourHoleAfter2,
                parameters2.opponentsThreeHoleAfter2Open2,
                parameters2.opponentsThreeHoleAfter2Blocked1, // _OO__OX
                parameters2.opponentsThreeHoleAfter2Blocked2, // XOO__O_
                parameters2.opponentsThreeHoles2InRow, // OO__O
                parameters2.opponentsThreeHoles2Separated, //O_O_O
                parameters2.opponentsThree2OpenMax5, // X_OOO_X
                parameters2.opponentsTwoOn5, // O___O
                parameters2.opponentsTwoOn4Open2, //_O__O_
                parameters2.opponentsTwoOn4Open1,//XO__O_
                parameters2.opponentsTwoOn3Open2, //_O_O_
                parameters2.opponentsTwoOn3Open1);
    }

    @Override
    public IHeuristicsParameters swapFirstHalf(IHeuristicsParameters iParameters2) {
        AdvancedHeuristicsParameters parameters2 = (AdvancedHeuristicsParameters) iParameters2;
        return new AdvancedHeuristicsParameters(this.playersTwosOneEdge,
                parameters2.playersTwosTwoEdges,
                parameters2.playersThreesOneEdge,
                parameters2.playersThreesTwoEdges,
                parameters2.playersFoursOneEdge,
                parameters2.playersFoursTwoEdges,
                parameters2.playersFives,
                parameters2.playersFourHoleAfter3,
                parameters2.playersFourHoleAfter2,
                parameters2.playersThreeHoleAfter2Open2,
                parameters2.playersThreeHoleAfter2Blocked1, // _OO__OX
                parameters2.playersThreeHoleAfter2Blocked2, // XOO__O_
                parameters2.playersThreeHoles2InRow, // OO__O
                parameters2.playersThreeHoles2Separated, //O_O_O
                parameters2.playersThree2OpenMax5, // X_OOO_X
                parameters2.playersTwoOn5, // O___O
                parameters2.playersTwoOn4Open2, //_O__O_
                parameters2.playersTwoOn4Open1, //XO__O_
                parameters2.playersTwoOn3Open2, //_O_O_
                parameters2.playersTwoOn3Open1, //XO_O_

                this.opponentsTwosOneEdge,
                this.opponentsTwosTwoEdges,
                this.opponentsThreesOneEdge,
                this.opponentsThreesTwoEdges,
                this.opponentsFoursOneEdge,
                this.opponentsFoursTwoEdges,
                this.opponentsFives,
                this.opponentsFourHoleAfter3,
                this.opponentsFourHoleAfter2,
                this.opponentsThreeHoleAfter2Open2,
                this.opponentsThreeHoleAfter2Blocked1, // _OO__OX
                this.opponentsThreeHoleAfter2Blocked2, // XOO__O_
                this.opponentsThreeHoles2InRow, // OO__O
                this.opponentsThreeHoles2Separated, //O_O_O
                this.opponentsThree2OpenMax5, // X_OOO_X
                this.opponentsTwoOn5, // O___O
                this.opponentsTwoOn4Open2, //_O__O_
                this.opponentsTwoOn4Open1,//XO__O_
                this.opponentsTwoOn3Open2, //_O_O_
                this.opponentsTwoOn3Open1);
    }
}
