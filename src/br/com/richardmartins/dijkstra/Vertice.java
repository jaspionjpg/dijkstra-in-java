package br.com.richardmartins.dijkstra;

public class Vertice {
	public Vertice() {
		valor = Integer.MAX_VALUE;
		verificado = false;
	}
	
	public Vertice(String nome) {
		valor = Integer.MAX_VALUE;
		verificado = false;
		this.nome = nome;
	}

	private int valor;
	private int elementoPai;
	private boolean verificado;
	private String nome;
	
	public int valor() {
		return valor;
	}

	public void valor(int valor) {
		this.valor = valor;
	}

	public void addValor(int valor) {
		this.valor += valor;
	}

	public int elementoPai() {
		return elementoPai;
	}

	public void elementoPai(int elementoPai) {
		this.elementoPai = elementoPai;
	}

	public boolean verificado() {
		return verificado;
	}

	public void verificado(boolean verificado) {
		this.verificado = verificado;
	}

	public String nome() {
		return nome;
	}

	public void nome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "\t\t nome: "+ nome +" \t\t pai: " + elementoPai + "\t\t " + valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

