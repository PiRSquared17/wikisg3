package isg3.mailBox;

import java.util.Date;

public class MessageFactory {
	
	public Message createMessage(String from, String to, String subject, String content, Date date){
		Message m = new Message(from, to, subject, content, date);
		return m;
	}
}
