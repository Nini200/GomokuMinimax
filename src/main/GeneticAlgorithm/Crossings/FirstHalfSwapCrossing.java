package GeneticAlgorithm.Crossings;

import Minimax.HeuristicsParameters;

public class FirstHalfSwapCrossing implements ICrossing{
    @Override
    public HeuristicsParameters cross(HeuristicsParameters parameters1, HeuristicsParameters parameters2) {
        return parameters1.swapFirstHalf(parameters2);
    }
}
