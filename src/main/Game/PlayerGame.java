package Game;

import Board.Board;
import Board.Color;
import Board.Coordinates;
import Minimax.IHeuristics;

import java.util.Scanner;

import static Minimax.Minimax.minimax;

public class PlayerGame {
    IHeuristics heuristics;
    Board board;
    Scanner in;
    boolean isGameOver = false;
    Color winner = Color.BLANK;

    public PlayerGame(IHeuristics heuristics, int boardSize){
        this.heuristics = heuristics;
        this.board = new Board(boardSize);
        this.in = new Scanner(System.in);
    }

    private Color getPlayersColor(){
        System.out.println("Choose color: (B/W)");
        char choice = in.next().toLowerCase().charAt(0);
        if(choice == 'b'){
            return Color.BLACK;
        } else if (choice == 'w') {
            return Color.WHITE;
        }
        return Color.BLANK;
    }

    public void run(){
        Color playersColor = getPlayersColor();

        if (playersColor == Color.BLANK) {
            System.out.println("Wrong color.");
            return;
        }

        Color aiColor = playersColor.opposite();
        System.out.println("Player: " + playersColor);
        System.out.println("Ejaj: " + aiColor.toString());

        if (playersColor == Color.WHITE) {
            int centrePoint = (board.getBoardSize() - 1) / 2;
            board.makeMove(new Coordinates(centrePoint,centrePoint), aiColor);
            board.printBoard();
        }

        while (!isGameOver){
            System.out.println("Players' move: ");
            int i = in.nextInt();
            int j = in.nextInt();
            board.makeMove(i,j,playersColor);
            board.printBoard();

            if(board.makesFive(i, j, playersColor)){
                winner = playersColor;
                isGameOver = true;
            }
            else{
                Coordinates c = minimax(board, aiColor, true, 3, heuristics, Integer.MIN_VALUE, Integer.MAX_VALUE);
                board.makeMove(c, aiColor);
                if(board.makesFive(c, aiColor)){
                    winner = aiColor;
                    isGameOver = true;
                }
                board.printBoard();
            }
            System.out.println();
        }
        System.out.println("Winner: " + winner.toString());

    }
}
