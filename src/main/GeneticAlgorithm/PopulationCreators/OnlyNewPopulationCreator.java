package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public class OnlyNewPopulationCreator implements IPopulationCreator{
    @Override
    public PopulationCreatorResult genNewPopulation(IHeuristicsParameters[] oldPopulation,
                                                    IHeuristicsParameters[] candidates,
                                                    int[] oldEvaluation,
                                                    int[] newEvaluation)  {
        return new PopulationCreatorResult(oldPopulation, oldEvaluation);
    }
}
