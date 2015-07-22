package entity.batch;

/**
 * 获取永久素材列表的请求实体
 * 
 * @author VanXD
 *
 */
public class BatchRequire {
	private String type;
	private Integer offset;
	private Integer count;

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
	public BatchRequire(String type, Integer offset, Integer count) {
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

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BatchRequire [type=" + type + ", offset=" + offset + ", count="
				+ count + "]";
	}

}
