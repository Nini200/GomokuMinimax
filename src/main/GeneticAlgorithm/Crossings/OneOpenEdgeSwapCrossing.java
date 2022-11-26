package GeneticAlgorithm.Crossings;

import Minimax.IHeuristicsParameters;

public class OneOpenEdgeSwapCrossing implements ICrossing {

    @Override
    public IHeuristicsParameters cross(IHeuristicsParameters parameters1, IHeuristicsParameters parameters2) {
        return parameters1.swapOneOpenEdge(parameters2);
    }
}
