package br.com.hyperclass.proxypattern;

public class Predio  implements Acoes {

	@Override
	public String acessar(Pessoa pessoa) {
		String acesso = "Acesso permetido " + pessoa.getNome();
		// TODO Auto-generated method stub
		return acesso;
	}


}
