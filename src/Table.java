/**
 * Created by oat90 on 10/26/2016.
 */
public class Table {
    private Queen table[][] = new Queen[][]{{null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null},
                                            {null, null, null, null, null, null , null, null}};

    private Queen[] queens;

    public Table() {
        queens = new Queen[8];
    }

    public boolean putQueen(Queen q) {
        if(table[q.getY()][q.getX()] != null) {
            table[q.getY()][q.getX()] = q;
            return true;
        }
        return false;
    }

    public int checkCollision() {
        int count = 0;
        for(int i = 0; i < queens.length;i++) {
            for(int j = 0;j < queens.length;j++) {
                if(i != j) {
                    if (queens[i].getX() == queens[j].getX())
                        count++;
                    else if (queens[i].getY() == queens[j].getY())
                        count++;
                    else if (Math.abs(queens[i].getX() - queens[j].getX()) == Math.abs(queens[i].getY() - queens[j].getY()))
                        count++;
                }
            }
        }
        return count;
    }


}
