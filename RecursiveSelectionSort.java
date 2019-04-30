import java.lang.reflect.Array;
import java.util.*;
class RecursiveSelectionSort {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
		
		selectionSort(sequencia, 0);
	}
	
	
	private static  void selectionSort(int[] sequencia, int k) {
		if(k < sequencia.length -1) {
			int smaller = k;
			for(int i=smaller; i<sequencia.length; i++) {
				if(sequencia[i] < sequencia[smaller]) {
					smaller = i;
				}
			}
			Swap(sequencia, k, smaller);
			System.out.println(Arrays.toString(sequencia));
			selectionSort(sequencia, k+1);
		}
	}

	private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
	
	private static void Swap(int[] array, int k, int smaller) {
		int temp = array[k];
		array[k] = array[smaller];
		array[smaller] = temp;
	}
	
	
	
	
}
