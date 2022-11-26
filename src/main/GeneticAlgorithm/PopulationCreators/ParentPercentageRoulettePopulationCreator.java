package GeneticAlgorithm.PopulationCreators;

import GeneticAlgorithm.Choosers.RouletteChooser;
import Minimax.IHeuristicsParameters;

import java.util.ArrayList;

public class ParentPercentageRoulettePopulationCreator implements IPopulationCreator{
    double percentageOfParents;

    public ParentPercentageRoulettePopulationCreator(double percentageOfParents) {
        this.percentageOfParents = percentageOfParents;
    }
    @Override
    public PopulationCreatorResult genNewPopulation(IHeuristicsParameters[] oldPopulation,
                                                    IHeuristicsParameters[] candidates,
                                                    int[] oldEvaluation,
                                                    int[] candidatesEvaluation) {
        int oldPopulationSize = oldPopulation.length;
        int candidatesPopulationSize = candidates.length;
        int numberOfParents = (int) percentageOfParents * oldPopulationSize;
        ArrayList<Integer> parentIndices = new ArrayList<>();
        ArrayList<Integer> childrenIndices = new ArrayList<>();
        IHeuristicsParameters[] newPopulation = new IHeuristicsParameters[oldPopulationSize];
        int[] newEvaluation = new int[oldPopulationSize];


        RouletteChooser rouletteChooser = new RouletteChooser();
        rouletteChooser.setup(oldPopulationSize);
        rouletteChooser.updateChooser(oldEvaluation);
        for (int i = 0; i < numberOfParents; i++) {
            int index = rouletteChooser.choose();
            parentIndices.add(index);
            newPopulation[i] = oldPopulation[index];
            newEvaluation[i] = oldEvaluation[index];
        }

        rouletteChooser.setup(candidatesPopulationSize);
        rouletteChooser.updateChooser(candidatesEvaluation);
        for (int i = numberOfParents; i < oldPopulationSize; i++) {
            int index = rouletteChooser.choose();
            childrenIndices.add(index);
            newPopulation[i] = candidates[index];
            newEvaluation[i] = candidatesEvaluation[index];
        }


        return new PopulationCreatorResult(newPopulation, newEvaluation);
    }

}
