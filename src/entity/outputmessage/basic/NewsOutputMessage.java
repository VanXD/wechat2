package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.article.WXArticles;
import entity.article.WXItem;
import entity.image.WXImage;
import entity.music.WXMusic;
import entity.outputmessage.OutputMessageAbstract;

public class NewsOutputMessage extends OutputMessageAbstract {

	private String MsgType = "news";
	private int ArticleCount;
	private WXArticles Articles;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());	 
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
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
	
	public void inject(InputMessageAbstract ima, WXItem item[]){
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setArticleCount(item.length);
		setArticles(new WXArticles(item));
	}
	
	
	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public WXArticles getArticles() {
		return Articles;
	}

	public void setArticles(WXArticles articles) {
		Articles = articles;
	}

	public NewsOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
