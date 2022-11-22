package GeneticAlgorithm.Evaluators;

import Game.AIsGameResult;
import Minimax.IHeuristicsParameters;

import java.util.Arrays;
import java.util.Random;

public class GameEvaluator implements IEvaluator{
    boolean areAllChecked = false;
    Random random = new Random();
    int numberOfGames = 10;
    boolean [] isChecked = new boolean[numberOfGames];

    @Override
    public int[] evaluate(IHeuristicsParameters[] heuristics){
        Arrays.fill(isChecked,false);
        int populationSize = heuristics.length;
        int[] evaluation = new int[populationSize];
        for (int i =0; i< populationSize;i++){
            GameThread [] gameThreads = new GameThread[numberOfGames];
            for (int j = 0; j< numberOfGames; j++){
                int opponent = random.nextInt(populationSize);
                while (opponent==i){
                    opponent = random.nextInt(populationSize);
                }
                gameThreads[j] = new GameThread();
                gameThreads[j].setGameThread(heuristics[i],
                        heuristics[opponent],
                        i,
                        opponent,
                        this,
                        j);
                gameThreads[j].start();
                System.out.println("Thread " + j + "started for heuristics " + i);
            }
            int alreadyChecked = 0;
            while (!areAllChecked) {
                synchronized (this){

                    for (int j = 0; j < numberOfGames; j++) {
                        if(isChecked[j]){
                            System.out.println("Game " + j + " already checked");
                        }
                        else {
                            GameThread gameThread = gameThreads[j];
                            if (gameThread.done){
                                if(gameThread.winner == AIsGameResult.FIRST){
                                    evaluation[gameThread.parametersIndex1]++;
                                } else if (gameThread.winner == AIsGameResult.SECOND) {
                                    evaluation[gameThread.parametersIndex2]++;
                                }
                                isChecked[j]=true;
                                alreadyChecked++;
                                System.out.println("Checked " + j + " thread for heuristics " + i);
                                System.out.println("Player " + gameThread.winner + " won.");
                            }
                            else{
                                try{
                                    wait(10000);
                                } catch (InterruptedException e) {

                                }
                            }
                        }
                    }
                    if(alreadyChecked>=numberOfGames){
                        areAllChecked = true;
                    }

                }
            }
            System.out.println("Games for heuristics " + i + " finished");
            for (int j = 0; j<numberOfGames; j++){
                isChecked[j] = false;
            }
            areAllChecked = false;
        }
        return evaluation;
    }
}
