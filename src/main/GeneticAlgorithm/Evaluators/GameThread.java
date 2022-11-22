package GeneticAlgorithm.Evaluators;

import Game.AIsGame;
import Game.AIsGameResult;
import Minimax.AdvancedHeuristicsParameters;
import Minimax.GomokuHeuristics;
import Minimax.HeuristicsParameters;
import Minimax.IHeuristicsParameters;

public class GameThread extends Thread{
    IHeuristicsParameters parameters1;
    IHeuristicsParameters parameters2;
    int parametersIndex1;
    int parametersIndex2;
    GameEvaluator gameEvaluator;
    AIsGameResult winner;
    boolean done = false;
    int threadNumber;

    public void setGameThread(IHeuristicsParameters parameters1,
                              IHeuristicsParameters parameters2,
                              int parametersIndex1,
                              int parametersIndex2,
                              GameEvaluator gameEvaluator,
                              int threadNumber) {
        this.parameters1 = parameters1;
        this.parameters2 = parameters2;
        this.parametersIndex1 = parametersIndex1;
        this.parametersIndex2 = parametersIndex2;
        this.gameEvaluator = gameEvaluator;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        GomokuHeuristics heuristics1;
        GomokuHeuristics heuristics2;
        if(parameters1 instanceof HeuristicsParameters){
            heuristics1 = new GomokuHeuristics((HeuristicsParameters) parameters1);
            heuristics2 = new GomokuHeuristics((HeuristicsParameters) parameters2);
        }
        else{
            heuristics1 = new GomokuHeuristics((AdvancedHeuristicsParameters) parameters1);
            heuristics2 = new GomokuHeuristics((AdvancedHeuristicsParameters) parameters2);
        }
        AIsGame aIsGame = new AIsGame(heuristics1, heuristics2, 15, 3);
        winner = aIsGame.run();
        done = true;
        System.out.println("Thread " + threadNumber + "done.");
    }
}
