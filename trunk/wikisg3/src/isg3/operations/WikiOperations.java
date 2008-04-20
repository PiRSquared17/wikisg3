package isg3.operations;

import isg3.article.Article;
import isg3.article.Category;
import isg3.article.Rate;
import isg3.user.User;

import java.util.Collection;

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

}
