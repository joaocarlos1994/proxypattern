package br.com.hyperclass.proxypattern.usecabeca.protecao;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * A linguagem java implementa seus proprios recursos no
 * pacote java.lang.reflect. Esse pacote permite que voce
 * implemente uma classe de proxy instantanea que implementa
 * uma ou mais interfaces e encaminha as chamadas de metodos
 * para outra classe especificada por voce.
 * */
public class Main {
	
	private final Map<String, PersonBean> personDataBae;

	public Main() {
		super();
		this.personDataBae = new WeakHashMap<>();
		personDataBae.put("Joe Javabean", new PersonBeanImpl("Joe Javabean", "aaa", "female", 0));
	}

	public static void main(String[] args) {
		final Main main = new Main();
		main.drive();
	}
	
	public void drive() {
		final PersonBean joe = getPersonFromDatabase("Joe Javabean");
		final PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling Go");
		
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
		
		final PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}

	/**
	 * Este metodo recebe um objeto de pessoa (o objeto real) e
	 * retorna o proxy adequado para ele. Como proxy e o objeto
	 * final possuem a mesma interface, retornamos um PersonBean.
	 * 
	 * Para criar um proxy usando o method newProxyInstance,
	 * passamos a ele o carregador de classes correspondente ao
	 * nosso objeto de destino e o conjunto de interfaces que o
	 * proxy deve implementar.
	 * 
	 * Passamos o objeto de destino real no construtor no
	 * processador de chamadas.
	 * */
	public PersonBean getOwnerProxy(final PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), 
									  person.getClass().getInterfaces(),
									  new OwnerInvocationHandler(person));
	}
	
	public PersonBean getNonOwnerProxy(final PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), 
									  person.getClass().getInterfaces(),
									  new NonOwnerInvocationHandler(person));
	}
	
	private PersonBean getPersonFromDatabase(final String string) {
		final PersonBean person = personDataBae.get(string);
		return person;
	}
}
