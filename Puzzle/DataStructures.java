package Puzzle;
import java.util.Queue;
import java.util.Stack;

public class DataStructures {
    private Queue<String> tail;
    private Stack<String> stack;

    public DataStructures(Queue<String> tail) { //Si la busqueda sera por anchura usa una cola
        this.tail = tail;
    }

    public DataStructures(Stack<String> stack) { //Si la busqueda sera por profundidad usa una pila
        this.stack = stack;
    }

    public void insert(String inicial) { 
        if (stack != null)
            stack.add(inicial);
        else
            tail.add(inicial);
    }

    public boolean isEmpty() {
        if (stack != null)
            return stack.isEmpty();
        else
            return tail.isEmpty();
    }

    public String remove() {
        if (stack != null)
            return stack.pop();
        else
            return tail.poll();
    }
}
