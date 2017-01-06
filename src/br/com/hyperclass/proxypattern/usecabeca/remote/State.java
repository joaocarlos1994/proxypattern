package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.io.Serializable;

/**
 * Padrao State permite que um objeto altere o
 * seu comportamento quando o seu estado interno
 * muda. O objeto parecera ter mudado de classe.
 * */
public interface State extends Serializable {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCranck();
	public void dispense();
}
