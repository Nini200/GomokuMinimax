package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public class ParentPercentagePopulationCreator implements IPopulationCreator{
    // from 0.0 (inclusive) to 1.0 (exclusive)
    double percentageOfParents;

    ParentPercentagePopulationCreator(double percentageOfParents) {
        this.percentageOfParents = percentageOfParents;
    }
    @Override
    public IHeuristicsParameters[] genNewPopulation(IHeuristicsParameters[] oldPopulation, IHeuristicsParameters[] candidates) {
        return new IHeuristicsParameters[0];
    }
}
