/**
 * Created by oat90 on 10/26/2016.
 */

public class EightQueenSolver {
    private static final int NUMBEROFQUEEN = 8;
    private static final int TABLESIZE = 8;
    private static final int MAXTIMES = 500;

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

    public void simulatedAnnealing(){
        for(int t = 1, temperature = MAXTIMES;  t <= MAXTIMES;  t++, temperature--){
            if(temperature == 0){
                printTable();
                return;
            }
            Queen selectedQueen = selectRandomQueen();
            int newX;
            int newY;
            while(true){
                newX = (int)(Math.random()*TABLESIZE);
                newY = (int)(Math.random()*TABLESIZE);
                if(!isQueen(newX,newY)){
                    break;
                }
            }
            int deltaE = computeDeltaE(selectedQueen, newX, newY);
            if(deltaE < 0){
                moveQueen(selectedQueen,newX,newY);
            }
            else{
                if(shouldQueenMove(deltaE,temperature)){
                    moveQueen(selectedQueen,newX,newY);
                }
            }
            if(t % 1000 == 0) {
                printTable();
                System.out.println(numberOfCollision());
                System.out.println("+++++++++++++++++++");
            }
        }
    }

    public void moveQueen(Queen queen,int x,int y){
        queen.setX(x);
        queen.setY(y);
    }

    public Queen selectRandomQueen(){
        return queenList[(int)(Math.random()*8)];
    }

    public boolean shouldQueenMove(int deltaE, int temperature){
        if(Math.random() > computeProbabilityToMove(deltaE,temperature)){
            return false;
        }
        return true;
    }

    public double computeProbabilityToMove(int deltaE, int temperature){
        return Math.pow(Math.E, -deltaE/temperature);
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
        return newNumberOfCollision - oldNumberOfCollision;
    }

    public int numberOfCollision() {
        int count = 0;
        for(int i = 0; i < queenList.length; i++) {
            for(int j = 0; j < queenList.length; j++) {
                if(i != j) {
                    if (queenList[i].getX() == queenList[j].getX()){
                        count++;
                    }
                    else if (queenList[i].getY() == queenList[j].getY()){
                        count++;
                    }
                    else if (Math.abs(queenList[i].getX() - queenList[j].getX()) == Math.abs(queenList[i].getY() - queenList[j].getY())){
                        count++;
                    }
                }
            }
        }
        return count * 10000;
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
