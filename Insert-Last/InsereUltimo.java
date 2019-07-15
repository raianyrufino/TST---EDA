import java.util.*;

class InsereUltimo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
 		insereUltimo(sequencia);
		System.out.println(Arrays.toString(sequencia));
	}
	
	private static void insereUltimo(int[] array) {
		for(int i=0; i <= array.length-1; i++){
			for(int j=i+1; j <= array.length-1; j++){
				if(array[i] > array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static int[] ConvertToInt(String[] sequencia) {
		int[] sequenciaInt = new int[sequencia.length];
		
		for(int i=0; i<sequencia.length; i++) {
			sequenciaInt[i] = Integer.parseInt(sequencia[i]);
		}	
		return sequenciaInt;
	}
}