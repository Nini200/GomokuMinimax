package GeneticAlgorithm;

import Minimax.IHeuristics;

public class GeneticAlgorithm {
    ICrossing crossing;
    IEvaluator evaluator;
    IHeuristics[] population;
    int populationSize;
    IStopCondition stopCondition;

    public GeneticAlgorithm (ICrossing crossing,
                             IEvaluator evaluator,
                             IStopCondition stopCondition,
                             int populationSize){
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.population = PopulationCreator.getRandomPopulation(populationSize);
    }
    public GeneticAlgorithm (ICrossing crossing,
                             IEvaluator evaluator,
                             IStopCondition stopCondition,
                             int populationSize,
                             IHeuristics [] startPopulation){
        this.crossing = crossing;
        this.evaluator = evaluator;
        this.stopCondition = stopCondition;
        this.populationSize = populationSize;
        this.population = startPopulation;
    }

    public void run(){
        stopCondition.setup();
        while (!stopCondition.shouldStop()){
            int[] evaluation = evaluator.evaluate(population);



            stopCondition.next();
        }
    }


}
