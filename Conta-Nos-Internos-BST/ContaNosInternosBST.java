import java.util.ArrayList;
import java.util.Scanner;

public class ContaNosInternosBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		//int element = sc.nextInt();
		
		NosInternosBST bst = new NosInternosBST();
		for(int i=0; i<sequencia.length; i++) {
			bst.add(sequencia[i]);
		}
		System.out.println(bst.countNos());
		sc.close();
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

class NosInternosBST{
	
	NodeBST root; // raiz;
	int cont;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void add(int element) {
		if(this.isEmpty()) {
			this.root = new NodeBST(element);
		} else {
			this.root.add(element);
		}
	}
	
	public int countNos() {
		return this.countNos(this.root);
	}

	
	private int countNos(NodeBST node) {
		if(!isEmpty()) {
			
			if(noInterno(node)) {
				cont += 1;
			}
			if(node.getRight() != null) {
				countNos(node.getRight());
			}
			if(node.getLeft() != null) {
				countNos(node.getLeft());
			}
				
		}
		return cont;
	}
	
	private boolean noInterno(NodeBST node) {
		return node.getLeft() != null || node.getRight() != null;
	}
}

