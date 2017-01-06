package br.com.hyperclass.proxypattern.usecabeca.remote;

public class NoQuarterState implements State {
	
	private static final long serialVersionUID = -1362438615288490620L;
	
	transient private final GumballMachine gumballMachine;
	
	public NoQuarterState(final GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void turnCranck() {
		System.out.println("You turned, but there's no quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}
}
