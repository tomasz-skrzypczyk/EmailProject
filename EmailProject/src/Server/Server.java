package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import Client.ClientInterface;

public class Server extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = 1L;
	private HashMap<String,ClientInterface> onlineClients= new HashMap<String, ClientInterface>();
	private ArrayList<String> clients = new ArrayList<String>();
	private HashMap<Integer, String> messageList = new HashMap<Integer, String>();
	
	
	protected Server() throws RemoteException {
		super();
	}
	
	public synchronized void updateMessageList(Integer ID,String message) {
		messageList.put(ID, message);
		}
	
	public synchronized void updateClients(ArrayList<String> newClients) {
	clients.addAll(newClients);
	}
	
	public boolean egsistsLogin(String name){
		if(clients.contains(name)) {return true;}
		else {return OutputMethods.egsistsLogin(name,this);}
		}
	
	public synchronized void registerClient(String clientname,ClientInterface client) throws RemoteException {
		if(egsistsLogin(clientname)) {
		this.onlineClients.put(clientname , client);
		} else {
			//raiseError!!!
		}
		
	}
	/*
	public synchronized void broadcastMessage(String message) throws RemoteException {
		for(ClientInterface client : onlineClients.values()) {
			client.retrieveMessage(message);
		}
	}
	*/
	@Override
	public synchronized void sendMessage(String message, String username) throws RemoteException {
		 onlineClients.get(username).retrieveMessage(message);
		
	}
	@Override
	public String getMessage(Integer ID) throws RemoteException {
		if(messageList.containsKey(ID)) {
		return messageList.get(ID);
		} else {
			return OutputMethods.getMessage(ID);
		}
	}
}
