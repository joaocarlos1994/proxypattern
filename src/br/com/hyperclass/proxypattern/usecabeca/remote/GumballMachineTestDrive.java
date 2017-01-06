package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.rmi.Naming;

public class GumballMachineTestDrive {

	public static void main(String[] args) throws Exception {
		
		final GumballMachine gumballMachine = new GumballMachine("SAO PAULO", 10);
		
		//System.out.println(gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		System.out.println();
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		System.out.println();
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		////////////////////// PROXY REMOTE //////////////////////
		
		Naming.rebind("//" + gumballMachine.getLocation() + "\'gumballmachine", gumballMachine);
		
		
	}

}
