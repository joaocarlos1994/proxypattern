package br.com.hyperclass.proxypattern;

public class Main {

	public static void main(String[] args) {
		
		Pessoa pessoaCadastrada = new Pessoa("Daniel", StatusPessoa.CADASTRADA);
		Pessoa pessoaNaoCadastrada = new Pessoa("Guilherme", StatusPessoa.NAO_CADASTRADA);
		
		Acoes acoes = new PredioProxy();
		System.out.println(acoes.acessar(pessoaCadastrada));
		System.out.println(acoes.acessar(pessoaNaoCadastrada));

	}

}
