package GeneticAlgorithm;

import Minimax.IHeuristics;

public interface IEvaluator {
    public int[] evaluate(IHeuristics [] heuristics);
}
