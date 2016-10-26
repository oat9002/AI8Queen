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

    private Queen[] queens = new Queen[8];

    public Table() {
        for(int i = 0;i < queens.length;i++) {
            putQueen(new Queen((int)(Math.random() * 8), (int)(Math.random() * 8)));
        }
    }

    public boolean putQueen(Queen q) {
        if(table[q.getY()][q.getX()] == null) {
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

    public void printTable() {
        for(int i = 0;i < table.length;i++) {
            for(int j = 0; j < table.length;j++) {
                if(table[i][j] != null)
                    System.out.print("Q");
                else
                    System.out.print("-");
            }
            System.out.println();
        }
    }
}
