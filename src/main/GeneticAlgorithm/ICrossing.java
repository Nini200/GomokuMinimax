package GeneticAlgorithm;

import Minimax.HeuristicsParameters;

public interface ICrossing {
    HeuristicsParameters cross(HeuristicsParameters parameters1, HeuristicsParameters parameters2);
}
