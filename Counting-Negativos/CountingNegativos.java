import java.util.Arrays;
import java.util.Scanner;

class CountingNegativos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = convertToIntArray(sc.nextLine().split(" "));
        int greatest = Integer.parseInt(sc.nextLine());
        int least = 0;
        
        negativesCountingSort(array, greatest, least);
    }

    private static void negativesCountingSort(int[] array, int greatest, int least) {

        int i;

        // The cumulativeArray have lenght = greater (for positive numbers) - least
        // (that will become a positive value that means the lenght for the negative part) + 1 (for the
        // zero position)
        int[] cumulativeArray = new int[greatest - least + 1];

        // Z keeps the zero index in the cumulative array. If the lesser value = -3, the 0 will stay at the
        // index 3. -3 at the index 0, -2 at the index 1, -1 at the index 2 and 0 at the index 3.
        int z = -(least);

        // Adding to the cumulative array only the frequency of the elements in each position
        for (i = 0; i < array.length; i++) {
            cumulativeArray[z + array[i]]++;
            System.out.println(Arrays.toString(cumulativeArray));
        }

        // Transforming to a real cumulative array
        for (i = 1; i < cumulativeArray.length; i++) {
            cumulativeArray[i] += cumulativeArray[i - 1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(cumulativeArray));

        // Creating an auxiliary array
        int[] auxArray = new int[array.length];

        // Puting in the auxArray the sorted elements of the array
        for (i = auxArray.length-1; i >= 0; i--) {
            auxArray[cumulativeArray[array[i]+z]-1] = array[i];
            cumulativeArray[array[i]+z]--;
        }
        System.out.println(Arrays.toString(cumulativeArray));

        // Inserting in the array the sorted elements from the auxArray
        for (i = 0; i < auxArray.length; i++) {
            array[i] = auxArray[i];
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] convertToIntArray(String[] array) {

        int[] arrayInt = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Integer.parseInt(array[i]);
        }

        return arrayInt;

    }
}