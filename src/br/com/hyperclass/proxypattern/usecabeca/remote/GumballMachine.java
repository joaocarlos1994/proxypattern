package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumnallMachineRemote {
	
	private static final long serialVersionUID = 1891726011547186728L;
	
	private final State soldOutState;
	private final State noQuarterState;
	private final State hasQuarterState;
	private final State soldState;
	private final State winnerState;
	
	private State state;
	private int count = 0;
	private final String location;
	
	public GumballMachine(final String location, final int numberGumballs) throws RemoteException {
		super();
		this.soldOutState = new SoldOutState(this);
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.winnerState = new WinnerState(this);
		this.state = soldOutState;
		this.location = location;
		this.count = numberGumballs;
		if (numberGumballs > 0)
			state = noQuarterState;
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCranck();
		state.dispense();
	}
	
	public void refill(final int numerOfGoma) {
		if (this.state instanceof SoldOutState) {
			this.count += numerOfGoma;
			setState(noQuarterState);
		} 
	}

	public void setState(final State state) {
		this.state = state;
	}
	
	protected void releaseBall() {
		System.out.println("A gumball comes a rolling out the slot...");
		if (count != 0)
			count -= 1;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public State getState() {
		return state;
	}
}
