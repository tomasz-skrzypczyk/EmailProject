package Model;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Email {
	//to-delete--

	private SimpleStringProperty topic, sender, receiver;
	private LocalDate date;
	private LocalDate deleted;
	private Integer ID;
	
	

	
	
	public Email(String topic, String sender, LocalDate created,  Integer ID) {
		super();
		this.topic = new SimpleStringProperty(topic);
		this.sender = new SimpleStringProperty(sender);
		this.date = created;
		
		this.ID = ID;
	}


	public String getTopic() {
		return topic.get();
	}



	public void setTopic(SimpleStringProperty topic) {
		this.topic = topic;
	}



	public String getSender() {
		return sender.get();
	}



	public void setSender(SimpleStringProperty sender) {
		this.sender = sender;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalDate getDeleted() {
		return deleted;
	}



	public void setDeleted(LocalDate deleted) {
		this.deleted = deleted;
	}


   



	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}


	public String getReceiver() {
		
		return receiver.get();
	}
	
	
	

}
