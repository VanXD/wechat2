package com.aliapp.wxxd.material.entity.outputmessage.mass;

public class ArticleSummary {
	private ArticlesMassOutputMessage[] articles;

	public ArticleSummary() {
	}

	public ArticleSummary(ArticlesMassOutputMessage[] articles) {
		this.articles = articles;
	}

	public ArticlesMassOutputMessage[] getArticles() {
		return articles;
	}

	public void setArticles(ArticlesMassOutputMessage[] articles) {
		this.articles = articles;
	}

}
