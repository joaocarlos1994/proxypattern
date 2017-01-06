package br.com.hyperclass.proxypattern.usecabeca.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumnallMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}
