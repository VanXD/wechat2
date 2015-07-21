package entity.batch;

import entity.outputmessage.mass.ArticlesMassOutputMessage;

public class BatchArticleSummary {
	private ArticlesMassOutputMessage[] news_item;

	public ArticlesMassOutputMessage[] getNews_item() {
		return news_item;
	}

	public void setNews_item(ArticlesMassOutputMessage[] news_item) {
		this.news_item = news_item;
	}
	
	
}
