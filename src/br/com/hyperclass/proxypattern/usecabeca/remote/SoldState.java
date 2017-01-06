package br.com.hyperclass.proxypattern.usecabeca.remote;

public class SoldState implements State {

	private static final long serialVersionUID = -5948689485185562202L;
	
	private final GumballMachine gumballMachine;
	
	public SoldState(final GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumbal");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCranck() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getHasQuarterState());
		} else {
			System.out.println("Oops, out of gumballs");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
