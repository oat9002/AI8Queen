public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EightQueenSolver eightQueenSolver = new EightQueenSolver();
        eightQueenSolver.printTable();
        System.out.println(eightQueenSolver.numberOfCollision());
    }
}
