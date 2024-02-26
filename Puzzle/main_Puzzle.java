package Puzzle;

public class main_Puzzle {
	public static void main(String[] args) {
        String status = "1234 5678";
        System.out.println("Busqueda por anchura:");
        // System.out.println("Busqueda por profunfidad:");

        long start = System.currentTimeMillis();
        Puzzle.BreadthFirstSearch(status);
        // Puzzle.DepthFirstSearch(status);
        long end = System.currentTimeMillis();
        
        System.out.println("tiempo total: "+(end-start));
    }
}