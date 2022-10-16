package GeneticAlgorithm;

public interface IStopCondition {
    boolean shouldStop();
    void next();
    void setup();
}
