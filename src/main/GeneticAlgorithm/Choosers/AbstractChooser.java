package GeneticAlgorithm.Choosers;

public abstract class AbstractChooser {
    int populationSize;

    public abstract void updateChooser(int[] evaluation);
    public abstract int choose();
    public abstract void setup(int populationSize);
}
