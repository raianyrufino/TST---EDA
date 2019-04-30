import java.util.*;

public class Parenteses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sequencia = sc.nextLine().split("");
		System.out.println(Validade(sequencia));
		
	}
	
	private static String Validade(String[] sequencia) {
		newPilha(sequencia);
		int contA = 0;
		int contB = 0;
		for(int i=0; i<sequencia.length; i++) {
			if(sequencia[i].equals("(")) {
				push(sequencia[i]);
				contA++;
			} else if(sequencia[i].equals(")")) {
				contB++;
				if(isEmpty()) {
					return "N";
				} 
				if(!pop().equals("(")) {
					return "N";
				}
			} 
		}
		if(contA == contB) {
			return "S";
		} else {
			return "N";
		}
		//return "S";
	}
	// fazer metodo para passar pra o array de pilha
	
	private static String[] pilha;
	private static int topo = -1;
	
	
	private static  void newPilha(String[] sequencia) {
		pilha = new String[sequencia.length];
		for(int i=0;i <sequencia.length;i++) {
			pilha[i] = sequencia[i];
		}
		
	}
	
	private static boolean isEmpty() {
		return topo == -1;
	}
	
	private static boolean isFull() {
		return topo == (pilha.length-1);
	}
	
	private static void push(String elemento) {
		if(isFull()) {
			throw new RuntimeException("Pilha cheia");
		}
		topo++;
		pilha[topo] = elemento;
	}
	
	public static String pop() {
		if(isEmpty()) {
			throw new RuntimeException("Pilha vazia");
		}
		String value = pilha[topo];
		topo--;
		return value;
	}
}
