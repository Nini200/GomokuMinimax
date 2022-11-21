package Board;

public class ConsecutiveAdvStones extends ConsecutiveStones{

    private int fourHoleAfter3;
    private int fourHoleAfter2;
    private int threeHoleAfter2Open2;
    private int threeHoleAfter2Blocked1; // _OO__OX
    private int threeHoleAfter2Blocked2; // XOO__O_
    private int threeHoles2InRow; // OO__O
    private int threeHoles2Separated; //O_O_O
    private int three2OpenMax5; // X_OOO_X
    private int twoOn5; // O___O
    private int twoOn4Open2; //_O__O_
    private int twoOn4Open1; //XO__O_
    private int twoOn3Open2; //_O_O_
    private int twoOn3Open1; //XO_O_

    public ConsecutiveAdvStones(){
        threesOneEdge=threesTwoEdges=foursOneEdge=foursTwoEdges=fives=0;
    }

    public ConsecutiveAdvStones(int twosOneEdge, int twosTwoEdges, int threesOneEdge, int threesTwoEdges, int foursOneEdge, int foursTwoEdges, int fives){
        this.twosOneEdge = twosOneEdge;
        this.twosTwoEdges = twosTwoEdges;
        this.threesOneEdge = threesOneEdge;
        this.threesTwoEdges = threesTwoEdges;
        this.foursOneEdge = foursOneEdge;
        this.foursTwoEdges = foursTwoEdges;
        this.fives = fives;
    }


    public void addAdvancedConsecutiveStones(int stones, int openEnds, AdvancedStoneShapes shape) {
        switch (shape) {
            case NotAdvanced -> addConsecutiveStones(stones, openEnds);
            case FourHoleAfter3 -> this.fourHoleAfter3++;
            case FourHoleAfter2 -> this.fourHoleAfter2++;
            case ThreeHoleAfter2Open2 -> this.threeHoleAfter2Open2++;
            case ThreeHoleAfter2Blocked1 -> this.threeHoleAfter2Blocked1++;
            case ThreeHoleAfter2Blocked2 -> this.threeHoleAfter2Blocked2++;
            case ThreeHoles2InRow ->  this.threeHoles2InRow++;
            case ThreeHoles2Separated -> this.threeHoles2Separated++;
            case Three2OpenMax5 -> this.three2OpenMax5++;
            case TwoOn5 -> this.twoOn5++;
            case TwoOn4Open2 -> this.twoOn4Open2++;
            case TwoOn4Open1 -> this.twoOn4Open1++;
            case TwoOn3Open2 -> this. twoOn3Open2++;
            case TwoOn3Open1 -> this. twoOn3Open1++;
        }
    }
}
