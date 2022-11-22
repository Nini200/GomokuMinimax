package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public interface IPopulationCreator {
    IHeuristicsParameters[] genNewPopulation(IHeuristicsParameters[] oldPopulation,
                                             IHeuristicsParameters[] candidates);
}
