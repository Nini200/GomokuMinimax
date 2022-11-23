package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public interface IPopulationCreator {
    PopulationCreatorResult genNewPopulation(IHeuristicsParameters[] oldPopulation,
                                             IHeuristicsParameters[] candidates,
                                             int[] oldEvaluation,
                                             int[] newEvaluation);
}
