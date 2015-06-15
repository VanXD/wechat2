package entity.article;

public class WXArticles {
	WXItem[] item;

	public WXArticles() {
	}

	public WXArticles(WXItem[] item) {
		this.item = item;
	}

	public WXItem[] getItem() {
		return item;
	}

	public void setItem(WXItem[] item) {
		this.item = item;
	}

}
