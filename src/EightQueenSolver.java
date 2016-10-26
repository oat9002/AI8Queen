/**
 * Created by oat90 on 10/26/2016.
 */

public class EightQueenSolver {
    private static final int NUMBEROFQUEEN = 8;
    private static final int TABLESIZE = 8;
    private static final int MAXTIMES = 10;

    private Queen[] queenList = new Queen[NUMBEROFQUEEN];

    public EightQueenSolver() {
        fillArrayWithQueen();
    }

    public void fillArrayWithQueen(){
        for(int i = 0; i < queenList.length; i++) {
            while(true){
                int x = (int)(Math.random() * TABLESIZE);
                int y = (int)(Math.random() * TABLESIZE);
                if(!isQueen(x,y)){
                    queenList[i] = new Queen(x,y);
                    break;
                }
            }
        }
    }

    public boolean isQueen(int x, int y){
        for(Queen queen: queenList){
            if(queen != null && queen.getX() == x && queen.getY() == y){
                return true;
            }
        }
        return false;
    }

    public int computeProbabilityToMove(){

    }

    public int computeDeltaE(Queen selectedQueen, int newX, int newY){
        int tempX = selectedQueen.getX();
        int tempY = selectedQueen.getY();
        int oldNumberOfCollision = numberOfCollision();
        selectedQueen.setX(newX);
        selectedQueen.setY(newY);
        int newNumberOfCollision = numberOfCollision();
        selectedQueen.setX(tempX);
        selectedQueen.setY(tempY);
        return Math.abs(newNumberOfCollision - oldNumberOfCollision);
    }

    public int numberOfCollision() {
        int count = 0;
        for(int i = 0; i < queenList.length; i++) {
//            System.out.print(i+"-"+ queenList[i].getX()+","+ queenList[i].getY()+": ");
            for(int j = 0; j < queenList.length; j++) {
                if(i != j) {
                    if (queenList[i].getX() == queenList[j].getX()){
//                        System.out.print(queenList[j].getX()+",");
//                        System.out.print(queenList[j].getY()+" ");
                        count++;
                    }
                    else if (queenList[i].getY() == queenList[j].getY()){
//                        System.out.print(queenList[j].getX()+",");
//                        System.out.print(queenList[j].getY()+" ");
                        count++;
                    }
                    else if (Math.abs(queenList[i].getX() - queenList[j].getX()) == Math.abs(queenList[i].getY() - queenList[j].getY())){
//                        System.out.print(queenList[j].getX()+",");
//                        System.out.print(queenList[j].getY()+" ");
                        count++;
                    }
                }
            }
//            System.out.println();
        }
        return count;
    }

    public void randomMoveQueen(Queen queen){

    }









    public void printTable() {
        int table[][] = new int[TABLESIZE][TABLESIZE];
        for(Queen queen: queenList){
            table[queen.getY()][queen.getX()] = 1;
        }

        for(int i = 0;i < table.length;i++) {
            for(int j = 0; j < table.length;j++) {
                if(table[i][j] == 1)
                    System.out.print(" Q");
                else
                    System.out.print(" -");
            }
            System.out.println();
        }
    }
}
