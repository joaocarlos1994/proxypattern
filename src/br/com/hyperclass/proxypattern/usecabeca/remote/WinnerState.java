package br.com.hyperclass.proxypattern.usecabeca.remote;

public class WinnerState implements State {
	
	private final GumballMachine gumballMachine;
	
	public WinnerState(final GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		
	}

	@Override
	public void ejectQuarter() {
		
	}

	@Override
	public void turnCranck() {
		
	}

	@Override
	public void dispense() {
		System.out.println("You're a winner! You get two gumballs for your quarter");
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}
