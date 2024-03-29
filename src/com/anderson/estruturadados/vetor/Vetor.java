package com.anderson.estruturadados.vetor;

public class Vetor {
	
	// atributos
	private String[] elementos;
	private int tamanho;
	
	// construtor ir� inicializar o vetor
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
	// ADICIONAR ELEMENTO FINAL DO VETOR - OP��O 1
	// forma simples de adicionar um elememnto no vetor
	/*public void adiciona(String elemento) {
		for(int i = 0; i < this.elementos.length; i++) {
			if(this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	}*/
	// Esse algoritmo fuciona mas n�o � muito eficiente para vetores muito grandes
	
	
	// ADICIONAR ELEMENTO FINAL DO VETOR - OP��O 2
	/*public void adiciona(String elemento) throws Exception {
		
		if(tamanho < elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor est� cheio, n�o � poss�vel adicionar mais elementos");
		}
	}*/
	
	
	// ADICIONAR ELEMENTO FINAL DO VETOR - OP��O 3 (melhor op��o)
	public boolean adiciona(String elemento) {
		this.aumentarCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} else {
			return false;
		}
	}
	
	// adiciona um elemento em qualquer posi��o do vetor
	public boolean adiciona(int posicao, String elemento) {
		
		// verifica se existe determinado elemento no vetor
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
		}
		
		this.aumentarCapacidade();
		
		// move todos os elementos
		for(int i = this.tamanho -1; i >= posicao; i--) {
			this.elementos[i +1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return true;
	}
	
	// adiciona capacidade no vetor
	private void aumentarCapacidade() {
		if(this.tamanho == this.elementos.length) {
			// cria um novo vetor com dobro de capacidade
			String[] elementosNovos = new String[this.elementos.length *2];
			for(int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	// obtem elemento de uma posi��o
	public String buscar(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
		}
		return this.elementos[posicao];
	}
	
	// verifica se existe determinado elemento no vetor
	public int buscar(String elemento) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;// retorna posi��o do elemento
			}
		}
		return -1;// retorna uma posi��o que n�o existe
	}

	// retorna o tamanho do vetor
	public int getTamanho() {
		return tamanho;
	}
	
	// remove elemento do vetor
	public void remover(int posicao) {
		// verifica se existe determinado elemento no vetor
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
		}
		for(int i = posicao; i < this.tamanho -1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}
	
	// imprime totos os elementos dentro do vetor n�o nulos (forma mais simples, por�m menos eficiente)
	/*@Override
	public String toString() {
		
		String s = "[";
		for(int i = 0; i < this.tamanho -1; i++) {
			s += this.elementos[i];
			s += ", ";
		}
		if(this.tamanho > 0) {
			s += this.elementos[this.tamanho -1];
		}
		
		s += "]";
		
		return Arrays.toString(elementos);
	}*/
	
	// imprime totos os elementos do vetor n�o nulos (forma mais eficiente)
	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for(int i = 0; i < this.tamanho -1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if(this.tamanho > 0) {
			s.append(this.elementos[this.tamanho -1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
	
}