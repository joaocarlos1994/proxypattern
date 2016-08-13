package br.com.hyperclass.proxypattern;

public class Main {

	public static void main(String[] args) {
		
		Pessoa pessoaCadastrada = new Pessoa("Daniel", EstatusPessoa.CADASTRADA);
		Pessoa pessoaNaoCadastrada = new Pessoa("Guilherme", EstatusPessoa.NAO_CADASTRADA);
		
		Acoes acoes = new PredioProxy();
		System.out.println(acoes.acessar(pessoaCadastrada));
		System.out.println(acoes.acessar(pessoaNaoCadastrada));

	}

}
