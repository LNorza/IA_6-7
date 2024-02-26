package Tree;

public class TreeTest {

    public static void main(String[] args) {
        searchTree tree = new searchTree();
        tree.insert(1);
        tree.insert(5);
        tree.insert(80);
        tree.insert(2);
        tree.insert(19);
        tree.insert(50);
        System.out.println("total: " + tree.total(tree.getRoot()));
        System.out.println("Print In Order: ");
        tree.inOrder(tree.getRoot());
        tree.isEmpty();
        tree.setEmpty();
        tree.isEmpty();

    }
    
}
