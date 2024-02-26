package Puzzle;

import java.util.*;

public class Puzzle {
    static String edoObjetive = "12345678 ";
    static ArrayList<String> totalSuccessors = new ArrayList<>();
    
    public static void BreadthFirstSearch(String start) {
        Queue<String> tail = new LinkedList<>();
        search(start, new DataStructures(tail));
    }

    public static void DepthFirstSearch(String start) {
        search(start, new DataStructures(new Stack<>()));
    }

    private static void search(String start, DataStructures structure) {
        if (!totalSuccessors.isEmpty()) {
            totalSuccessors.clear();
        }
        
        structure.insert(start);
        totalSuccessors.add(start);
        
        while (!structure.isEmpty()) {
            String node = structure.remove();
            ArrayList<String> successors = getSuccessors(node);
            for (String child : successors) {
                if (!totalSuccessors.contains(child)) {
                    structure.insert(child);
                    totalSuccessors.add(child);
                    if(child.equals(edoObjetive)) {
                        System.out.println("Nodos que fueron visitados: " + totalSuccessors.size());
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<String> getSuccessors(String edoActual) {
        ArrayList<String> successors = new ArrayList<>();
        int index = edoActual.indexOf(" ");
        int[][] moves = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4, 6},
                {1, 3, 5, 7},
                {2, 4, 8},
                {3, 7},
                {4, 6, 8},
                {5, 7}
        };

        for (int value : moves[index]) {
            String successor = changeState(edoActual, index, value);
            successors.add(successor);
        }
        return successors;
    }

    private static String changeState(String edoActual, int index, int value) {
        char c1 = edoActual.charAt(index);
        char c2 = edoActual.charAt(value);
        StringBuilder auxSB = new StringBuilder(edoActual);
        auxSB.setCharAt(index, c2);
        auxSB.setCharAt(value, c1);
        return auxSB.toString();
    }
}
