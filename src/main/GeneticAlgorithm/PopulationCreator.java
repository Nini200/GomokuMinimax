package GeneticAlgorithm;

import GeneticAlgorithm.Crossings.ICrossing;
import Minimax.HeuristicsParameters;

import java.util.Random;

public class PopulationCreator {
    static Random random = new Random();
    private static void mutate(HeuristicsParameters parameters,
                               double probability,
                               double size){
        double randomNumber = random.nextDouble();
        if(randomNumber<=probability){
            int parameterToMutate = random.nextInt(14);
            boolean isNegative = random.nextBoolean();
            parameters.mutateParameter(parameterToMutate, size, isNegative);
        }
    }
    public static HeuristicsParameters[] getRandomPopulation(int populationSize){
        //TODO
        return new HeuristicsParameters[populationSize];
    }
    public static HeuristicsParameters getChild(HeuristicsParameters parent1,
                                                HeuristicsParameters parent2,
                                                ICrossing crossing,
                                                double probability,
                                                double size){
        HeuristicsParameters newHeuristics = crossing.cross(parent1, parent2);
        mutate(newHeuristics, probability, size);
        return newHeuristics;
    }
}
