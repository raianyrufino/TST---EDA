import java.util.Scanner;

public class isHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		
		System.out.println(heap(sequencia));
	}
	
	// Método auxiliar para converter uma sequencia para inteiros.
	private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
			
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
	
	public static boolean heap(int[] sequencia) {
		boolean status = true;
		int i = 0;
		
		while(status && left(i) < sequencia.length && right(i) < sequencia.length) {
			if(sequencia[left(i)] > sequencia[parent(i)] || sequencia[right(i)] > sequencia[parent(i)] ) {
				status = false;
			}
			i++;
		}
		return status;
	}
	
	private static int parent(int i) {
		return (i-1)/2;
	}
	
	// indice do valor que está a esq de i
	private static int left(int i) {
		return (2*i+1);
	}
	
	// indice do valor que está a dir de i
	private static int right(int i) {
		return (2*i+1)+1;
	}
}

