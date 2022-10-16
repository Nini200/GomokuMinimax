package GeneticAlgorithm.StopConditions;

public interface IStopCondition {
    boolean shouldStop();
    void next();
    void setup();
}
