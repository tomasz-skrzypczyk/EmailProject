package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.ClientInterface;

public interface ServerInterface extends Remote {
	void registerClient(String Clientname, ClientInterface Client) throws RemoteException;
	void sendMessage(String message, String username) throws RemoteException;
	//void broadcastMessage(String message) throws RemoteException;
	String getMessage(Integer ID) throws RemoteException;
	}

