package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
	void retrieveMessage(String message) throws RemoteException;

}
