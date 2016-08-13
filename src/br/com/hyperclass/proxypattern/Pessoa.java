package br.com.hyperclass.proxypattern;

public class Pessoa {
	
	private final String nome;
	private EstatusPessoa estatusPessoa;

	public Pessoa(String nome, EstatusPessoa estatusPessoa) {
		super();
		this.nome = nome;
		this.estatusPessoa = estatusPessoa;
	}

	public EstatusPessoa getEstatusPessoa() {
		return estatusPessoa;
	}

	public String getNome() {
		return nome;
	}
	
	

}
