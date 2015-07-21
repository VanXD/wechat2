package entity.db;

import java.util.Arrays;

import entity.outputmessage.mass.ArticlesMassOutputMessage;
import interfaces.EntityWrapperInterface;

public class NewsProxy extends News implements EntityWrapperInterface {
	private ArticlesMassOutputMessage[] articles;
	private Integer index;

	public ArticlesMassOutputMessage[] getArticles() {
		return articles;
	}

	public void setArticles(ArticlesMassOutputMessage[] articles) {
		this.articles = articles;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public void wrap(Object o) {
		if (o instanceof News) {
			News news = (News) o;
			setMedia_id(news.getMedia_id());
		}
	}

	@Override
	public String toString() {
		return "NewsProxy [getArticles()=" + Arrays.toString(getArticles())
				+ ", getIndex()=" + getIndex() + ", getMedia_id()="
				+ getMedia_id() + ", getTitle()=" + getTitle()
				+ ", getIntroduction()=" + getIntroduction()
				+ ", getArticle_count()=" + getArticle_count() + "]";
	}

}
