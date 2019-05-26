import java.util.*;

public class ehArvore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vertices, arestas;
		String[] entrada = sc.nextLine().split(" ");
		
		vertices = Integer.parseInt(entrada[0]);
		arestas = Integer.parseInt(entrada[1]);
		boolean[] visitados = new boolean[vertices];
		
		String status = "True";
		if (vertices - 1  != arestas  ) {
            System.out.println("False");
		}
		
		// Percorrendo arestas
		for(int i=0; i<arestas; i++) {
			entrada = sc.nextLine().split(" ");
			if(entrada[0].equals(entrada[1])) {
				status = "False";
			}
			if(visitados[Integer.parseInt(entrada[0])] && visitados[Integer.parseInt(entrada[1])]) {
                status = "False";
            }
            visitados[Integer.parseInt(entrada[0])] = true;
            visitados[Integer.parseInt(entrada[1])] = true;
		}
		System.out.println(status);
	}
}
