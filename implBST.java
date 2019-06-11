import java.util.ArrayList;
import java.util.List;public class implBST {
	
	
	private NodeBST root;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public int countLeafs() {
		if(!isEmpty()) {
			this.root.isLeaf();
		}
		return 1 + countLeafs();
	}
	
	public int size() { //Return altura da BST
		return this.size(this.root);
	}
	
	private int size(NodeBST node) {
		if(node == null)
			return 0;
		return 1 + Integer.max(this.size(node.getLeft()), this.size(node.getRight()));
	}

	public void add(int element) {
		if(!isEmpty()) {
			this.root.add(element);
		} else {
			this.root = new NodeBST(element);
		}
	}
	
	public NodeBST search(int element) {
		NodeBST node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private NodeBST search(NodeBST node, int element) {
		NodeBST result = new NodeBST(element);
		if (node == null) {

			if (element == node.getValue()) {
				result = node;
			} else if (element > node.getValue()) {
				result = this.search(node.getRight(), element);
			} else {
				result = this.search(node.getLeft(), element);
			}
		}
		return result;
}
	
	public NodeBST min(NodeBST node) {
		if(node == null) {
			return null;
		}
		if(node.getLeft() == null) {
			return node;
		} return min(node.getLeft());
	}
	
	public NodeBST max(NodeBST node) {
		if(node == null) {
			return null;
		}
		if(node.getRight() == null) {
			return node;
		} return min(node.getRight());
	}
	
	public NodeBST predecessor(NodeBST node) { //Return o maior dentre os menores.
		if(node.getLeft() != null) {
			return max(node.getLeft());
		} 
		
		NodeBST aux = node;
		while(aux.getParent() != null) {
			if(aux.getParent().getValue() < aux.getValue()) {
				return aux.getParent();
			}
			aux = aux.getParent();
		}
		return null; // Não há predecessor
	}
	
	public NodeBST sucessor(NodeBST node) {
		if(node.getRight() != null) {
			return min(node.getRight());
		}
		
		NodeBST aux = node;
		while(aux.getRight() != null) {
			if(aux.getParent().getValue() > aux.getValue()) {
				return aux.getParent();
			}
			aux = aux.getParent();
		}
		return null; // Não há sucessor.
	}
	
	public Object[] preOrd() {
		List<Integer> list = new ArrayList<Integer>();
		this.preOrd(this.root, list);
		return list.toArray();
	}

	private void preOrd(NodeBST node, List<Integer> list) {
		if(!isEmpty()) {
			list.add(node.getValue());
			this.preOrd(node.getLeft(), list);
			this.preOrd(node.getRight(), list);
		}
	}
	
	public Object[] inOrd() {
		List<Integer> list = new ArrayList<Integer>();
		this.inOrd(this.root, list);
		return list.toArray();
	}

	private void inOrd(NodeBST node, List<Integer> list) {
		if(!isEmpty()) {
			this.inOrd(node.getLeft(), list);
			list.add(node.getValue());
			this.inOrd(node.getRight(), list);
		}
	}
	
	public Object[] posOrd() {
		List<Integer> list = new ArrayList<Integer>();
		this.posOrd(this.root, list);
		return list.toArray();
	}

	private void posOrd(NodeBST node, List<Integer> list) {
		if(!isEmpty()) {
			this.posOrd(node.getLeft(), list);
			this.posOrd(node.getRight(), list);
			list.add(node.getValue());
		}
	}
	
	public void BSF() {
		
	}
	
	private boolean hasOneChild(NodeBST node) {
		return node.getLeft() != null && node.getRight() == null
				|| node.getLeft() == null && node.getRight() != null;
	}
	
	private NodeBST getOnlyChild(NodeBST node) {
		NodeBST child = node.getLeft();
		if (child == null) {
			child = node.getRight();
		}
		return child;
	}
	
	private boolean isLeftChild(NodeBST node) {
		return node.getParent() != null && node.getParent().getLeft() == node;
	}
	
	private boolean isRightChild(NodeBST node) {
		return node.getParent() != null && node.getParent().getRight() == node;
	}
	
	public void remove(int element) {
		NodeBST node = search(element);
		
		if(node != null) {
			remove(node);
		}
		if(this.preOrd().length == 0) {
			System.out.println("null");
		}
	}

	private void remove(NodeBST node) {
		if(node != null) {
			if(node.isLeaf()) {
				node.setValue(-1);
				node.setLeft(null);
				node.setRight(null);
			}
			else if(hasOneChild(node)) {
				NodeBST child = getOnlyChild(node);
				if(node == this.root) {
					root = child;
				} else {
					if(isLeftChild(node)) {
						if(node.getLeft() != null) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (node.getLeft() != null) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				}
			}
			else {
				NodeBST sucessor = this.sucessor(node);
				node.setValue(sucessor.getValue());
				remove(sucessor);
			}
		}
	}
	
}
