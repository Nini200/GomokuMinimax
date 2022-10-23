package GeneticAlgorithm.StopConditions;

public class TimeStopCondition implements IStopCondition {
    long currentTime = 0;
    long maxTime = 0;
    double maxSeconds;

    public TimeStopCondition(double maxSeconds){
        this.maxSeconds = maxSeconds;
        setup();
    }

    @Override
    public void setup() {
        currentTime = System.currentTimeMillis();
        maxTime = currentTime + (long) (maxSeconds * 1000);
    }
    @Override
    public boolean shouldStop() {
        return currentTime >= maxTime;
    }

    @Override
    public void next() {
        currentTime = System.currentTimeMillis();
    }
}
