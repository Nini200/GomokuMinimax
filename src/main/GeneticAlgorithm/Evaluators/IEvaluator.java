package GeneticAlgorithm.Evaluators;

import Minimax.IHeuristicsParameters;

public interface IEvaluator {
    int[] evaluate(IHeuristicsParameters[] heuristics);

}
