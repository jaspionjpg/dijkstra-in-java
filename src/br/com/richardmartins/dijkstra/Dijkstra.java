package br.com.richardmartins.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	private List<Vertice> vertices;
	private String src;
	private String[] nomes;

	private int[][] grafo;

	public Dijkstra(int[][] grafo, String src) {
		this.grafo = grafo;
		calcule(src);
	}

	public Dijkstra(int[][] grafo, String... nomes) {
		if (grafo.length == nomes.length) {
			this.nomes = nomes;
			this.grafo = grafo;
		}
	}

	public ResultadoDijkstra melhorCaminho(String comeco, String fim) {
		if (!comeco.equals(src)) {
			calcule(comeco);
		}

		return calculeResultado(comeco, fim);
	}

	public ResultadoDijkstra melhorCaminho(String fim) {
		return calculeResultado(src, fim);
	}

	private ResultadoDijkstra calculeResultado(String comeco, String fim) {

		List<String> caminho = new ArrayList<>();
		Vertice vertice = vertices.get(vertices.indexOf(new Vertice(fim)));
		if (vertice == null) {
			return null;
		}
		ResultadoDijkstra resultado = new ResultadoDijkstra(vertice.valor(), comeco, fim);

		while (true) {
			if (vertice.nome().equals(comeco)) {
				break;
			}
			caminho.add(0, vertice.nome());

			vertice = vertices.get(vertice.elementoPai());
		}
		caminho.add(0, comeco);
		resultado.setCaminho(caminho);

		return resultado;
	}

	public Dijkstra calcule(String src) {
		populeVertices();

		this.src = src;
		vertices.get(vertices.indexOf(new Vertice(src))).valor(0);
		vertices.get(vertices.indexOf(new Vertice(src))).elementoPai(vertices.indexOf(new Vertice(src)));

		for (int i = 0; i < vertices.size() - 1; i++) {

			int vertice = menorValor();

			vertices.get(vertice).verificado(true);

			for (int j = 0; j < vertices.size(); j++) {

				if (!vertices.get(j).verificado() && grafo[vertice][j] > 0
						&& vertices.get(vertice).valor() != Integer.MAX_VALUE
						&& vertices.get(vertice).valor() + grafo[vertice][j] < vertices.get(j).valor()) {

					vertices.get(j).valor(vertices.get(vertice).valor() + grafo[vertice][j]);
					vertices.get(j).elementoPai(vertice);
				}
			}
		}
		return this;
	}

	private void populeVertices() {
		vertices = new ArrayList<>();

		for (int i = 0; i < grafo.length; i++) {
			if (nomes != null) {
				if (nomes.length - 1 < i) {
					vertices.add(new Vertice(i + ""));
				} else {
					vertices.add(new Vertice(nomes[i]));
				}
			} else {
				vertices.add(new Vertice(i + ""));
			}
		}
	}

	private int menorValor() {
		int menorValor = Integer.MAX_VALUE;
		int menorValor_vertice = 0;

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).verificado() == false && vertices.get(i).valor() <= menorValor) {
				menorValor = vertices.get(i).valor();
				menorValor_vertice = i;
			}
		}

		return menorValor_vertice;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}
}
