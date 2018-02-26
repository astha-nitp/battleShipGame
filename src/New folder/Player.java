import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Player {

	private String name;
	
	private BattleField battleField;
	
//	private String missileInput;
	
	private Queue<ShipCell> targetList ;
	
	public Player(String name, BattleField battleField) {
		this.name = name;
		this.battleField = battleField;
	}

	public void populateTargetList(String missile){
		String[] missileList = missile.split(" ");
		Queue<ShipCell> targetList = new LinkedList<ShipCell>();
		for(String s: missileList){
			int x = s.charAt(1) -'0';
			Cell cell = new Cell(x,s.charAt(0));
			ShipCell ship = new ShipCell(cell);
			targetList.add(ship);	
		}
		
		this.setTargetList(targetList);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}

//	public String getMissileInput() {
//		return missileInput;
//	}
//
//	public void setMissileInput(String missileInput) {
//		this.missileInput = missileInput;
//	}

	public Queue<ShipCell> getTargetList() {
		return targetList;
	}

	public void setTargetList(Queue<ShipCell> targetList) {
		this.targetList = targetList;
	}

	
	
	
	
}
