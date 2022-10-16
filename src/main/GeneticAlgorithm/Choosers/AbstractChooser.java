package GeneticAlgorithm.Choosers;

public abstract class AbstractChooser {
    int maxNumber;
    int[] intervalsStarts;
    int[] intervalsEnds;

    public abstract void updateChooser(int[] evaluation);
    public abstract int choose();
}
