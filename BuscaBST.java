import java.util.*;

public class BuscaBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		int element = sc.nextInt();
		sc.nextLine();
		
		BSTBusca bst = new BSTBusca();
		for (int i : sequencia) {
			bst.add(i);
		}
		
		System.out.println(Arrays.toString(bst.search(element)));
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

class BSTBusca{
	
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
	
	public Object[] search(int element) {
		List<Integer> lista = new ArrayList<Integer>();
		this.search(this.root, element, lista);
		return lista.toArray();
		
	}

	private void search(NodeBST node, int element, List<Integer> lista) {
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
}





