package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public class OnlyNewPopulationCreator implements IPopulationCreator{
    @Override
    public IHeuristicsParameters[] genNewPopulation(IHeuristicsParameters[] oldPopulation, IHeuristicsParameters[] candidates) {
        return candidates;
    }
}
