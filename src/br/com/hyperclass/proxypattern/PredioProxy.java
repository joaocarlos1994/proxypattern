package br.com.hyperclass.proxypattern;

public class PredioProxy implements Acoes {
	

	@Override
	public String acessar(final Pessoa pessoa) {
		String mensagem = "Acesso negado";
		
		if(pessoa.getEstatusPessoa() == EstatusPessoa.CADASTRADA){
			Acoes acoes = new Predio();
			mensagem = acoes.acessar(pessoa);
		}	
		
		return mensagem;
	}

	
	

}
