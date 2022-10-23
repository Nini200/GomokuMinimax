package GeneticAlgorithm.Crossings;

import Minimax.HeuristicsParameters;

public class SecondHalfSwapCrossing implements ICrossing{
    @Override
    public HeuristicsParameters cross(HeuristicsParameters parameters1, HeuristicsParameters parameters2) {
        return parameters1.swapSecondHalf(parameters2);
    }
}
