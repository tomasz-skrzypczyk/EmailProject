package Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Email;

public class OutputMethods {
	
	public static boolean writeMessage(String message, Integer ID) {
		PrintWriter p = null;
		try {
			FileWriter f= new FileWriter(ID + ".txt", true);
			p = new PrintWriter(f);
			p.println(message);
			p.flush();
		}
		catch(IOException | RuntimeException e) {
						System.out.println(e.getMessage());
						return false;}
		finally {if (p!=null) //NB: se fallisce la new il PrintWriter e' null!!
			  		p.close();}
		return true;
	}
/*
methods to add:

	-> addEmail(Email email){
	apre il file Emails.txt dove aggiunge la mail (senza il messaggio!!)
	apre il file clientX.txt del mittente
	for(Clients client : Receivers){
	
	}
	apre il file clientX.txt di tutti i destinatari!!!!
	
	}
*/

	public static void addEmail(Email email) {
		// TODO Auto-generated method stub
		
	}	
}
