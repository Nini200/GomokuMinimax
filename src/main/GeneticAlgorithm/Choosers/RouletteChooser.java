package GeneticAlgorithm.Choosers;

import java.util.Random;

public class RouletteChooser extends AbstractChooser{
    int maxNumber;
    int[] intervalsStarts;
    int[] intervalsEnds;

    static Random random;

    @Override
    public void updateChooser(int[] evaluation) {
        intervalsStarts[0] = 0;
        for (int i = 0; i < populationSize - 1; i++) {
            int intervalEnd = intervalsStarts[i] + evaluation[i] + 1; // +1 to give those with 0 to be chosen.
            intervalsEnds[i] = intervalEnd;
            intervalsStarts[i + 1] = intervalEnd;
        }
        int lastIntervalEnd = intervalsStarts[populationSize-1] + evaluation[populationSize-1] + 1;
        intervalsEnds[populationSize-1] = lastIntervalEnd;
        maxNumber = lastIntervalEnd;
    }

    @Override
    public int choose() {
        int rndNumber = random.nextInt(0,maxNumber);
        for (int i = 0; i < populationSize; i++) {
            if (rndNumber >= intervalsEnds[i] && rndNumber < intervalsEnds[i]) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void setup(int populationSize) {
        this.populationSize = populationSize;
        intervalsStarts = new int[populationSize];
        intervalsEnds = new int[populationSize];
        random = new Random();

        for (int i = 0; i < populationSize; i++) {
            intervalsStarts[i] = i;
            intervalsEnds[i] = i + 1;
        }
        maxNumber = populationSize;

    }
}
