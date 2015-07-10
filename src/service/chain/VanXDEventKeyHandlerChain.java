package service.chain;

public class VanXDEventKeyHandlerChain extends AbstractVanXDHandlerChain{
	
	public VanXDEventKeyHandlerChain() {
		skillJavaHandler.setNextHandler(skillFrontEndHandler);
		setEntryHandler(skillJavaHandler);
		
		skillFrontEndHandler.setNextHandler(skillDesignPatternHandler);
		skillDesignPatternHandler.setNextHandler(selfPhotoHandler);
		selfPhotoHandler.setNextHandler(hobbyHandler);;
	}
}
		