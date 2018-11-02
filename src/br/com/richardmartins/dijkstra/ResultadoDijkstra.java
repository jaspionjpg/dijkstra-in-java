package br.com.richardmartins.dijkstra;

import java.util.List;

public class ResultadoDijkstra {
	private Integer custo;
	private List<String> caminho;
	private String comeco;
	private String fim;
	
	public ResultadoDijkstra(Integer custo, String comeco, String fim) {
		super();
		this.custo = custo;
		this.comeco = comeco;
		this.fim = fim;
	}

	public Integer getCusto() {
		return custo;
	}
	
	public void setCusto(Integer custo) {
		this.custo = custo;
	}
	
	public List<String> getCaminho() {
		return caminho;
	}
	
	public void setCaminho(List<String> caminho) {
		this.caminho = caminho;
	}
	
	public String getComeco() {
		return comeco;
	}

	public void setComeco(String comeco) {
		this.comeco = comeco;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	@Override
	public String toString() {
		return "Da vertice " + comeco +" ao " + fim +" o caminho de menor custo foi: " + caminho.toString() + " com custo " + String.valueOf(custo);
	}
}