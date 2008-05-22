package isg3.data;

import isg3.mailBox.Message;

import java.util.Collection;

public interface IMessageDAO {

	public Collection selectAllSent(String userOID);
	public Collection selectAllReceived(String userOID);
	public boolean insert(Message m);
	public boolean delete();
	
}
