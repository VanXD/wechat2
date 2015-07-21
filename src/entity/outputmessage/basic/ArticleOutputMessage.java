package entity.outputmessage.basic;

import java.util.List;

import entity.InputMessageAbstract;
import entity.article.WXItem;
import entity.outputmessage.OutputMessageAbstract;

public class ArticleOutputMessage extends OutputMessageAbstract {

	private String MsgType = "news";
	private int ArticleCount;
	private List<WXItem> Articles;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
	}

	@Override
	public void inject(InputMessageAbstract ima, String ThumbMediaIdStr,
			String Title, String MusicUrl) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setArticleCount(0);
		setArticles(null);
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<WXItem> getArticles() {
		return Articles;
	}

	public void setArticles(List<WXItem> articles) {
		Articles = articles;
	}

	public ArticleOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	/**
	 * @param articleCount
	 * @param articles
	 */
	public ArticleOutputMessage(int articleCount, List<WXItem> articles) {
		super();
		ArticleCount = articleCount;
		Articles = articles;
	}

}
