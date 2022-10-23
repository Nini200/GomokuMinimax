package GeneticAlgorithm;

import GeneticAlgorithm.Choosers.AbstractChooser;
import GeneticAlgorithm.Crossings.ICrossing;
import GeneticAlgorithm.Evaluators.IEvaluator;
import GeneticAlgorithm.StopConditions.IStopCondition;
import Minimax.HeuristicsParameters;

public class GeneticAlgorithm {
    ICrossing crossing;
    IEvaluator evaluator;
    HeuristicsParameters[] population;
    int populationSize;
    IStopCondition stopCondition;
    AbstractChooser chooser;
    private final double mutationProbability;
    private final double mutationSize;

    public GeneticAlgorithm (ICrossing crossing,
                             IEvaluator evaluator,
                             IStopCondition stopCondition,
                             int populationSize,
                             AbstractChooser chooser,
                             double mutationProbability,
                             double mutationSize){
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.chooser = chooser;
        this.population = PopulationCreator.getRandomPopulation(populationSize);
        this.mutationProbability = mutationProbability;
        this.mutationSize = mutationSize;
    }
    public GeneticAlgorithm (ICrossing crossing,
                             IEvaluator evaluator,
                             IStopCondition stopCondition,
                             int populationSize,
                             AbstractChooser chooser,
                             HeuristicsParameters [] startPopulation,
                             double mutationProbability,
                             double mutationSize){
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.chooser = chooser;
        this.population = startPopulation;
        this.mutationProbability = mutationProbability;
        this.mutationSize = mutationSize;
    }

    private HeuristicsParameters findBestParameters(HeuristicsParameters[] population,
                                                    int[] evaluation,
                                                    int populationSize) {
        int parametersIndex = 0;
        int bestEvaluation = evaluation[0];
        for (int i = 1; i<populationSize; i++){
            if(evaluation[i]>bestEvaluation){
                parametersIndex = i;
            }
        }
        return population[parametersIndex];
    }
    public HeuristicsParameters run(){
        stopCondition.setup();
        chooser.setup(populationSize);
        int [] evaluation = evaluator.evaluate(population);
        while (!stopCondition.shouldStop()){
            chooser.updateChooser(evaluation);
            HeuristicsParameters[] newPopulation = new HeuristicsParameters[populationSize];
            for (int i = 0; i < populationSize; i++){
                int firstParent = chooser.choose();
                int secondParent = chooser.choose();
                newPopulation[i] = PopulationCreator.getChild(
                        population[firstParent],
                        population[secondParent],
                        crossing,
                        mutationProbability,
                        mutationSize
                );
            }
            population = newPopulation;
            evaluation = evaluator.evaluate(population);
            stopCondition.next();
        }
        return findBestParameters(population, evaluation, populationSize);
    }


}
