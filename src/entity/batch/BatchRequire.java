package entity.batch;

public class BatchRequire {
	private String type;
	private int offset;
	private int count;

	/**
	 * 
	 */
	public BatchRequire() {
		super();
	}

	/**
	 * @param type
	 * @param offset
	 * @param count
	 */
	public BatchRequire(String type, int offset, int count) {
		super();
		this.type = type;
		this.offset = offset;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
