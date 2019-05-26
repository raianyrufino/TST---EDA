import java.util.Arrays;
import java.util.Scanner;

public class buildHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		
		HeapBuildHeap heap = new HeapBuildHeap();
		heap.heap(sequencia);
		System.out.println(Arrays.toString(heap.getHeap()));
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

class HeapBuildHeap{
	
	private int[] heap;
	private int index = -1;
	
	public void heap(int[] sequencia) {
		this.heap = sequencia;
		this.index = sequencia.length-1;
		
		for (int i = index / 2; i >= 0; i--) {
			heapfy(i);
		}
		
	}
	
	private void heapfy(int position) {
		if(position >= 0 && position <= this.index) {
			
			int left = left(position);
			int right = right(position);
			int maior;
			
			if(left <= this.index && this.heap[left] > this.heap[position]) {
				maior = left;
			} else {
				maior = position;
			}
			
			if(right <= this.index && this.heap[right] > this.heap[maior]) {
				maior = right;
			} 
			
			if(position != maior) {
				swap(heap, position, maior);
				heapfy(maior);
			}
		}
	}
	
	private int parent(int i) {
		return (i-1)/2;
	}
	
	// indice do valor que está a esq de i
	private int left(int i) {
		return (2*i+1);
	}
	
	// indice do valor que está a dir de i
	private int right(int i) {
		return (2*i+1)+1;
	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public int[] getHeap() {
		return this.heap;
	}
}

