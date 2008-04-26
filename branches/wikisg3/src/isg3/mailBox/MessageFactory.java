package isg3.mailBox;

public class MessageFactory {
	
	public Message createMessage(String from, String to, String subject, String content){
		Message m = new Message(from, to, subject, content);
		return m;
	}
}
