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

        return 0;
    }


}
