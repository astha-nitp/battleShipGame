import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class Game implements Validatable {

	public static final int HIT = 1;
    public static final int MISS = 0;
	private Player active;
	private BattleField bf1;
	private BattleField bf2;
	private Player opponent;
	private String[] inputs;
	
	public void initializeGame(){
//		int returnCode = 1;
//		if(isValid(validator)){
		  String fieldsize = inputs[0];
		  buildBattleField(fieldsize);
		  active = new Player("Player-1",bf1);
		  opponent = new Player("Player-2",bf2);
		  prepareShipInputsforPlayers(inputs);
		  initializeTargetMissilesForPlayers(inputs);
//		}
//		else{
//			System.out.println("Invalid no. of battle ships.");
//			returnCode = -1;
//		}
//		if(returnCode == -1){
//			System.out.println("Inputs invalid...Kindly check the input file.");
//			return;
//		}
//		
		startGame();
		
	}
	
	
	private void initializeTargetMissilesForPlayers(String[] inputs) {
		int noOfships = Integer.parseInt(inputs[1]);
		String player1Target = inputs[noOfships+2];
		String player2Target = inputs[noOfships+3];
		active.populateTargetList(player1Target);
		opponent.populateTargetList(player2Target);
	}


	private void startGame(){
   
	  while(true){	
		if(opponent.getBattleField().hasMoreShips()){
		int result = chanceToPlay();
		switchTurn(result);
	    }else{
	    	System.out.println(active.getName() +" won the battle");
	    	break;
	    }
	  }		
	}
	
	private int chanceToPlay(){
		ShipCell ship = active.getTargetList().poll();
		int result = MISS;
		if(ship==null){
		  System.out.println(active.getName() +" has no more missiles left to launch");
		}else{
		  result = attack(ship,opponent.getBattleField());
		}
		return result;
	}

	private int attack(ShipCell ship, BattleField bf){
	    
	    	if(bf.hasShip(ship))
	    	{   
	    		int count = bf.getShipCount(ship);
	    		  count--;
	    		  if(count<=0){
	    			  bf.removeShip(ship); 
	    		  }else{
	    			  bf.addShip(ship, count);
	    		  }
	    		  System.out.println(active.getName()+ " fires a missile with target "+ship.getCellNo().getCellName()+" which got hit");
	    		  return HIT;

	    	}
	    	else{
	    		System.out.println(active.getName()+ " fires a missile with target "+ship.getCellNo().getCellName()+" which got miss");
	    		return MISS;
	    	}
	    	
	    }
	private void switchTurn(int result){
//        int result = p.attack(opposite.getBattleField());
        Player temp = active;
    	if(result == MISS){
    	  active = opponent;
    	  opponent = temp; 
    	}
    
    }
 
    private void buildBattleField(String fieldsize) {
    	String[] dimensions = fieldsize.split(" ");
		char rows = dimensions[1].charAt(0);
		int cols = Integer.parseInt(dimensions[0]);
		 bf1 = new BattleField(rows, cols);
		 bf2 = new BattleField(rows, cols);
	}


	private void prepareShipInputsforPlayers(String[] inputs) {
		
		int noOfships = Integer.parseInt(inputs[1]);
		List<String> shipDetailsForP1 = new ArrayList<String>();
		List<String> shipDetailsForP2 = new ArrayList<String>();
		int k =noOfships+2;
		for(int i = 2;i<k;i++){
			String str = inputs[i];
			StringBuffer sb1 = new StringBuffer(str);
			sb1.delete(8,11);
			StringBuffer sb2 = new StringBuffer(str);
			sb2.delete(5,8);
			String shipsForPlayer1 = sb1.toString();
			String shipsForPlayer2 = sb2.toString();
			shipDetailsForP1.add(shipsForPlayer1);
			shipDetailsForP2.add(shipsForPlayer2);

		}
		active.getBattleField().initializeBattleField(shipDetailsForP1);
		opponent.getBattleField().initializeBattleField(shipDetailsForP2);
		
	}

//	public boolean isNoOfShipsValid(String[] inputs){
//		String fieldsize = inputs[0];
//		String[] dimensions = fieldsize.split(" ");
//		String rows = dimensions[1];
//		int cols = Integer.parseInt(dimensions[0]);
//		int noOfships = Integer.parseInt(inputs[1]);
//		int rowInInt = Utilities.convertLetterToInt(rows);
//		if(noOfships <= (cols*rowInInt) && noOfships>=1)
//			return true;
//		return false;
//		
//	}


	public String[] getInputs() {
		return inputs;
	}


	public void setInputs(String[] inputs) {
		this.inputs = inputs;
	}


	@Override
	public boolean isValid(Validator validator) {
		
		return validator.validate(this);
	}

}
