package isg3.mailBox;
import java.util.*;

public class Message {
	
	private String from;
	private String to;
	private String subject;
	private String content;
	private Date date;
	private boolean isNew; 
	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
	public boolean getIsNew(){
		return isNew;
	}
	
	public Message(String from, String to, String subject, String content){
		this.from=from;
		this.to=to;
		this.subject=subject;
		this.content=content;
		date = new Date(System.currentTimeMillis());
	}
	
	
}
