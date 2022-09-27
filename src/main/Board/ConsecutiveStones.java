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

    public void addConsecutiveStones(int length, int openEnds){
        switch (length) {
            case 5:
                fives++;
            case 4:
                switch (openEnds){
                    case 1:
                        foursOneEdge++;
                    case 2:
                        foursTwoEdges++;
                }
            case 3:
                switch (openEnds) {
                    case 1:
                        threesOneEdge++;
                    case 2:
                        threesTwoEdges++;
                }
        }
    }



}
