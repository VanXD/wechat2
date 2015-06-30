package service;

import entity.InputMessage;

/**
 * 注册每一个handler
 * 
 * @author VanXD
 *
 */

public class SimpleHandlerChain extends AbstractHandlerChain {
	
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
		linkHandler.setNextHandler(shortVideoHandler);
		shortVideoHandler.setNextHandler(videoHandler);
	}

	@Override
	public void process(InputMessage im) {
		entryHandler.handle(im);
	}

}
