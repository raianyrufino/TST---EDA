import java.util.*;

class EstatisticaOrdem {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] sequencia = ConvertToInt(sc.nextLine().split(" "));
    System.out.println(ordem(sequencia));
    particionaEstavel(sequencia);
  }

  private static int ordem(int[] array){
	if(array.length == 1) {
		return 1;
	} 
	
    if(array.length > 1 && array != null){
      int ordem = 1;
      for(int i=1; i<=array.length-1;i++){
        if(array[0] > array[i]){
          ordem +=1;
        }
      }
      return ordem;
    }
    return 0;
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
  
  private static int[] ConvertToInt(String[] sequencia) {
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

