package br.com.richardmartins.dijkstra;

import java.util.List;

public class Teste {
	
	public static void main(String[] args) {
		// Caso do teste com do exercicio passado pelo facebook
		// Caso A
		String teste1_aComeco = "X";		
		String teste1_aFim = "S";
		// Caso b
		String teste1_bComeco = "Z";		
		String teste1_bFim = "U";
		
		// Grafo teste 1 facebook
		int[][] grafo1 = { { 0, 1, 4, 0, 0, 0, 0, 0 }, { 1, 0, 2, 9, 0, 0, 0, 2 }, { 4, 2, 0, 1, 3, 0, 0, 0 },
				{ 0, 9, 1, 0, 1, 3, 1, 0 }, { 0, 0, 3, 1, 0, 1, 0, 0 }, { 0, 0, 0, 3, 1, 0, 6, 0 },
				{ 0, 0, 0, 1, 0, 6, 0, 14 }, { 0, 2, 0, 0, 0, 0, 14, 0 } };
		String[] nomesGrafo1 = {"S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		// busca o resultado do teste 1 com o caso A
		ResultadoDijkstra resultadoDijkstra = new Dijkstra(grafo1, nomesGrafo1).calcule(teste1_aComeco).melhorCaminho(teste1_aFim);
		System.out.println(resultadoDijkstra);
		// Resultado: Da vertice X ao S o caminho de menor custo foi: [X, W, V, U, T, S] com custo 6
		
		// busca o resultado do teste 1 com o caso B
		resultadoDijkstra = new Dijkstra(grafo1, nomesGrafo1).calcule(teste1_bComeco).melhorCaminho(teste1_bFim);
		System.out.println(resultadoDijkstra);
		// Resultado: Da vertice Z ao U o caminho de menor custo foi: [Z, T, U] com custo 4
		
		// ----------------
		// Caso do teste com do exercicio passado em sala
		// Caso 1
		String teste1aula_aComeco = "A";		
		String teste1aula_zComeco = "Z";
		
		// Grafo 1 aula
		int[][] grafo2 = {	{0, 4, 0, 5, 0, 0, 2, 0},
							{4, 0, 5, 0, 0, 0, 1, 0},
							{0, 5, 0, 0, 0, 1, 0, 1},
							{5, 0, 0, 0, 2, 0, 1, 0},
							{0, 0, 0, 2, 0, 1, 0, 3},
							{0, 0, 1, 0, 1, 0, 0, 2},
							{2, 1, 0, 1, 0, 0, 0, 0},
							{0, 0, 1, 0, 3, 2, 0, 0}};
		String[] nomesGrafo2 = {"A", "B", "C", "D", "E", "F", "G", "Z"};
		// busca o resultado do teste 1 com o caso A
		resultadoDijkstra = new Dijkstra(grafo2, nomesGrafo2).calcule(teste1aula_aComeco).melhorCaminho(teste1aula_zComeco);
		System.out.println(resultadoDijkstra);
		// Resultado: Da vertice A ao Z o caminho de menor custo foi: [A, G, D, E, Z] com custo 8

		
		// Caso 2
		String teste2aula_aComeco = "1";		
		String teste2aula_zComeco = "6";
		
		// Grafo 1 aula
		int[][] grafo3 = {	{0, 15, 9, 0, 0, 0},
							{0, 0, 0, 2, 0, 0},
							{0, 4, 0, 3, 16, 0},
							{0, 0, 0, 0, 6, 21},
							{0, 0, 0, 0, 0, 7},
							{0, 0, 0, 0, 0, 0}};
		String[] nomesGrafo3 = {"1", "2", "3", "4", "5", "6"};
		// busca o resultado do teste 1 com o caso A
		resultadoDijkstra = new Dijkstra(grafo3, nomesGrafo3).calcule(teste2aula_aComeco).melhorCaminho(teste2aula_zComeco);
		System.out.println(resultadoDijkstra);
		// Resultado: Da vertice 1 ao 6 o caminho de menor custo foi: [1, 3, 4, 5, 6] com custo 25

		
		// ------------------------------------------
		// Aqui um resumo de todas as possibilidades de manipulação de array com retornos diferentes o mesmo grafo
		
		//Situação de melhor caminho entre 2 pontos, com um array onde você escolhe as nomeclaturas dos pontos
		ResultadoDijkstra vertices = new Dijkstra(grafo1, "S", "T", "U", "V", "W", "X", "Y", "Z").melhorCaminho("X", "S");
		System.out.println(vertices);
		System.out.println();

		//Situação de melhor caminho onde o algoritmo em que , com um array onde você escolhe as nomeclaturas dos pontos
		List<Vertice> vertices2 = new Dijkstra(grafo1, "0").getVertices();
		for (int i = 0; i < vertices2.size(); i++) {
			System.out.println(i + vertices2.get(i).toString());
		}
		System.out.println();
		
		List<Vertice> vertices3 = new Dijkstra(grafo1, "S", "T", "U", "V", "W", "X", "Y", "Z").calcule("S").getVertices();
		for (int i = 0; i < vertices3.size(); i++) {
			System.out.println(i + vertices3.get(i).toString());
		}
	}
}
