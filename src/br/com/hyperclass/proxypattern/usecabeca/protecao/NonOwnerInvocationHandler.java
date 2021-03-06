package br.com.hyperclass.proxypattern.usecabeca.protecao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

	private final PersonBean personBean;
	
	public NonOwnerInvocationHandler(final PersonBean personBean) {
		super();
		this.personBean = personBean;
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(personBean, args);
			} else if (method.getName().startsWith("setHotOrNotRating")) {
				return method.invoke(personBean, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalArgumentException();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
