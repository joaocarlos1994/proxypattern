package br.com.hyperclass.proxypattern.usecabeca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteCliente {
	public static void main(String[] args) {
		new MyRemoteCliente().go();
	}
	
	public void go() {
		try {
			final Registry registry = LocateRegistry.getRegistry("rmi://127.0.0.1/");
			final MyRemote stub = (MyRemote) registry.lookup("RemoteHello");
			final String response = stub.sayHello();
			//final MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			//final String  response = service.sayHello();
            System.out.println("response: " + response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
