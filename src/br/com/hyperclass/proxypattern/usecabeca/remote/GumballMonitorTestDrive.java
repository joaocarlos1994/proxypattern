package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.rmi.Naming;

/**
 * O Padrão Proxy fornece um substituo ou represetante
 * de outro objeto para controlar o acesso a ele.
 * */
public class GumballMonitorTestDrive {

	public static void main(String[] args) {

		final String[] location = { "rmi://santafe.mightygumball.com/gumballmachine",
				"rmi://boulder.mightygumball.com/gumballmachine", "rmi://seattle.mightygumball.com/gumballmachine" };

		final GumballMonitor[] monitor = new GumballMonitor[location.length];

		for (int i = 0; i < location.length; i++) {
			try {
				final GumnallMachineRemote machine = (GumnallMachineRemote) Naming.lookup(location[i]);
				monitor[i] = new GumballMonitor(machine);
				System.out.println(monitor[i]);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		
		for (int i=0; i < monitor.length; i++) {
			monitor[i].report();
		}

	}

}
