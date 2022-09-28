package Board;

public class ConsecutiveStones {
    private int threesOneEdge;
    private int threesTwoEdges;
    private int foursOneEdge;
    private int foursTwoEdges;
    private int fives;

    public ConsecutiveStones(){
        threesOneEdge=threesTwoEdges=foursOneEdge=foursTwoEdges=fives=0;
    }

    public ConsecutiveStones(int threesOneEdge, int threesTwoEdges, int foursOneEdge, int foursTwoEdges, int fives){
        this.threesOneEdge = threesOneEdge;
        this.threesTwoEdges = threesTwoEdges;
        this.foursOneEdge = foursOneEdge;
        this.foursTwoEdges = foursTwoEdges;
        this.fives = fives;
    }

    public void addConsecutiveStones(int length, int openEnds){
        switch (length) {
            case 5:
                fives++;
                break;
            case 4:
                switch (openEnds) {
                    case 1 -> foursOneEdge++;
                    case 2 -> foursTwoEdges++;
                }
                break;
            case 3:
                switch (openEnds) {
                    case 1 -> threesOneEdge++;
                    case 2 -> threesTwoEdges++;
                }
                break;
        }
    }


    public int getThreesOneEdge() {
        return threesOneEdge;
    }

    public int getThreesTwoEdges() {
        return threesTwoEdges;
    }

    public int getFoursOneEdge() {
        return foursOneEdge;
    }

    public int getFoursTwoEdges() {
        return foursTwoEdges;
    }

    public int getFives() {
        return fives;
    }
}
