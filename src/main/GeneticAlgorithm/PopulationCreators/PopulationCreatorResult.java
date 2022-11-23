package GeneticAlgorithm.PopulationCreators;

import Minimax.IHeuristicsParameters;

public class PopulationCreatorResult{
    IHeuristicsParameters[] population;
    int[] evaluation;

    public IHeuristicsParameters[] getPopulation() {
        return population;
    }

    public int[] getEvaluation() {
        return evaluation;
    }

    public PopulationCreatorResult(IHeuristicsParameters[] population,
                                   int[] evaluation) {
        this.population = population;
        this.evaluation = evaluation;
    }
}
