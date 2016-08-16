package br.com.hyperclass.proxypattern;

public class Pessoa {
	
	private final String nome;
	private StatusPessoa statusPessoa;

	public Pessoa(String nome, StatusPessoa estatusPessoa) {
		super();
		this.nome = nome;
		this.statusPessoa = estatusPessoa;
	}

	public StatusPessoa getEstatusPessoa() {
		return statusPessoa;
	}

	public String getNome() {
		return nome;
	}
	
	

}
