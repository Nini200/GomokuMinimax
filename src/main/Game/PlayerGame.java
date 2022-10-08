package Game;

import Board.Board;
import Board.Stone;
import Board.Coordinates;
import Minimax.IHeuristics;

import java.util.Scanner;

import static Minimax.Minimax.minimax;

public class PlayerGame {
    IHeuristics heuristics;
    Board board;
    Scanner in;
    boolean isGameOver = false;
    Stone winner = Stone.BLANK;

    public PlayerGame(IHeuristics heuristics, int boardSize){
        this.heuristics = heuristics;
        this.board = new Board(boardSize);
        this.in = new Scanner(System.in);
    }

    private Stone getPlayersColor(){
        System.out.println("Choose color: (B/W)");
        char choice = in.next().toLowerCase().charAt(0);
        if(choice == 'b'){
            return Stone.BLACK;
        } else if (choice == 'w') {
            return Stone.WHITE;
        }
        return Stone.BLANK;
    }

    public void run(){
        Stone playersColor = getPlayersColor();

        if (playersColor == Stone.BLANK) {
            System.out.println("Wrong color.");
            return;
        }

        Stone aiColor = playersColor.opposite();
        System.out.println("Player: " + playersColor);
        System.out.println("Ejaj: " + aiColor.toString());

        if (playersColor == Stone.WHITE) {
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
                Coordinates c = minimax(board, aiColor, true, 3, heuristics);
                board.makeMove(c, aiColor);
                if(board.makesFive(c, aiColor)){
                    winner = aiColor;
                    isGameOver = true;
                }
                board.printBoard();
            }
            System.out.println("Winner: " + winner.toString());
        }


    }
}
