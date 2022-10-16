package Game;

import Board.Board;
import Board.Color;
import Board.Coordinates;
import Minimax.IHeuristics;

import java.util.Random;

import static Minimax.Minimax.minimax;

public class AIsGame {
    IHeuristics firstHeuristics;
    IHeuristics secondHeuristics;
    Color firstColor;
    Color secondColor;
    Board board;
    boolean isGameOver = false;
    AIsGameResult winner = AIsGameResult.NONE;
    int depth;

    public AIsGame(IHeuristics firstHeuristics, IHeuristics secondHeuristics, int boardSize, int depth){
        this.firstHeuristics = firstHeuristics;
        this.secondHeuristics = secondHeuristics;
        this.board = new Board(boardSize);
        this.depth = depth;
        boolean isFirstBlack = new Random().nextBoolean();
        if(isFirstBlack){
            firstColor = Color.BLACK;
            secondColor = Color.WHITE;
        }
        else {
            firstColor = Color.WHITE;
            secondColor = Color.BLACK;
        }
    }

    public AIsGameResult run(){
        Color turn = Color.BLACK;
        while (!isGameOver){
            if(firstColor==turn){
                Coordinates c = minimax(board,firstColor,true,depth,firstHeuristics);
                if(c.x==-1){
                    return AIsGameResult.NONE;
                }
                board.makeMove(c,firstColor);
                if(board.makesFive(c,firstColor)){
                    winner = AIsGameResult.FIRST;
                    isGameOver = true;
                }
            }
            else {
                Coordinates c = minimax(board,secondColor,true,depth,secondHeuristics);
                if(c.x==-1){
                    return AIsGameResult.NONE;
                }
                board.makeMove(c,secondColor);
                if(board.makesFive(c,secondColor)){
                    winner = AIsGameResult.SECOND;
                    isGameOver = true;
                }
            }
            turn = turn.opposite();
            board.printBoard();
            System.out.println();
        }
        return winner;
    }

}
