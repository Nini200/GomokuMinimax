package GeneticAlgorithm;

import Minimax.AdvancedHeuristicsParameters;
import Minimax.HeuristicsParameters;
import Minimax.IHeuristicsParameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PopulationFromFile {
    int iterationsDone = 0;
    IHeuristicsParameters[] population = new IHeuristicsParameters[0];
    String file;
    boolean isAdvancedHeuristic;

    public PopulationFromFile(String file, boolean isAdvancedHeuristic){
        this.file = file;
        this.isAdvancedHeuristic = isAdvancedHeuristic;
    }

    public void readFromFileWithIterations(){
        File fileObject = new File(this.file);
        try {
            Scanner fileReader = new Scanner(fileObject);
            if(fileReader.hasNextLine()){
                iterationsDone = Integer.parseInt(fileReader.nextLine());
            }
            ArrayList<Integer> integers = new ArrayList<>();
            while (fileReader.hasNextLine()) {
                integers.add(Integer.parseInt(fileReader.nextLine()));
            }
            Integer[] integers1 = new Integer[integers.size()];
            integers1 = integers.toArray(integers1);
            int[] ints = new int[integers1.length];
            for (int i = 0; i < integers1.length; i++) {
                ints[i] = integers1[i];
            }
            if (isAdvancedHeuristic) {
                population = AdvancedHeuristicsParameters.getPopulationFromArray(ints);
            } else {
                population = HeuristicsParameters.getPopulationFromArray(ints);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + "not found");

        }

    }

    public int getIterationsDone() {
        return iterationsDone;
    }


    public IHeuristicsParameters[] getPopulation() {
        return population;
    }
}
