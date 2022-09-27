package Minimax;

import Board.Coordinates;

public class MinimaxResult {
    private int score;
    private Coordinates coordinates;

    public MinimaxResult(int score, Coordinates c){
        this.score = score;
        this.coordinates = c;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getScore() {
        return score;
    }
}
