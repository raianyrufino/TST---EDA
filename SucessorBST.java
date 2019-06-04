import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SucessorBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		int element = sc.nextInt();
		sc.nextLine();
		
		BSTPredecessor bst = new BSTPredecessor();
		
		for(int i=0; i<sequencia.length; i++) {
			bst.add(sequencia[i]);
		}

	}
	
	// Método auxiliar para converter uma sequencia para inteiros.
	private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
}

class BSTSucessor{
	
	private NodeBST root;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void add(int element) {
		if(!isEmpty()) {
			this.root.add(element);
		} else {
			this.root = new NodeBST(element);
		}
	}
	
	/*
	public Object[] search(int element) {
		List<Integer> lista = new ArrayList<Integer>();
		this.search(this.root, element, lista);
		return lista.toArray();
		
	}

	public void search(NodeBST node, int element, List<Integer> lista) {
		if(!isEmpty()) {
			
			lista.add(node.getValue());
			
			if (element == node.getValue()) {

			} else if (element > node.getValue() && node.getRight() != null) {
				this.search(node.getRight(), element, lista);
			} else if (element < node.getValue() && node.getLeft() != null){
				this.search(node.getLeft(), element, lista);
			}
		}
	}
	*/
	
	public Integer[] sucessor(Integer element) {
		Integer[] auxOut = new Integer[this.size()];
		NodeBST aux = search(element);
		int i = 0;
		if(aux != null) {
			auxOut[i++] = aux.getValue();
			
			if(aux.getRight() == null) {
				aux = aux.getParent();
				
				while(aux != null) {
					auxOut[i++] = aux.getValue();
					if(aux.getValue() <= element) {
						break;
					}
					aux = aux.getParent();
				}
			}
		} else {
			aux = aux.getRight();
			while(aux != null) {
				auxOut[i++] = aux.getValue();
				aux = aux.getLeft();
			}
		}
		return auxOut;
	}
	
	private int size() {
		return size(this.root);
	}

	private int size(NodeBST node) {
		int result = 0;
		if (node != null) {
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}
	
	public NodeBST search(Integer element) {
		NodeBST aux = null;
		if (element != null && !isEmpty()) {
			aux = this.root;
			while (aux != null && aux.getValue() != element) {
				if (element > aux.getValue()) {
					aux = aux.getRight();
				} else if (element < aux.getValue()) {
					aux = aux.getLeft();
				}
			}
		}
		return aux;
	}	
	
}
