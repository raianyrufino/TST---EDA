import java.util.Scanner;

public class AlturaBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		
		BSTAltura bst = new BSTAltura();
		
		for(int i=0; i<sequencia.length; i++) {
			bst.add(sequencia[i]);
		}
		System.out.println(bst.height());
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

class BSTAltura{
	
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
	
	public int height() {
		if(!isEmpty()) {
			return this.height(this.root) - 1 ;
		}
		return -1;
	}

	private int height(NodeBST node) {
		int hLeft;
		int hRight;
		if(node.getLeft() != null) {
			hLeft = height(node.getLeft());
		} else {
			hLeft = 0;
		}
		
		if(node.getRight() != null) {
			hRight = height(node.getRight());
		} else {
			hRight = 0;
		}
		
		return 1 + Integer.max(hLeft, hRight);
	}
}




