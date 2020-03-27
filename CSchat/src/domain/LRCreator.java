package domain;

//构造者
public class LRCreator implements RobotFactory {

	public LRCreator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LRobot createRobot() {
		// TODO Auto-generated method stub
		return new LRobot("茉莉");
	}

}
