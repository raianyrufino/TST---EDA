import java.util.Arrays;
import java.util.Scanner;

public class Heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		
		/*
		System.out.println(Arrays.toString(heap));
		insert(10);
		System.out.println(Arrays.toString(heap));
		insert(9);
		System.out.println(Arrays.toString(heap));
		insert(8);
		System.out.println(Arrays.toString(heap));
		insert(1);
		System.out.println(Arrays.toString(heap));
		insert(25);
		System.out.println(Arrays.toString(heap));
		insert(20);
		System.out.println(Arrays.toString(heap));
		insert(18);
		System.out.println(Arrays.toString(heap));
		*/
		
		int[] lista = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		buildHeap(lista);
		System.out.println(Arrays.toString(heap));
		
	
	}
	
	// Método auxiliar para converter uma sequencia para inteiros.
	private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
	
// Metodos do HEAP
	
	private static int heap[] = new int[20];
	private static int index = -1;
	
	public static boolean isHeap(int[] sequencia) {
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
	
	// retorna o indice do pai
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
	
	public static void insert(int element) {
		insert(heap, element);
	}

	private static void insert(int[] array, int element) {
		index += 1;
		int i = size() - 1;
		
		while(i > 0 && array[parent(i)] < element) {
			array[i] = array[parent(i)];
			i = parent(i);
		}
		array[i] = element;		
	}
	
	private static int size() {
		return index + 1;
	}
	
	public static void heapFy(int position) {
		heapFy(heap, position);
	}
	
	private static void heapFy(int[] array, int position) {
		if(position >= 0) {
			int largest;
			int left = left(position);
			int right = right(position);
			if(left <= index && array[left] > array[position]) {
				largest = left;
			} else {
				largest = position;
			}
			if(right <= index && array[right] > array[largest]) {
				largest = right;
			}
			if(largest != position) {
				swap(array, position, largest);
				heapFy(array, largest);
			}
		}
		
	}
	
	public static void buildHeap(int[] array) {
		heap = array;
		index = array.length-1;
		for(int i=array.length-1/2; i >= 0; i--) {
			heapFy(i);
		}
	}
		
	private static void swap(int[] sequencia, int i, int j) {
        int temp = sequencia[i];
        sequencia[i] = sequencia[j];
        sequencia[j] = temp;
	}
	
}
