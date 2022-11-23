package GeneticAlgorithm;

import GeneticAlgorithm.Crossings.ICrossing;
import Minimax.AdvancedHeuristicsParameters;
import Minimax.HeuristicsParameters;
import Minimax.IHeuristicsParameters;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PopulationUtils {
    static Random random = new Random();
    private static void mutate(IHeuristicsParameters parameters,
                               double probability,
                               double size){
        double randomNumber = random.nextDouble();
        if(randomNumber<=probability){
            int parameterToMutate = random.nextInt(14);
            boolean isNegative = random.nextBoolean();
            parameters.mutateParameter(parameterToMutate, size, isNegative);
        }
    }
    public static IHeuristicsParameters[] getRandomPopulation(int populationSize, boolean isAdvanced){
        IHeuristicsParameters[] population = new IHeuristicsParameters[populationSize];
        for (int i = 0; i < populationSize; i++) {
            if(!isAdvanced){
                population[i]= HeuristicsParameters.getRandomParameters(random);
            }
            else {
                population[i] = AdvancedHeuristicsParameters.getRandomParameters(random);
            }
        }
        return population;
    }
    public static IHeuristicsParameters getChild(IHeuristicsParameters parent1,
                                                IHeuristicsParameters parent2,
                                                ICrossing crossing,
                                                double probability,
                                                double size){
        IHeuristicsParameters newHeuristics = crossing.cross(parent1, parent2);
        mutate(newHeuristics, probability, size);
        return newHeuristics;
    }

    public static void writePopulationToFile(IHeuristicsParameters[] population, int numOfPopulation, String logName) throws IOException {
        FileWriter fileWriter = new FileWriter(logName, false);
        fileWriter.append(numOfPopulation + "\n");
        for (IHeuristicsParameters parameters : population) {
            try {
                fileWriter.append(parameters.toPrint());
                fileWriter.flush();
            } catch (IOException e) {
                System.err.print(e.getMessage());
            }
        }
    }

    public static void writeBestToFile(IHeuristicsParameters best, int eval, String logName) throws IOException {
        FileWriter fileWriter = new FileWriter(logName, false);
        try {
            fileWriter.append(best.toPrint());
            fileWriter.append("\n" + eval);
            fileWriter.flush();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
//    public HeuristicsParameters[] readPopulationFromFile(String fileName, int populationSize) {
//        Scanner
//    }
}
