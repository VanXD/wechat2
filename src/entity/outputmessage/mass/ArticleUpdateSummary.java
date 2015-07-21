package entity.outputmessage.mass;

import entity.db.NewsProxy;
import interfaces.EntityWrapperInterface;

public class ArticleUpdateSummary implements EntityWrapperInterface {
	private String media_id;
	private int index;
	private ArticlesMassOutputMessage articles;

	/**
	 * @param media_id
	 * @param index
	 * @param articles
	 */
	public ArticleUpdateSummary(String media_id, int index,
			ArticlesMassOutputMessage articles) {
		super();
		this.media_id = media_id;
		this.index = index;
		this.articles = articles;
	}

	/**
	 * 
	 */
	public ArticleUpdateSummary() {
		super();
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArticlesMassOutputMessage getArticles() {
		return articles;
	}

	public void setArticles(ArticlesMassOutputMessage articles) {
		this.articles = articles;
	}

	@Override
	public void wrap(Object o) {
		if (o instanceof NewsProxy) {
			NewsProxy newsProxy = (NewsProxy) o;
			setArticles(newsProxy.getArticles()[0]);
			setIndex(newsProxy.getIndex());
			setMedia_id(newsProxy.getMedia_id());
		}
	}

}
