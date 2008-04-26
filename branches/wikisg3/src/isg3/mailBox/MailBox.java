package isg3.mailBox;

import java.util.*;
import isg3.user.*;


public class MailBox {
	
	private LinkedList<Message> outbox;
	private LinkedList<Message> inbox;
	private User owner;
	
	
	
	public Collection<Message> getOutbox() {
		return outbox;
	}
	
	public Collection<Message> getInbox() {
		return inbox;
	}
	
	public int getNumMessages(){
		return inbox.size();
	}
	
	public Message getMessage(int id){
		return inbox.get(id);

	}
	
	public Collection getNewMessages(){
		Collection col = new ArrayList(); 
		Iterator it = inbox.iterator();
		boolean stop = false;
		while(it.hasNext() && !stop){
			Message m = (Message)it.next();
			if (m.getIsNew()){
				col.add(m);
			}else{
				stop = true;
			}
		}
		return col;
	}
	
	
	
}
