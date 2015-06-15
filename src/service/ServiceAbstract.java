package service;

import entity.InputMessage;
import entity.outputmessage.OutputMessageAbstract;

public abstract class ServiceAbstract {
	
	public abstract OutputMessageAbstract normal(InputMessage im);
	
}
