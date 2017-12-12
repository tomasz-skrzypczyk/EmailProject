 package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

import Model.Account;
import Model.Email;
import Server.ServerInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Client extends UnicastRemoteObject implements ClientInterface {
	HashMap<Integer, Email> emailList = new HashMap<Integer, Email>();
	HashMap<Integer, String> messageList = new HashMap<Integer, String>();
	public static HashMap<String, Client> clientList = new HashMap<String, Client>();
	Account account;
	//------------------dump content-----------------------
		public static final Email email1 = new Email("Meeting","john@mail.com",LocalDate.of(2014, Month.MAY, 21),1);
		public static final Email email2 = new Email("Let's go baking","piotr@mail.com",LocalDate.of(1952, Month.OCTOBER, 21),2);
		public static final Email email3 = new Email("30% OFF this weekend","john@mail.com",LocalDate.of(2017, Month.JANUARY, 21),3);
		//----------------end-----------------------------------
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private static ServerInterface chatServer;
	

	public Client(String name, ServerInterface chatServer) throws RemoteException {
	this.setName(name);
	this.setChatServer(chatServer);
	chatServer.registerClient(name, this);
	clientList.put(name, this);
	}
	public void retrieveMessage() throws RemoteException {
		account.newMessage();	
	}
	// to do
	public String getMessage(Integer ID) throws RemoteException {
		String message = chatServer.getMessage(ID);
		//System.out.println(ID);
		return message;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ServerInterface getChatServer() {
		return chatServer;
	}
	public void setChatServer(ServerInterface chatServer) {
		Client.chatServer = chatServer;
	}
	public static Client getClient(String name) {
		System.out.println("Poproszono o klienta: " + name);
		return clientList.get(name);
	}
	public ObservableList<Email> getEmailList() throws RemoteException {
		ObservableList<Email> emailList = FXCollections.observableArrayList();
		//ObservableList<Email> emailList = chatServer.getEmailList(this);
		//final Email email1 = new Email("Meeting","john@mail.com",LocalDate.of(2014, Month.MAY, 21),1);
		//final Email email2 = new Email("Pieczenie pierników","piotr@mail.com",LocalDate.of(1952, Month.OCTOBER, 21),2);
		//final Email email3 = new Email("Zakupy","john@mail.com",LocalDate.of(2017, Month.JANUARY, 21),3);
		//emailList.addAll(email1, email2, email3);
		emailList.addAll(chatServer.getEmailList(this));
		return emailList;
	}

}
