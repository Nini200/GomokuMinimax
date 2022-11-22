package GeneticAlgorithm.Crossings;

import Minimax.IHeuristicsParameters;

public interface ICrossing {
    IHeuristicsParameters cross(IHeuristicsParameters parameters1, IHeuristicsParameters parameters2);
}
