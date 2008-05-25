package isg3.data;

import isg3.mailBox.Message;

import java.sql.Connection;
import java.util.Collection;

import isg3.article.Article;
import isg3.mailBox.Message;
import isg3.utils.UIDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class JDBCMessageDAO implements IMessageDAO {
	
	private Connection conn;
	
	//pensar si de verdad necesita tener un dao de user
	
	public JDBCMessageDAO(){
		conn = ConnectionManager.getInstance().checkOut();
	}
	
	public void finalize(){
		ConnectionManager.getInstance().checkIn(conn);
	}
	
	@Override
	public boolean delete(String idMessage) { //Que Date importar
		boolean b = false;
		
		PreparedStatement stmt = null;
		String query = "DELETE FROM Message WHERE (oid = ?)";
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, idMessage);
			int aux = stmt.executeUpdate();
			b = (aux >= 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } 
            catch (SQLException e) {
            }
		}
		
		return b;
	}

	@Override
	public boolean insert(Message m) {
		boolean b = false;
		
		String mes_oid = UIDGenerator.getInstance().getKey();
		String send_oid = this.getOidOfUser(m.getFrom());
		String receiver_oid = this.getOidOfUser(m.getTo());
		
		PreparedStatement stmt = null;
		String query = "INSERT INTO Message(oid, senderUserOID, receiverUserOID, subject, content, dateSend) VALUES(?, ?, ?, ?, ?, NOW())";
		try{
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, mes_oid);
			stmt.setString(2, send_oid);
			stmt.setString(3, receiver_oid);
			stmt.setString(4, m.getSubject());
			stmt.setString(5, m.getContent());
			int aux = stmt.executeUpdate();
			b = (aux == 1);
			//stmt.setString(6, "NOW()");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	private String getOidOfUser(String nick){
		String s = null;
		
		ResultSet results = null;
		PreparedStatement stmt = null;
		String query = "SELECT oid FROM User WHERE (nick = ?)";
		
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, nick);
			results = stmt.executeQuery();
			if (results.next()){
				s = results.getString("oid");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            	}
            	catch (SQLException e) {
            	}
        }
		return s;
	}

	@Override
	public Collection selectAllReceived(String nick) {
		// TODO Auto-generated method stub
		Collection c = null;
		ResultSet s1 = null;
		PreparedStatement stmt = null;
		String userOID = this.getOidOfUser(nick);
		String query = "SELECT * FROM Message WHERE (receiverUserOID = ?)";
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, userOID);
			s1 = stmt.executeQuery();
			c = new LinkedList();
			while(s1.next()){
				//creamos mensajes
				String from = s1.getString("senderUserOID");
				String to = s1.getString("receiverUserOID");
				String subject = s1.getString("subject");
				String content = s1.getString("content");
				java.sql.Date d = s1.getDate("dateSend");
				Date date = new Date(d.getTime());
				Message m = new Message(from,to,subject,content,date);
				String id = s1.getString("oid");
				m.setIdMessage(id);
				c.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public Message select(String idMessage){
		ResultSet s1 = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Message WHERE (oid = ?)";
		Message m = null;
		try{
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, idMessage);
			s1 = stmt.executeQuery();
			if (s1.next()){
				String from = s1.getString("senderUserOID");
				String to = s1.getString("receiverUserOID");
				String subject = s1.getString("subject");
				String content = s1.getString("content");
				java.sql.Date d = s1.getDate("dateSend");
				Date date = new Date(d.getTime());
				m = new Message(from,to,subject,content,date);
				m.setIdMessage(idMessage);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return m;
	}

}