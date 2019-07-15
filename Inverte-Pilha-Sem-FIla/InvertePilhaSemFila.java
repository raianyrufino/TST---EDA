import java.util.*;
public class InvertePilhaSemFila {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacidade = sc.nextInt();
		sc.nextLine();
		int[] array = convertToIntArray(sc.nextLine().split(" "));
		invertePilha(array, capacidade);
		printArray(array);
		
	}

	private static int top = -1;
	private static int[] pilha;
	
	public static void invertePilha(int[] sequencia, int capacidade) {
		pilha(capacidade);
		
		// Empilha os elementos da sequência dada.
		for(int i=0;i<sequencia.length;i++) {
			add(sequencia[i]);
		}
		
		// Inverte a pilha de elementos.
		for(int i=0;i<pilha.length;i++) {
			int value = pop();
			int aux = sequencia[i];
			value = aux;
			aux = sequencia[i];
		}
		
	}
	
	public static void pilha(int capacidade) {
		pilha = new int[capacidade];
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static void add(int element) {
		if(top == pilha.length-1) {
			System.out.println("full");
		}
		top++;
		pilha[top] = element;
	}
		
	public static int pop() {
		if(top == -1) {
			System.out.println("Empty");
		} 
		int value = pilha[top];
		top--;
		return value;
	}
	
	
	private static void printArray(int[] array) {
		for(int i =0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	
	private static int[] convertToIntArray(String[] array) {
        int[] arrayInt = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Integer.parseInt(array[i]);
        }
        return arrayInt;
	}
	
	
}
