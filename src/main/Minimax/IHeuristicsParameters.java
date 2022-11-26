package Minimax;

import java.util.Random;

public interface IHeuristicsParameters {
    static IHeuristicsParameters getRandomParameters(Random random){
        return null;
    }

    IHeuristicsParameters swapFirstHalf(IHeuristicsParameters parameters2);

    IHeuristicsParameters swapSecondHalf(IHeuristicsParameters parameters2);

    String toPrint();

    void mutateParameter(int parameterToMutate, double size, boolean isNegative);

    void print();

    IHeuristicsParameters swapOpenEdges(IHeuristicsParameters parameters2);

    IHeuristicsParameters swapOneOpenEdge(IHeuristicsParameters parameters2);
}
