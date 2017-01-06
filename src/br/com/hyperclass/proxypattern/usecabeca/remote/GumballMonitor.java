package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.rmi.RemoteException;

public class GumballMonitor {
	
	private final GumnallMachineRemote machine;

	public GumballMonitor(final GumnallMachineRemote machine) {
		super();
		this.machine = machine;
	}
	
	public void report() {
		try {
			System.out.println("Gumball Machine: " + machine.getLocation());
			System.out.println("Current inventory: " + machine.getCount() + " gumballs");
			System.out.println("Current state: " + machine.getState());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
