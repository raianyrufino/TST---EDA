public class NodeBST{
	
	private int value;
	private NodeBST left;
	private NodeBST right;
	private NodeBST parent;
	
	public NodeBST(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
	public void add(int element) {
		if(element > this.value) {
			if(this.right == null) {
				this.right = new NodeBST(element);
			} else {
				this.right.add(element);
			}
		} else {
			if(this.left == null) {
				 this.left = new NodeBST(element);
			} else {
				this.left.add(element);
			}
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NodeBST getLeft() {
		return left;
	}

	public void setLeft(NodeBST left) {
		this.left = left;
	}

	public NodeBST getRight() {
		return right;
	}

	public void setRight(NodeBST right) {
		this.right = right;
	}

	public NodeBST getParent() {
		return parent;
	}

	public void setParent(NodeBST parent) {
		this.parent = parent;
	}
	
	
}