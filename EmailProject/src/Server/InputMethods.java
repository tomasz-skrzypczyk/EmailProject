package Server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputMethods {

	
	

	public static synchronized boolean egsistsLogin(String login, Server server) {
		ArrayList<String> clientList=new ArrayList<String>();
		Scanner scf = null;
		boolean esiste= false;
		try {
			scf = new Scanner(new File("logins.txt"));
			String l="";
			while (scf.hasNext()) {
				clientList.add(l= scf.next());
				if(l.equals(login)) {
					esiste= true;
				}
			}
		}catch (IOException e)
  		{System.out.println("PROBLEMA: " + e.getMessage());
 		 return false;}
		finally {if (scf!=null) //NB: se fallisce la new File lo scanner e' null
 				scf.close();}
		server.updateClients(clientList);
		return esiste;
	}
	
	//not sure if we need a logs file for ecery client
	public static void visualizzareLogs(String login) {
		Scanner scf = null;
		try {
			scf = new Scanner(new File(login+"/logs.txt"));
			String l="";
			while (scf.hasNext()) {
				l= scf.nextLine();
				System.out.println(l);
			}
		}catch (IOException e)
  		{System.out.println("PROBLEMA: " + e.getMessage());
 		 return;}
		finally {if (scf!=null) //NB: se fallisce la new File lo scanner e' null
 				scf.close();}
	}
	
	@SuppressWarnings("finally")
	public static String getMessage(Integer ID) {
		StringBuffer message = new StringBuffer("");
		Scanner scf = null;
		try {
			scf = new Scanner(new File("mail" + ID + ".txt"));
			while (scf.hasNext()) {
				message.append(scf.nextLine());
			}
		} catch (IOException e) {
			System.out.println("PROBLEMA: " + e.getMessage());
			message.append("No content: We couldn't get the Email.");
		} finally {
			if (scf != null) {
				scf.close();
			}
			return message.toString();
		}

	}

	public static void getNewID() {
		// TODO Auto-generated method stub
		
	}

}

