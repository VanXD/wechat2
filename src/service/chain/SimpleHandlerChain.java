package service.chain;

import entity.InputMessage;

/**
 * 注册每一个handler
 * 
 * @author VanXD
 *
 */

public class SimpleHandlerChain extends AbstractNormalHandlerChain {
	
	/**
	 * 在构造器中链接handler
	 */
	public SimpleHandlerChain() {
		textHandler.setNextHandler(imageHandler);
		setEntryHandler(textHandler);
		
		imageHandler.setNextHandler(voiceHandler);
		voiceHandler.setNextHandler(eventHandler);
		eventHandler.setNextHandler(locationHandler);
		locationHandler.setNextHandler(shortVideoHandler);
		shortVideoHandler.setNextHandler(linkHandler);
		linkHandler.setNextHandler(videoHandler);
	}

}
