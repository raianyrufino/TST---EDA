import java.util.*;

class ParticionaEstavel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = convertToInt(sc.nextLine().split(" "));
        particionaEstavel(sequencia);
        System.out.println(Arrays.toString(sequencia));

    }

    private static void particionaEstavel(int[] array) {
        int i;
        int j;
        int k = 0;
        for (i = 1; i < array.length; i++) {
            if (array[i] <= array[0]) {
                if (i == 1) {
                    k++;
                } else {
                    for (j = i; j - 1 > k; j--) {
                        swap(array, j, j-1);
                    }
                    k++;
                }
            }
        }

        i = 0;
        while (i < array.length - 1) {
            if (array[i] > array[i+1]) {
                swap(array, i, i+1);
            } else {
                break;
            }
            i++;
        }
    }

    private static int[] convertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
  }

    private static void swap( int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}