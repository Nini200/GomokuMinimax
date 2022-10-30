package GeneticAlgorithm.StopConditions;

public class IterationsStopCondition implements IStopCondition {
    private int iterations = 0;
    private final int maxIterations;

    public IterationsStopCondition(int maxIterations) {
        this.maxIterations = maxIterations;
    }
    @Override
    public boolean shouldStop() {
        return iterations >= maxIterations;
    }

    @Override
    public void next() {
        iterations++;
    }

    @Override
    public void setup() {
        return;
    }
}
