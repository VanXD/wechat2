package service;

import entity.InputMessage;

public abstract class AbstractHandlerChain {
	protected AbstractHandler eventHandler = new EventHandler();
	protected AbstractHandler imageHandler = new ImageHandler();
	protected AbstractHandler linkHandler = new LinkHandler();
	protected AbstractHandler locationHandler = new LocationHandler();
	protected AbstractHandler shortVideoHandler = new ShortVideoHandler();
	protected AbstractHandler textHandler = new TextHandler();
	protected AbstractHandler videoHandler = new VideoHandler();
	protected AbstractHandler voiceHandler = new VoiceHandler();
	
	//链首handler
	protected AbstractHandler entryHandler;

	/**
	 * 调用链首handler
	 */
	public abstract void process(InputMessage im);

	public AbstractHandler getEntryHandler() {
		return entryHandler;
	}
	
	/**
	 * @param entryHandler
	 * 只有在自己的HandlerChain里才能设置链首 
	 */
	protected void setEntryHandler(AbstractHandler entryHandler) {
		this.entryHandler = entryHandler;
	}

}
