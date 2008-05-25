package isg3.data;

import isg3.mailBox.Message;

import java.util.Collection;

public interface IMessageDAO {

	public Collection selectAllReceived(String userOID);
	public boolean insert(Message m);
	public boolean delete(String idMessage);
	public Message select(String idMessage);
	
}
