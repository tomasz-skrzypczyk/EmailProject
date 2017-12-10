package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import Client.ClientInterface;

public class Server extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = 1L;
	private HashMap<String,ClientInterface> chatClients;
	HashMap<Integer, String> messageList = new HashMap<Integer, String>();
	protected Server() throws RemoteException {
		chatClients = new HashMap<String, ClientInterface>();
		messageList.put(1, "Message nr 1");
		messageList.put(2, "Message nr 2");
		messageList.put(3, "Message nr 3");
	}
	public synchronized void registerChatClient(String chatClientname,ClientInterface chatClient) throws RemoteException {
		this.chatClients.put(chatClientname , chatClient);
		
	}
	public synchronized void broadcastMessage(String message) throws RemoteException {
		for(ClientInterface client : chatClients.values()) {
			client.retrieveMessage(message);
		}
	}
	@Override
	public synchronized void sendMessage(String message, String username) throws RemoteException {
		 chatClients.get(username).retrieveMessage(message);
		
	}
	@Override
	public String getMessage(Integer ID) throws RemoteException {
		//System.out.println("Message nr: " + ID);
		return messageList.get(ID);
	}
}
