import java.util.*;

public class StackWithArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int capacidade = sc.nextInt();
		sc.nextLine();
		StackWithArray stack = new StackWithArray(capacidade);
		String operacao, entrada;
		int element;
		
		do {
			 operacao = sc.nextLine();
			 switch(operacao) {
			 	
			 	case "print":
			 		System.out.println(stack.print());
			 		break;
			 	
			 	case "peek":
			 		System.out.println(stack.peek());
			 		break;
			 		
			 	case "pop":
			 		int i = stack.pop();
					if (i == -1) {
						System.out.println("empty");
					}
			 		break;
			 	
			 
			 	default:
			 		String[] op = operacao.split(" ");
					if (op[0].equals("push")) {
						stack.push(Integer.parseInt(op[1]));
					}
			 }					
		} while (!operacao.equals("end"));
	}

	private int[] pilha;
	private int capacidade;
	private int top;
	
	private StackWithArray(int capacidade) {
		this.pilha = new int[capacidade];
		this.capacidade = capacidade;
		this.top = -1;
	}
	
	public boolean isFull() {
		return this.top == this.capacidade-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public String print() {
		String result = "empty";
		if (!isEmpty()) {
			result = "";
			for (int i = 0; i < top; i++) {
				result += pilha[i] + " ";
			}
			result += pilha[top] + "";
		}
		return result;
	}
	
	public int peek() {
		if(this.top == -1) {
			return -1;
		} 
		return this.pilha[top];
	}
	
	public void push(int element) {
		if(this.top < this.capacidade-1) {
			this.top++;
			this.pilha[top] = element;
		} else {
			System.out.println("full");
		}
	}
		
	public int pop() {
		int result = -1;
		if (!isEmpty()) {
			top--;
			result = pilha[top + 1];
		}
		return result;
		
	}


}

/*
 * Seu programa deve imprimir o conteúdo da pilha sempre que uma operação print for lida. 
 * Se a pilha estiver vazia, imprima "empty".

Seu programa deve imprimir o elemento no topo da pilha quando ler a operação peek.

Se a pilha estiver vazia e for lida a operação pop, imprima "empty".

Se a pilha estiver cheia e for lida a operação push, imprima "full".
 */
