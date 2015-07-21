package entity.batch;

import java.util.Arrays;

public class BatchSummary extends BatchGetAbstract {

	/**
	 * 
	 */
	public BatchSummary() {
		super();
	}

	/**
	 * @param total_count
	 * @param item_count
	 * @param item
	 */
	public BatchSummary(int total_count, int item_count, BatchItem[] item) {
		super(total_count, item_count, item);
	}

	@Override
	public String toString() {
		return "BatchSummary [total_count=" + total_count + ", item_count="
				+ item_count + ", item=" + Arrays.toString(item)
				+ ", getTotal_count()=" + getTotal_count()
				+ ", getItem_count()=" + getItem_count() + ", getItem()="
				+ Arrays.toString(getItem()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
