package Tree;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private boolean haveChild; 

	public Node(int value) {
		this.value=value;
		left = null;
		right = null;
		haveChild = false;
	}

	public int getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public boolean isHaveChild() {
		return haveChild;
	}

	public void setHaveChild(boolean haveChild) {
		this.haveChild = haveChild;
	}
}