package GeneticAlgorithm.Crossings;

import Minimax.IHeuristicsParameters;

public class FirstHalfSwapCrossing implements ICrossing{
    @Override
    public IHeuristicsParameters cross(IHeuristicsParameters parameters1, IHeuristicsParameters parameters2) {
        return parameters1.swapFirstHalf(parameters2);
    }
}
