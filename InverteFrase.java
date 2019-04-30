import java.util.Scanner;

public class InverteFrase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		InverteFrase sequencia = new InverteFrase(frase.length());
		sequencia.split(frase);
		System.out.println(sequencia.Print());
		sc.close();
	}
	
	private Pilha pilha;
	
	public InverteFrase(int tamanho) {
		this.pilha = new Pilha(tamanho);
		
	}
	
	public void split(String frase){
		String palavra = "";
		for(int i = 0; i < frase.length(); i++) {
			if((frase.charAt(i) + "").equals(" ")) {
				pilha.push(palavra);
				palavra = "";
			} else {
				palavra += frase.charAt(i);
			}
		}
		pilha.push(palavra);
	}
	
	public String Print() {
		String fraseInvertida = "";
		while(!pilha.isEmpty()) {
			fraseInvertida += pilha.pop() + " ";
		}
		return fraseInvertida.trim();
	}
	
public class Pilha{
	private String[] pilha;
	private int topo;
	
	public Pilha(int capacidade) {
		this.pilha = new String[capacidade];
		this.topo = -1;
	}
	
	public boolean isEmpty() {
		return this.topo == -1;
	}
	
	public boolean isFull() {
		return this.topo == this.pilha.length - 1;
	}
	
	
	public void push(String valor) {
		if(isFull()) {
			throw new RuntimeException("Pilha cheia");
		}
		topo++;
		this.pilha[this.topo] = valor;
	}
	
	public String peek() {
		if(isEmpty()) {
			throw new RuntimeException("Pilha vazia");
		}
		return this.pilha[this.topo];
	}
	
	public String pop() {
		if(isEmpty()) {
			throw new RuntimeException("Pilha vazia");
		}
		String value = peek();
		topo--;
		return value;
	}
	
	public String print() {
		String saida = "";
		for(int i = 0; i <= this.topo;i++) {
			saida += this.pilha[i] + " ";
		}
		return saida.trim();
	}
}
}