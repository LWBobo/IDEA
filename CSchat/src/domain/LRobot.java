package domain;
//具体产品

import server.HttpMoLiRobotRequest;

/**
 * @author 情空明月
 *
 */
public class LRobot extends Robot {

	protected HttpMoLiRobotRequest Moli;
	protected String BackMess;
	public LRobot(String robotType) {
		super(robotType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Robot() {
		// TODO Auto-generated method stub
		Moli = new HttpMoLiRobotRequest();
		
	}
	public String GetMess() {
		return BackMess;
		
	}
	public void SendMess(String mess)
	{
		BackMess = Moli.sendMess(mess);
	}
	
	
	


}
