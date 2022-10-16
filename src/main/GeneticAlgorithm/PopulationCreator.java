package GeneticAlgorithm;

import Minimax.IHeuristics;

public class PopulationCreator {
    public static IHeuristics[] getRandomPopulation(int populationSize){
        return new IHeuristics[populationSize];
    }
}
