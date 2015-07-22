package util.ienum;

public enum WeChatGlobalResponse {
	MAX_API_DAILY_QUOTA("45009");
	
	
	private String globalResponse="";

	private WeChatGlobalResponse(String globalResponse) {
		this.globalResponse = globalResponse;
	}
	
	@Override
	public String toString() {
		return globalResponse.toString();
	}
}
