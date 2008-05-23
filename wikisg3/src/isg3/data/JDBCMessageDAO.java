package isg3.data;

import isg3.mailBox.Message;

import java.sql.Connection;
import java.util.Collection;

public class JDBCMessageDAO implements IMessageDAO {
	
	private Connection conn;
	
	//pensar si de verdad necesita tener un dao de user
	
	public JDBCMessageDAO(){
		conn = ConnectionManager.getInstance().checkOut();
	}
	
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Message m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection selectAllReceived(String userOID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAllSent(String userOID) {
		// TODO Auto-generated method stub
		return null;
	}

}
