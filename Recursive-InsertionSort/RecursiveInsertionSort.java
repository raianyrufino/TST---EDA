import java.util.Arrays;
import java.util.Scanner;

class RecursiveInsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
        insertionSort2(sequencia, 1);

    }

    private static void insertionSort2(int[] sequencia, int k) {
        if(k == sequencia.length) {
            return;
        }
        insertionSort(sequencia, k);
        System.out.println(Arrays.toString(sequencia));
        insertionSort2(sequencia,k+1);

    }

    private static void insertionSort(int[] sequencia, int k) {
        if (k == 0) {
            return;
        }
        if ((sequencia[k-1]) > (sequencia[k])) {
            swap(sequencia, k-1, k);
            insertionSort(sequencia, k-1);
        }
    }
    
    private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
    
    private static void swap(int[] sequencia, int i, int j) {
        int temp = sequencia[i];
        sequencia[i] = sequencia[j];
        sequencia[j] = temp;
    }
    
}