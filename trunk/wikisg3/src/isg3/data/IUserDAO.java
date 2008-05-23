package isg3.data;

import java.util.Collection;

import isg3.user.User;

public interface IUserDAO {

	public Collection selectAllEditors(String art_oid);
	public boolean insert(User u);
	public boolean update(User u);
	public boolean delete(String nick);
	public Collection selectAllArticles(String nick);
	public User select(String nick);
	
}
