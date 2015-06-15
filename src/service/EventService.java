package service;

import entity.InputMessage;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;


public class EventService extends ServiceAbstract{
	
	@Override
	public OutputMessageAbstract normal(InputMessage im){
		OutputMessageAbstract oma = new TextOutputMessage();
		oma.inject(im, "关注成功");
		return oma;
	}
	
}
