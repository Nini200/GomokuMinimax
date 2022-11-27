import GeneticAlgorithm.Choosers.AbstractChooser;
import GeneticAlgorithm.Choosers.RouletteChooser;
import GeneticAlgorithm.Crossings.FirstHalfSwapCrossing;
import GeneticAlgorithm.Crossings.ICrossing;
import GeneticAlgorithm.Crossings.NoCrossing;
import GeneticAlgorithm.Crossings.SecondHalfSwapCrossing;
import GeneticAlgorithm.Evaluators.GameEvaluator;
import GeneticAlgorithm.Evaluators.IEvaluator;
import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.PopulationCreators.IPopulationCreator;
import GeneticAlgorithm.PopulationCreators.OnlyNewPopulationCreator;
import GeneticAlgorithm.PopulationCreators.ParentPercentageBestPopulationCreator;
import GeneticAlgorithm.PopulationCreators.ParentPercentageRoulettePopulationCreator;
import GeneticAlgorithm.StopConditions.IStopCondition;
import GeneticAlgorithm.StopConditions.IterationsStopCondition;
import GeneticAlgorithm.StopConditions.TimeStopCondition;
import GeneticAlgorithm.PopulationFromFile;
import Minimax.IHeuristicsParameters;

import java.io.IOException;

public class MainTests {
    public static void main(String[] args) {
        // -------------- Defaults -----------
        ICrossing crossing = new NoCrossing();
        IEvaluator evaluator = new GameEvaluator();
        IStopCondition stopCondition = new IterationsStopCondition(20);
        int populationSize = 30;
        AbstractChooser chooser = new RouletteChooser();
        double mutationProbability = 0.2;
        double mutationSize = 0.2;
        IPopulationCreator populationCreator = new OnlyNewPopulationCreator();
        boolean isAdvancedHeuristics = false;

        String cr = System.getProperty("cr");
        String sc = System.getProperty("sc");
        String ch = System.getProperty("ch");
        String pc = System.getProperty("pc");
        String ah = System.getProperty("ah");
        String ps = System.getProperty("ps");
        String mp = System.getProperty("mp");
        String ms = System.getProperty("ms");
        String ip = System.getProperty("ip"); //Initial Population

        if(cr != null){
            switch (cr){
                case "fh" -> crossing = new FirstHalfSwapCrossing();
                case "sh" -> crossing = new SecondHalfSwapCrossing();
                default -> crossing = new NoCrossing();
            }
        }
        if (sc != null) {
            switch (sc) {
                case "it" -> {
                    int iterations = Integer.parseInt(System.getProperty("itNum"));
                    stopCondition = new IterationsStopCondition(iterations);
                }
                case "time" ->{
                    int time = Integer.parseInt(System.getProperty("time"));
                    stopCondition = new TimeStopCondition(time);
                }
            }
        }

        if (ah != null) {
            switch (ah) {
                case "a" -> isAdvancedHeuristics = true;
                default -> isAdvancedHeuristics = false;
            }
        }

        if (pc != null) {
            switch (pc) {
                case "parentBest" -> {
                    double percentage = Double.parseDouble(System.getProperty("perc"));
                    populationCreator = new ParentPercentageBestPopulationCreator(percentage);
                }
                case "parentR" -> {
                    double percentage = Double.parseDouble(System.getProperty("perc"));
                    populationCreator = new ParentPercentageRoulettePopulationCreator(percentage);
                }
                default -> populationCreator = new OnlyNewPopulationCreator();
            }
        }

        if (ch != null) {
            switch (ch) {
                default -> chooser = new RouletteChooser();
            }
        }

        if (ps != null) {
            populationSize = Integer.parseInt(ps);
        }

        if (mp != null) {
            mutationProbability = Double.parseDouble(mp);
        }

        if (ms != null) {
            mutationSize = Double.parseDouble(ms);
        }

        String fileLogName = ps + pc + sc + cr + ch + mp + ms + ah;

        GeneticAlgorithm geneticAlgorithm;

        if (ip == null) {
            geneticAlgorithm = new GeneticAlgorithm(crossing,
                    evaluator,
                    stopCondition,
                    populationSize,
                    isAdvancedHeuristics,
                    chooser,
                    mutationProbability,
                    mutationSize,
                    populationCreator);
        }
        else{
            String file = System.getProperty("file");
            PopulationFromFile populationFromFile = new PopulationFromFile(file, isAdvancedHeuristics);
            populationFromFile.readFromFileWithIterations();
            IHeuristicsParameters[] initialPopulation = populationFromFile.getPopulation();

            geneticAlgorithm = new GeneticAlgorithm(crossing,
                    evaluator,
                    stopCondition,
                    populationSize,
                    isAdvancedHeuristics,
                    chooser,
                    mutationProbability,
                    mutationSize,
                    populationCreator,
                    initialPopulation);
        }

        IHeuristicsParameters best = null;

        try {
            best = geneticAlgorithm.run(fileLogName);
        } catch (IOException e) {
            System.err.println("Error writing to log");
            System.err.println(e.getMessage());
        }
        System.out.println(System.getProperty("noname"));
        System.out.println(populationSize);
    }
}
