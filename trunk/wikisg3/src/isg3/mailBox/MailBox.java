package isg3.mailBox;

import java.util.*;
import isg3.user.*;


public class MailBox {
	
	private LinkedList<Message> inbox;
	private User owner;
	
	
	
	public Collection<Message> getInbox() {
		return inbox;
	}
	
	public int getNumMessages(){
		return inbox.size();
	}
	
	public Message getMessage(int id){
		return inbox.get(id);

	}
	
	
	
}
