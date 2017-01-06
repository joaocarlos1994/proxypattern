package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.util.Random;

public class HasQuarterState implements State {

	private static final long serialVersionUID = 1739439996978482935L;
	
	transient private final GumballMachine gumballMachine;
	private final Random random = new Random(System.currentTimeMillis());
	
	public HasQuarterState(final GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCranck() {
		System.out.println("You turned...");
		final int winner = random.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
}
