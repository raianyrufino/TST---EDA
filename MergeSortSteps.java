import java.util.*;

class MergeSortSteps {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	int[] array = ConvertToInt(sc.nextLine().split(" "));
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        sc.close();
    }
    
    private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
}

    private static void sort(int[] array, int leftIndex, int rightIndex) {
    	 Array(array, leftIndex, rightIndex);
         if (leftIndex <  rightIndex) {
 			int media = (leftIndex + rightIndex)/2;
 			sort(array, leftIndex, media);
 			sort(array, media + 1, rightIndex);
 			merge(array ,leftIndex, media, rightIndex);
 			
 			if((rightIndex-leftIndex) < array.length-1){
 				Array(array, leftIndex, rightIndex);
 			}
         }
    }

    private static void merge(int[] array, int ini, int media, int fim) {
    	int[] aux = Arrays.copyOf(array, array.length);
		for (int i = 0; i < array.length; i++){
			aux[i] = array [i];
		}
		int i = ini;
		int j = media + 1;
		int k = ini;

		while(i <= media && j <= fim){
			if(aux[i] < aux[j]){
				array[k] = aux[i];
				i++;
			}else{
				array[k] = aux[j];
				j++;
			}
			k++;
		}
		while(i <= media){
			array[k] = aux[i];
			k += 1;
			i += 1;
		}
		while(j <= fim){
			array[k] = aux[j];
			k += 1;
			j += 1;
		}

    }
   
 
    private static void Array(int[] array, int leftIndex, int rightIndex) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, leftIndex, rightIndex + 1)));
    }

}