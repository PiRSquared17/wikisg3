package isg3.data;

import isg3.article.Rate;

import java.util.Collection;

public interface IRateDAO {

	public Collection selectAll(String articleOID);
	public boolean insert(Rate r, String articleOID);
	public boolean update(Rate r, String articleOID);
	public Rate select(String articleOID, String userOID);
	
}
