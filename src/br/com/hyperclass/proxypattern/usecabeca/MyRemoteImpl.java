package br.com.hyperclass.proxypattern.usecabeca;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	private static final long serialVersionUID = 1L;

	public MyRemoteImpl() throws RemoteException {}

	@Override
	public String sayHello() {
		return "Server diz, 'Heys'";
	}
	
	public static void main(final String[] args) {
		
		try {
			
			final MyRemote myRemote = new MyRemoteImpl();
			final MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(myRemote, 0);
			
			final Registry registry = LocateRegistry.getRegistry();
			
			registry.bind("RemoteHello", stub);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
