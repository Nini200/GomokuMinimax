package Board;

import Minimax.IHeuristics;

import java.util.ArrayList;

public class Board {
    private final Color[][] boardMatrix;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.boardMatrix = new Color[boardSize][boardSize];
        resetBoard();
    }

    public void makeMove(Coordinates c, Color color) {
        this.boardMatrix[c.x][c.y] = color;
    }

    public void makeMove(int i, int j, Color color){this.boardMatrix[i][j] = color;}

    public Color[][] getBoardMatrix() {
        return boardMatrix;
    }

    public int getBoardSize() {
        return boardSize;
    }

    private void resetBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.boardMatrix[i][j] = Color.BLANK;
            }
        }
    }

    public ArrayList<Coordinates> getPossibleMoves(){
        ArrayList<Coordinates> possibleMoves = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(this.boardMatrix[i][j] == Color.BLANK){
                    Coordinates c = new Coordinates(i, j);
                    possibleMoves.add(c);
                }
            }
        }
        return possibleMoves;
    }

    public void printBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("-----");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < boardSize; j++) {
                if(this.boardMatrix[i][j] == Color.BLANK){
                    System.out.print("    ");
                } else if (this.boardMatrix[i][j] == Color.BLACK) {
                    System.out.print(" \uD83D\uDDA4 ");
                }
                else {
                    System.out.print(" \uD83E\uDD0D ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void revertMove(Coordinates c) {
        this.boardMatrix[c.x][c.y] = Color.BLANK;
    }

    // ------------------------------------------- Common counting --------------------------------------//
    public int countHorizontalLine(int i, int j, Color color){
        int count = 1;
        while (j < boardSize) {
            if(j+1==boardSize||boardMatrix[i][j+1]!=color){
                j = boardSize;
            }
            else{
                count++;
                j++;
            }
        }
        return count;
    }
    public int countVerticalLine(int i, int j, Color color){
        int count = 1;
        while (i < boardSize) {
            if(i+1==boardSize||boardMatrix[i+1][j]!=color){
                i = boardSize;
            }
            else{
                count++;
                i++;
            }
        }
        return count;
    }
    public int countDiagonalLineDown(int i, int j, Color color){
        int count = 1;
        while (i < boardSize && j < boardSize) {
            if (j + 1 == boardSize || i + 1 == boardSize || boardMatrix[i+1][j+1] != color) {
                j = boardSize;
            } else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
    public int countDiagonalLineUp(int i, int j, Color color){
        int count = 1;
        while (i > -1 && j < boardSize){
            if (i - 1 == -1 || j + 1 == boardSize || boardMatrix[i - 1][j + 1] != color) {
                i = -1;
            }
            else {
                count++;
                i--;
                j++;
            }
        }
        return count;
    }

    // ------------------------------------------ Common Five-checks -----------------------------------//
    public boolean makesFiveHorizontally(Coordinates c, Color color){
        int i = c.x;
        int j = c.y;
        int lookBack = 0;
        while (j - lookBack > 0 && boardMatrix[i][j - lookBack - 1] == color) {
            lookBack++;
        }
        for (int jj = 1; jj < 5 - lookBack; jj++) {
            if (j + jj == boardSize || boardMatrix[i][j + jj] != color) {
                return false;
            }
        }
        return j + 5 - lookBack == boardSize || boardMatrix[i][j + 5 - lookBack] != color;
    }
    public boolean makesFiveVertically(Coordinates c, Color color) {
        int i = c.x;
        int j = c.y;
        int lookUp = 0;
        while (i - lookUp > 0 && boardMatrix[i - lookUp - 1][j] == color) {
            lookUp++;
        }
        for (int ii = 1; ii < 5 - lookUp; ii++) {
            if (i + ii == boardSize || boardMatrix[i + ii][j] != color) {
                return false;
            }
        }
        return i + 5 - lookUp == boardSize || boardMatrix[i + 5 - lookUp][j] != color;
    }
    public boolean makesFiveDiagonallyUp(Coordinates c, Color color) {
        int i = c.x;
        int j = c.y;
        int lookLeftDown = 0;
        while (i + lookLeftDown < boardSize - 1 && j - lookLeftDown > 0 && boardMatrix[i + lookLeftDown + 1][j - lookLeftDown - 1] == color) {
            lookLeftDown++;
        }
        for (int ij = 1; ij < 5 - lookLeftDown; ij++) {
            if (i - ij == -1 || j + ij == boardSize || boardMatrix[i - ij][j + ij] != color) {
                return false;
            }
        }
        return i - 5 + lookLeftDown == -1 || j + 5 - lookLeftDown == boardSize || boardMatrix[i - 5 + lookLeftDown][j + 5 - lookLeftDown] != color;
    }
    public boolean makesFiveDiagonallyDown(Coordinates c, Color color) {
        int i = c.x;
        int j = c.y;
        int lookLeftUp = 0;
        while (i - lookLeftUp > 0 && j - lookLeftUp > 0 && boardMatrix[i - lookLeftUp - 1][j - lookLeftUp - 1] == color) {
            lookLeftUp++;
        }
        for (int ij = 1; ij < 5 - lookLeftUp; ij++) {
            if (i + ij == boardSize || j + ij == boardSize || boardMatrix[i + ij][j + ij] != color) {
                return false;
            }
        }
        return i + 5 - lookLeftUp == boardSize || j + 5 - lookLeftUp == boardSize || boardMatrix[i + 5 - lookLeftUp][j + 5 - lookLeftUp] != color;
    }
    public boolean makesFive(Coordinates c, Color color) {
        return makesFiveHorizontally(c, color)
                || makesFiveVertically(c, color)
                || makesFiveDiagonallyUp(c, color)
                || makesFiveDiagonallyDown(c, color);
    }
    public boolean makesFive(int i, int j, Color color){
        Coordinates c = new Coordinates(i, j);
        return makesFive(c, color);
    }

    // ------------------------------------------ Simple Consecutive Stone Counting --------------------//
    public void countHorizontally(ConsecutiveStones cs, Color color){
        int i = 0;
        int j = 0;
        while(i<boardSize){
            while (j<boardSize){
                if(boardMatrix[i][j]==color) {
                    int openEnds = 2;
                    // TODO: Check that :)
                    if (j == 0 || boardMatrix[i][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countHorizontalLine(i, j, color);
                    j += stones;
                    if (j >= boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                }
                else {
                    j++;
                }
            }
            j=0;
            i++;
        }
    }
    public void countVertically(ConsecutiveStones cs, Color color){
        int i = 0;
        int j = 0;
        while (j<boardSize){
            while (i<boardSize){
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (i == 0 || boardMatrix[i - 1][j] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countVerticalLine(i, j, color);
                    i += stones;
                    if (i >= boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones,openEnds);
                }
                else {
                    i++;
                }
            }
            i = 0;
            j++;
        }

    }
    public void countDiagonallyDown(ConsecutiveStones cs, Color color) {
        for (int ii = boardSize - 1; ii > 0; ii--) {
            int i = ii;
            int j = 0;
            while (i < boardSize) {
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (j == 0 || boardMatrix[i - 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineDown(i, j, color);
                    i += stones;
                    j += stones;
                    if (i == boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                } else {
                    i++;
                    j++;
                }
            }
        }
        for (int jj = 0; jj < boardSize; jj++) {
            int i = 0;
            int j = jj;
            while (j<boardSize){
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (i == 0 || boardMatrix[i - 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineDown(i, j, color);
                    i += stones;
                    j += stones;
                    if (j == boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                } else {
                    i++;
                    j++;
                }
            }

        }
    }
    public void countDiagonallyUp(ConsecutiveStones cs, Color color) {
        for (int ii = 0; ii < boardSize; ii++) {
            int i = ii;
            int j = 0;
            while (i > 0) {
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (j == 0 || boardMatrix[i + 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineUp(i, j, color);
                    i -= stones;
                    j += stones;
                    if (i == -1 || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                } else {
                    i--;
                    j++;
                }
            }
        }
        for (int jj = 1; jj < boardSize; jj++) {
            int i = boardSize - 1;
            int j = jj;
            while (j < boardSize) {
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (i == boardSize - 1 || boardMatrix[i + 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineUp(i, j, color);
                    i -= stones;
                    j += stones;
                    if (j == boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addConsecutiveStones(stones, openEnds);
                } else {
                    i--;
                    j++;
                }
            }

        }
    }
    public void countAll(ConsecutiveStones cs, Color color){
        countHorizontally(cs, color);
        countVertically(cs, color);
        countDiagonallyDown(cs, color);
        countDiagonallyUp(cs, color);
    }
    public int evaluate(IHeuristics heuristics, Color color, boolean isMax){
        ConsecutiveStones playersCs = new ConsecutiveStones();
        ConsecutiveStones opponentsCs = new ConsecutiveStones();
        countAll(playersCs, color);
        countAll(opponentsCs, color.opposite());
        int evaluation = heuristics.evaluate(playersCs, opponentsCs);
        if(isMax){
            return evaluation;
        }
        return -evaluation;
    }

    // ------------------------------------------ Advanced Consecutive Stone Counting -----------------//

    public void countHorizontallyAdvanced(ConsecutiveAdvStones cs, Color color){
        int i = 0;
        int j = 0;
        while(i<boardSize){
            while (j<boardSize){
                if(boardMatrix[i][j]==color) {
                    int openEnds = 2;
                    if (j == 0 || boardMatrix[i][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countHorizontalLine(i, j, color);
                    AdvancedStoneShapes shape = AdvancedStoneShapes.NotAdvanced;
                    int increaseJ = 5; // default if we got any od advancedShapes
                    // checking for special shapes
                    if (stones == 3) // O_XXX_O or XXX_X
                    {
                        // O_XXX_O
                        if (j - 2 >= 0
                                && j + 4 < boardSize
                                && boardMatrix[i][j - 2] == color.opposite()
                                && boardMatrix[i][j - 1] == Color.BLANK
                                && boardMatrix[i][j + 3] == Color.BLANK
                                && boardMatrix[i][j + 4] == color.opposite()) {
                            shape = AdvancedStoneShapes.Three2OpenMax5;
                        }
                        // XXX_X
                        else if (j + 4 < boardSize
                                && boardMatrix[i][j + 3] == Color.BLANK
                                && boardMatrix[i][j + 4] == color) {

                            shape = AdvancedStoneShapes.FourHoleAfter3;
                        }
                    }
                    if (stones == 2) // (XX_XX or XX__X) or (_XX_X_ or _XX_XO or OXX_X_)
                    {
                        // (XX_XX or XX__X)
                        if (j + 4 < boardSize
                                && boardMatrix[i][j + 2] == Color.BLANK
                                && boardMatrix[i][j + 4] == color) {
                            if(boardMatrix[i][j + 3] == color){
                                shape = AdvancedStoneShapes.FourHoleAfter2;
                            } else if (boardMatrix[i][j + 3] == Color.BLANK) {
                                shape = AdvancedStoneShapes.ThreeHoles2InRow;
                            }
                        }
                        // (_XX_X_ or _XX_XO or OXX_X_)
                        if (j + 3 < boardSize
                                && boardMatrix[i][j + 2] == Color.BLANK
                                && boardMatrix[i][j + 3] == color) {
                            if (openEnds == 2) {
                                if (j + 4 >= boardSize
                                        || boardMatrix[i][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                } else if (j + 4 < boardSize
                                        && boardMatrix[i][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            }
                            else if (openEnds == 1
                                        && j+4 < boardSize
                                        && boardMatrix[i][j+4] == Color.BLANK){
                                shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                            }
                        }
                    }
                    if(stones == 1){
                        // X_XXX or X__XX or X_X_X or X___X
                        if (j + 4 < boardSize
                                && boardMatrix[i][j + 4] == color
                                && boardMatrix[i][j + 1] == Color.BLANK) {
                            if (boardMatrix[i][j + 3] == color) {
                                if (boardMatrix[i][j + 2] == color) {
                                    shape = AdvancedStoneShapes.FourHoleAfter3;
                                }
                                else if (boardMatrix[i][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoles2InRow;
                                }
                            }
                            else if (boardMatrix[i][j + 3] == Color.BLANK){
                                if (boardMatrix[i][j + 2] == color) {
                                    shape = AdvancedStoneShapes.ThreeHoles2Separated;
                                }
                                else if (boardMatrix[i][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn5;
                                }
                            }
                        }
                        // _X_XX_ or _X_XXO or OX_XX_
                        else if (j + 3 < boardSize
                                && boardMatrix[i][j + 1] == Color.BLANK
                                && boardMatrix[i][j + 2] == color
                                && boardMatrix[i][j + 3] == color) {
                            if (openEnds == 2) {
                                if (j + 4 >= boardSize
                                        || boardMatrix[i][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                                } else if (j + 4 < boardSize
                                        && boardMatrix[i][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            } else if (openEnds == 1) {
                                if (j + 4 < boardSize
                                        && boardMatrix[i][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                }
                            }
                        }
                        else if (j + 3 < boardSize
                                && boardMatrix[i][j + 1] == Color.BLANK
                                && boardMatrix[i][j + 2] == Color.BLANK
                                && boardMatrix[i][j + 3] == color) {
                            if (openEnds == 2) {
                                if (j + 4 >= boardSize
                                        || boardMatrix[i][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                } else if (j + 4 < boardSize
                                        && boardMatrix[i][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open2;
                                }
                            } else if (openEnds == 1) {
                                if (j + 4 < boardSize
                                        && boardMatrix[i][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                }
                            }
                        } else if (j + 2 < boardSize
                                && boardMatrix[i][j + 1] == Color.BLANK
                                && boardMatrix[i][j + 2] == color) {
                            if (openEnds == 2) {
                                if (j + 3 >= boardSize
                                        || boardMatrix[i][j + 3] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseJ = 4;
                                } else if (j + 3 < boardSize
                                        && boardMatrix[i][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open2;
                                    increaseJ = 4;
                                }
                            } else if (openEnds == 1) {
                                if (j + 3 < boardSize
                                        && boardMatrix[i][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseJ = 4;
                                }
                            }
                        }
                    }

                    if (shape == AdvancedStoneShapes.NotAdvanced) {
                        j += stones;
                    }
                    else {
                        j += increaseJ;
                    }

                    if (j >= boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addAdvancedConsecutiveStones(stones, openEnds, shape);
                }
                else {
                    j++;
                }
            }
            j=0;
            i++;
        }
    }
    public void countVerticallyAdvanced(ConsecutiveAdvStones cs, Color color){
        int i = 0;
        int j = 0;
        while (j<boardSize){
            while (i<boardSize){
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (i == 0 || boardMatrix[i - 1][j] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countVerticalLine(i, j, color);

                    AdvancedStoneShapes shape = AdvancedStoneShapes.NotAdvanced;
                    int increaseI = 5; // default if we got any od advancedShapes
                    // checking for special shapes
                    if (stones == 3) // O_XXX_O or XXX_X
                    {
                        // O_XXX_O
                        if (i - 2 >= 0
                                && i + 4 < boardSize
                                && boardMatrix[i - 2][j] == color.opposite()
                                && boardMatrix[i - 1][j] == Color.BLANK
                                && boardMatrix[i + 3][j] == Color.BLANK
                                && boardMatrix[i + 4][j] == color.opposite()) {
                            shape = AdvancedStoneShapes.Three2OpenMax5;
                        }
                        // XXX_X
                        else if (i + 4 < boardSize
                                && boardMatrix[i+3][j] == Color.BLANK
                                && boardMatrix[i+4][j] == color) {
                            shape = AdvancedStoneShapes.FourHoleAfter3;
                        }
                    }
                    if (stones == 2) // (XX_XX or XX__X) or (_XX_X_ or _XX_XO or OXX_X_)
                    {
                        // (XX_XX or XX__X)
                        if (i + 4 < boardSize
                                && boardMatrix[i + 2][j] == Color.BLANK
                                && boardMatrix[i + 4][j] == color) {
                            if(boardMatrix[i + 3][j] == color){
                                shape = AdvancedStoneShapes.FourHoleAfter2;
                            } else if (boardMatrix[i + 3][j] == Color.BLANK) {
                                shape = AdvancedStoneShapes.ThreeHoles2InRow;
                            }
                        }
                        // (_XX_X_ or _XX_XO or OXX_X_)
                        if (i + 3 < boardSize
                                && boardMatrix[i + 2][j] == Color.BLANK
                                && boardMatrix[i + 3][j] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize
                                        || boardMatrix[i + 4][j] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                } else if (i + 4 < boardSize
                                        && boardMatrix[i + 4][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            }
                            else if (openEnds == 1
                                    && i+4 < boardSize
                                    && boardMatrix[i+ 4][j] == Color.BLANK){
                                shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                            }
                        }
                    }
                    if(stones == 1){
                        // X_XXX or X__XX or X_X_X or X___X
                        if (i + 4 < boardSize
                                && boardMatrix[i + 4][j] == color
                                && boardMatrix[i + 1][j] == Color.BLANK) {
                            if (boardMatrix[i + 3][j] == color) {
                                if (boardMatrix[i + 2][j] == color) {
                                    shape = AdvancedStoneShapes.FourHoleAfter3;
                                }
                                else if (boardMatrix[i + 2][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoles2InRow;
                                }
                            }
                            else if (boardMatrix[i + 3][j] == Color.BLANK){
                                if (boardMatrix[i + 2][j] == color) {
                                    shape = AdvancedStoneShapes.ThreeHoles2Separated;
                                }
                                else if (boardMatrix[i + 2][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn5;
                                }
                            }
                        }
                        // _X_XX_ or _X_XXO or OX_XX_
                        else if (i + 3 < boardSize
                                && boardMatrix[i + 1][j] == Color.BLANK
                                && boardMatrix[i + 2][j] == color
                                && boardMatrix[i + 3][j] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize
                                        || boardMatrix[i + 4][j] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                                } else if (i + 4 < boardSize
                                        && boardMatrix[i + 4][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize
                                        && boardMatrix[i + 4][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                }
                            }
                        }
                        else if (i + 3 < boardSize
                                && boardMatrix[i + 1][j] == Color.BLANK
                                && boardMatrix[i + 2][j] == Color.BLANK
                                && boardMatrix[i + 3][j] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize
                                        || boardMatrix[i + 4][j] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                } else if (i + 4 < boardSize
                                        && boardMatrix[i + 4][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize
                                        && boardMatrix[i + 4][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                }
                            }
                        } else if (i + 2 < boardSize
                                && boardMatrix[i + 1][j] == Color.BLANK
                                && boardMatrix[i + 2][j] == color) {
                            if (openEnds == 2) {
                                if (i + 3 >= boardSize
                                        || boardMatrix[i + 3][j] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseI = 4;
                                } else if (i + 3 < boardSize
                                        && boardMatrix[i + 3][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open2;
                                    increaseI = 4;
                                }
                            } else if (openEnds == 1) {
                                if (i + 3 < boardSize
                                        && boardMatrix[i + 3][j] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseI = 4;
                                }
                            }
                        }
                    }

                    if (shape == AdvancedStoneShapes.NotAdvanced) {
                        i += stones;
                    }
                    else {
                        i += increaseI;
                    }

                    if (i >= boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addAdvancedConsecutiveStones(stones, openEnds, shape);
                }
                else {
                    i++;
                }
            }
            i = 0;
            j++;
        }

    }
    public void countDiagonallyDownAdvanced(ConsecutiveAdvStones cs, Color color) {
        // Below diagonal
        for (int ii = boardSize - 1; ii > 0; ii--) {
            int i = ii;
            int j = 0;
            while (i < boardSize) {
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (j == 0 || boardMatrix[i - 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineDown(i, j, color);

                    AdvancedStoneShapes shape = AdvancedStoneShapes.NotAdvanced;
                    int increaseIJ = 5; // default if we got any od advancedShapes
                    // checking for special shapes
                    if (stones == 3) // O_XXX_O or XXX_X
                    {
                        // O_XXX_O
                        if (i - 2 >= 0 && j - 2 >=0
                                && i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i - 2][j - 2] == color.opposite()
                                && boardMatrix[i - 1][j - 1] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == Color.BLANK
                                && boardMatrix[i + 4][j + 4] == color.opposite()) {
                            shape = AdvancedStoneShapes.Three2OpenMax5;
                        }
                        // XXX_X
                        else if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i+3][j+3] == Color.BLANK
                                && boardMatrix[i+4][j+4] == color) {
                            shape = AdvancedStoneShapes.FourHoleAfter3;
                        }
                    }
                    if (stones == 2) // (XX_XX or XX__X) or (_XX_X_ or _XX_XO or OXX_X_)
                    {
                        // (XX_XX or XX__X)
                        if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 4][j + 4] == color) {
                            if(boardMatrix[i + 3][j +3] == color){
                                shape = AdvancedStoneShapes.FourHoleAfter2;
                            } else if (boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                shape = AdvancedStoneShapes.ThreeHoles2InRow;
                            }
                        }
                        // (_XX_X_ or _XX_XO or OXX_X_)
                        if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            }
                            else if (openEnds == 1
                                    && i+4 < boardSize && j+4 < boardSize
                                    && boardMatrix[i+ 4][j + 4] == Color.BLANK){
                                shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                            }
                        }
                    }
                    if(stones == 1){
                        // X_XXX or X__XX or X_X_X or X___X
                        if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i + 4][j + 4] == color
                                && boardMatrix[i + 1][j + 1] == Color.BLANK) {
                            if (boardMatrix[i + 3][j + 3] == color) {
                                if (boardMatrix[i + 2][j + 2] == color) {
                                    shape = AdvancedStoneShapes.FourHoleAfter3;
                                }
                                else if (boardMatrix[i + 2][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoles2InRow;
                                }
                            }
                            else if (boardMatrix[i + 3][j + 3] == Color.BLANK){
                                if (boardMatrix[i + 2][j + 2] == color) {
                                    shape = AdvancedStoneShapes.ThreeHoles2Separated;
                                }
                                else if (boardMatrix[i + 2][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn5;
                                }
                            }
                        }
                        // _X_XX_ or _X_XXO or OX_XX_
                        else if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == color
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                }
                            }
                        }
                        else if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize  && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                }
                            }
                        } else if (i + 2 < boardSize && j + 2 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == color) {
                            if (openEnds == 2) {
                                if (i + 3 >= boardSize || j + 3 >= boardSize
                                        || boardMatrix[i + 3][j + 3] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseIJ = 4;
                                } else if (i + 3 < boardSize && j + 3 < boardSize
                                        && boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open2;
                                    increaseIJ = 4;
                                }
                            } else if (openEnds == 1) {
                                if (i + 3 < boardSize && j + 3 < boardSize
                                        && boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseIJ = 4;
                                }
                            }
                        }
                    }

                    if (shape == AdvancedStoneShapes.NotAdvanced) {
                        i += stones;
                        j += stones;
                    }
                    else {
                        i += increaseIJ;
                        j += increaseIJ;
                    }

                    if (i == boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addAdvancedConsecutiveStones(stones, openEnds, shape);
                } else {
                    i++;
                    j++;
                }
            }
        }
        // Diagonal and above
        for (int jj = 0; jj < boardSize; jj++) {
            int i = 0;
            int j = jj;
            while (j<boardSize){
                if (boardMatrix[i][j] == color) {
                    int openEnds = 2;
                    if (i == 0 || boardMatrix[i - 1][j - 1] != Color.BLANK) {
                        openEnds--;
                    }
                    int stones = countDiagonalLineDown(i, j, color);

                    AdvancedStoneShapes shape = AdvancedStoneShapes.NotAdvanced;
                    int increaseIJ = 5; // default if we got any od advancedShapes
                    // checking for special shapes
                    if (stones == 3) // O_XXX_O or XXX_X
                    {
                        // O_XXX_O
                        if (i - 2 >= 0 && j - 2 >=0
                                && i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i - 2][j - 2] == color.opposite()
                                && boardMatrix[i - 1][j - 1] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == Color.BLANK
                                && boardMatrix[i + 4][j + 4] == color.opposite()) {
                            shape = AdvancedStoneShapes.Three2OpenMax5;
                        }
                        // XXX_X
                        else if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i+3][j+3] == Color.BLANK
                                && boardMatrix[i+4][j+4] == color) {
                            shape = AdvancedStoneShapes.FourHoleAfter3;
                        }
                    }
                    if (stones == 2) // (XX_XX or XX__X) or (_XX_X_ or _XX_XO or OXX_X_)
                    {
                        // (XX_XX or XX__X)
                        if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 4][j + 4] == color) {
                            if(boardMatrix[i + 3][j +3] == color){
                                shape = AdvancedStoneShapes.FourHoleAfter2;
                            } else if (boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                shape = AdvancedStoneShapes.ThreeHoles2InRow;
                            }
                        }
                        // (_XX_X_ or _XX_XO or OXX_X_)
                        if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            }
                            else if (openEnds == 1
                                    && i+4 < boardSize && j+4 < boardSize
                                    && boardMatrix[i+ 4][j + 4] == Color.BLANK){
                                shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                            }
                        }
                    }
                    if(stones == 1){
                        // X_XXX or X__XX or X_X_X or X___X
                        if (i + 4 < boardSize && j + 4 < boardSize
                                && boardMatrix[i + 4][j + 4] == color
                                && boardMatrix[i + 1][j + 1] == Color.BLANK) {
                            if (boardMatrix[i + 3][j + 3] == color) {
                                if (boardMatrix[i + 2][j + 2] == color) {
                                    shape = AdvancedStoneShapes.FourHoleAfter3;
                                }
                                else if (boardMatrix[i + 2][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoles2InRow;
                                }
                            }
                            else if (boardMatrix[i + 3][j + 3] == Color.BLANK){
                                if (boardMatrix[i + 2][j + 2] == color) {
                                    shape = AdvancedStoneShapes.ThreeHoles2Separated;
                                }
                                else if (boardMatrix[i + 2][j + 2] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn5;
                                }
                            }
                        }
                        // _X_XX_ or _X_XXO or OX_XX_
                        else if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == color
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked2;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.ThreeHoleAfter2Blocked1;
                                }
                            }
                        }
                        else if (i + 3 < boardSize && j + 3 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == Color.BLANK
                                && boardMatrix[i + 3][j + 3] == color) {
                            if (openEnds == 2) {
                                if (i + 4 >= boardSize || j + 4 >= boardSize
                                        || boardMatrix[i + 4][j + 4] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                } else if (i + 4 < boardSize && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open2;
                                }
                            } else if (openEnds == 1) {
                                if (i + 4 < boardSize  && j + 4 < boardSize
                                        && boardMatrix[i + 4][j + 4] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn4Open1;
                                }
                            }
                        } else if (i + 2 < boardSize && j + 2 < boardSize
                                && boardMatrix[i + 1][j + 1] == Color.BLANK
                                && boardMatrix[i + 2][j + 2] == color) {
                            if (openEnds == 2) {
                                if (i + 3 >= boardSize || j + 3 >= boardSize
                                        || boardMatrix[i + 3][j + 3] == color.opposite()) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseIJ = 4;
                                } else if (i + 3 < boardSize && j + 3 < boardSize
                                        && boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open2;
                                    increaseIJ = 4;
                                }
                            } else if (openEnds == 1) {
                                if (i + 3 < boardSize && j + 3 < boardSize
                                        && boardMatrix[i + 3][j + 3] == Color.BLANK) {
                                    shape = AdvancedStoneShapes.TwoOn3Open1;
                                    increaseIJ = 4;
                                }
                            }
                        }
                    }

                    if (shape == AdvancedStoneShapes.NotAdvanced) {
                        i += stones;
                        j += stones;
                    }
                    else {
                        i += increaseIJ;
                        j += increaseIJ;
                    }


                    if (j == boardSize || boardMatrix[i][j] != Color.BLANK) {
                        openEnds--;
                    }
                    cs.addAdvancedConsecutiveStones(stones, openEnds, shape);
                } else {
                    i++;
                    j++;
                }
            }

        }
    }
}
