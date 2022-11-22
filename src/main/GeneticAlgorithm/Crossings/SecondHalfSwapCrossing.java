package GeneticAlgorithm.Crossings;

import Minimax.IHeuristicsParameters;

public class SecondHalfSwapCrossing implements ICrossing{
    @Override
    public IHeuristicsParameters cross(IHeuristicsParameters parameters1, IHeuristicsParameters parameters2) {
        return parameters1.swapSecondHalf(parameters2);
    }
}
