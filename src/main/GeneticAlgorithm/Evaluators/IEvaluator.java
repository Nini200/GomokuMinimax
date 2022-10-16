package GeneticAlgorithm.Evaluators;

import Minimax.HeuristicsParameters;

public interface IEvaluator {
    int[] evaluate(HeuristicsParameters[] heuristics);
}
