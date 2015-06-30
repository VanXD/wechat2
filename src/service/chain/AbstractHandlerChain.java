package service.chain;

import service.AbstractHandler;
import entity.InputMessage;

public abstract class AbstractHandlerChain {
	// 链首handler
	protected AbstractHandler entryHandler;

	/**
	 * 调用链首handler
	 */
	public void process(InputMessage im) {
		entryHandler.handle(im);
	}

	public AbstractHandler getEntryHandler() {
		return entryHandler;
	}

	/**
	 * @param entryHandler
	 *            只有在自己的HandlerChain里才能设置链首
	 */
	protected void setEntryHandler(AbstractHandler entryHandler) {
		this.entryHandler = entryHandler;
	}
}
