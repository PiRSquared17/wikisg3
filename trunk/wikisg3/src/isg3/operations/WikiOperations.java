package isg3.operations;

import isg3.article.*;
import isg3.user.User;

import java.util.Collection;
import java.util.Iterator;

public class WikiOperations implements IWikiOperations {

	@Override
	public void addArticle(User author, String title, String content,
			Category cat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRate(Rate rate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editArticle(User editor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsArticle(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsRate(User user, Article art) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection getArticles(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Collection getMostRatedArticles(){
		//Provisional, implementar luego.
		return Wiki.getInstance().getListArt();
	}
	
	public Article getArticle(String oid){
		Collection arts = Wiki.getInstance().getListArt();
		Article art = null;
		Iterator it = arts.iterator();
		
		while(it.hasNext()){
			Article aux = (Article)it.next();
			if (aux.getOID().equals(oid)){
				art = aux;;
			}
		}
		
		return art;
	}

}
