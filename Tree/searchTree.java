package Tree;

public class searchTree {
    private Node root;
    private Node father;
    private int total;

    public searchTree() { // constructor
        root = null;
    }

    public Node getRoot() { // getter 
        return root;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        insert(value, root, node);
    }

    private void insert(int value, Node nodeAux, Node node) {

        if (value == nodeAux.getValue()) // si el valor ya existe
            return;

        if (value < nodeAux.getValue() && nodeAux.getLeft() == null) { // si el valor es menor y no hay nada a la izquierda
            nodeAux.setLeft(node);
            nodeAux.setHaveChild(true);
            return;
        }

        if (value < nodeAux.getValue() && nodeAux.getLeft() != null) {  // si el valor es menor y hay algo a la izquierda
            insert(value, nodeAux.getLeft(), node);
            nodeAux.setHaveChild(true);
            return;
        }

        if (value > nodeAux.getValue() && nodeAux.getRight() == null) { // si el valor es mayor y no hay nada a la derecha
            nodeAux.setRight(node);
            nodeAux.setHaveChild(true);
            return;
        } else  // si el valor es mayor y hay algo a la derecha
            insert(value, nodeAux.getRight(), node);
        nodeAux.setHaveChild(true);
    }

    

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    /* otras formas de recorrer el arbol e imprimirlo
     public void preorden(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            inorden(node.getLeft());
            inorden(node.getRight());
        }
    }

    public void postorden(Node node) {
        if (node != null) {
            inorden(node.getLeft());
            inorden(node.getRight());
            System.out.println(node.getValue());
        }
    } */

    public Node search(int value, Node nodeAux) { // busca un valor en el arbol
        if (nodeAux == null) // si el arbol esta vacio
            return null;

        if (value != nodeAux.getValue()) { // si el valor no es el que se busca
            father = nodeAux;
            if (value < nodeAux.getValue())
                return search(value, nodeAux.getLeft());
            else
                return search(value, nodeAux.getRight());
        }

        if (value == root.getValue())
            return root;
        return father;
    }

    public int total(Node node) {
    	if (node != null) {
    		total++;
    		total(node.getLeft());
    		total(node.getRight());
    	}
        return total;
    }

    public void isEmpty() {
        if (root == null)
            System.out.println("El arbol esta vacio!!");
        else
            System.out.println("El arbol no esta vacio!!");
    }

    public void setEmpty() {
        root = null;
    }
}