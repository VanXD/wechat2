package service.chain;

import service.AbstractHandler;
import service.vanxd.handler.*;

public class AbstractVanXDHandlerChain extends AbstractHandlerChain  {
	protected AbstractHandler hobbyHandler = new HobbyHandler();
	protected AbstractHandler selfPhotoHandler = new SelfPhotoHandler();
	protected AbstractHandler skillDesignPatternHandler = new SkillDesignPatternHandler();
	protected AbstractHandler skillFrontEndHandler = new SkillFrontEndHandler();
	protected AbstractHandler skillJavaHandler = new SkillJavaHandler();
}
