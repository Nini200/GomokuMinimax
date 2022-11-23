package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public class ParentPercentageBestPopulationCreator implements IPopulationCreator{
    // from 0.0 (inclusive) to 1.0 (exclusive)
    double percentageOfParents;

    public ParentPercentageBestPopulationCreator(double percentageOfParents) {
        this.percentageOfParents = percentageOfParents;
    }
    @Override
    public PopulationCreatorResult genNewPopulation(IHeuristicsParameters[] oldPopulation,
                                                    IHeuristicsParameters[] candidates,
                                                    int[] oldEvaluation,
                                                    int[] newEvaluation) {
        return new PopulationCreatorResult(new IHeuristicsParameters[0], new int[0]);
    }
}
