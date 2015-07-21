package entity.batch;

public abstract class BatchGetAbstract {
	protected int total_count;
	protected int item_count;
	protected BatchItem[] item;

	/**
	 * 
	 */
	public BatchGetAbstract() {
		super();
	}

	/**
	 * @param total_count
	 * @param item_count
	 * @param item
	 */
	public BatchGetAbstract(int total_count, int item_count, BatchItem[] item) {
		super();
		this.total_count = total_count;
		this.item_count = item_count;
		this.item = item;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public BatchItem[] getItem() {
		return item;
	}

	public void setItem(BatchItem[] item) {
		this.item = item;
	}

}
