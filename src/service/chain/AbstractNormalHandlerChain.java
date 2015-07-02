package service.chain;

import service.*;
import service.common.EventHandler;
import service.common.ImageHandler;
import service.common.LinkHandler;
import service.common.LocationHandler;
import service.common.ShortVideoHandler;
import service.common.TextHandler;
import service.common.VideoHandler;
import service.common.VoiceHandler;

public abstract class AbstractNormalHandlerChain extends AbstractHandlerChain {
	protected AbstractHandler eventHandler = new EventHandler();
	protected AbstractHandler imageHandler = new ImageHandler();
	protected AbstractHandler linkHandler = new LinkHandler();
	protected AbstractHandler locationHandler = new LocationHandler();
	protected AbstractHandler shortVideoHandler = new ShortVideoHandler();
	protected AbstractHandler textHandler = new TextHandler();
	protected AbstractHandler videoHandler = new VideoHandler();
	protected AbstractHandler voiceHandler = new VoiceHandler();

}
