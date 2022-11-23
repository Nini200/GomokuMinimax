package GeneticAlgorithm;

import GeneticAlgorithm.Choosers.AbstractChooser;
import GeneticAlgorithm.Crossings.ICrossing;
import GeneticAlgorithm.Evaluators.IEvaluator;
import GeneticAlgorithm.PopulationCreators.IPopulationCreator;
import GeneticAlgorithm.PopulationCreators.PopulationCreatorResult;
import GeneticAlgorithm.StopConditions.IStopCondition;
import Minimax.IHeuristicsParameters;

import java.io.IOException;

public class GeneticAlgorithm {
    ICrossing crossing;
    IEvaluator evaluator;
    IHeuristicsParameters[] population;
    int populationSize;
    IStopCondition stopCondition;
    AbstractChooser chooser;
    private final double mutationProbability;
    private final double mutationSize;

    private final IPopulationCreator populationCreator;

    public GeneticAlgorithm(ICrossing crossing,
                            IEvaluator evaluator,
                            IStopCondition stopCondition,
                            int populationSize,
                            boolean isAdvanced,
                            AbstractChooser chooser,
                            double mutationProbability,
                            double mutationSize,
                            IPopulationCreator populationCreator) {
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.chooser = chooser;
        this.population = PopulationUtils.getRandomPopulation(populationSize, isAdvanced);
        this.mutationProbability = mutationProbability;
        this.mutationSize = mutationSize;
        this.populationCreator = populationCreator;
    }

    public GeneticAlgorithm(ICrossing crossing,
                            IEvaluator evaluator,
                            IStopCondition stopCondition,
                            int populationSize,
                            AbstractChooser chooser,
                            IHeuristicsParameters[] startPopulation,
                            double mutationProbability,
                            double mutationSize,
                            IPopulationCreator populationCreator) {
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.chooser = chooser;
        this.population = startPopulation;
        this.mutationProbability = mutationProbability;
        this.mutationSize = mutationSize;
        this.populationCreator = populationCreator;
    }

    private int findBestParameters(IHeuristicsParameters[] population,
                                                    int[] evaluation,
                                                    int populationSize) {
        int parametersIndex = 0;
        int bestEvaluation = evaluation[0];
        for (int i = 1; i < populationSize; i++) {
            if (evaluation[i] > bestEvaluation) {
                parametersIndex = i;
            }
        }
        return parametersIndex;
    }

    public IHeuristicsParameters run(String logName) throws IOException {
        stopCondition.setup();
        chooser.setup(populationSize);
        int[] evaluation = evaluator.evaluate(population);
        int[] newEvaluation;
        PopulationCreatorResult populationCreatorResult;
        int populationNumber = 0;
        while (!stopCondition.shouldStop()) {
            chooser.updateChooser(evaluation);
            IHeuristicsParameters[] newPopulation = new IHeuristicsParameters[populationSize];
            for (int i = 0; i < populationSize; i++) {
                int firstParent = chooser.choose();
                int secondParent = chooser.choose();
                newPopulation[i] = PopulationUtils.getChild(
                        population[firstParent],
                        population[secondParent],
                        crossing,
                        mutationProbability,
                        mutationSize
                );
            }
            newEvaluation = evaluator.evaluate(newPopulation);
            populationCreatorResult = populationCreator.genNewPopulation(population, newPopulation, evaluation, newEvaluation);
            population = populationCreatorResult.getPopulation();
            evaluation = populationCreatorResult.getEvaluation();
            populationNumber++;
            PopulationUtils.writePopulationToFile(population, populationNumber, logName + "_pop.txt");
            stopCondition.next();
        }
        int bestIndex = findBestParameters(population, evaluation, populationSize);
        PopulationUtils.writeBestToFile(population[bestIndex], evaluation[bestIndex], logName + "_result.txt");
        return population[bestIndex];
    }


}
