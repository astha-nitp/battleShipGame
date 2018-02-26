import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BattleField implements Validatable {

	private char rows;
	
	private int cols;
	
	private Map<ShipCell,Integer> ships;
	
//	private Validator validator;

//	private Ship ships;
	
	public BattleField(char rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		this.ships = new HashMap<ShipCell,Integer>();
//		this.validator = new ValidatorImpl();
//		this.ships = new Ship();
	}

	public void initializeBattleField(List<String> shipInputs){
		for(String str: shipInputs){
		 buildShips(str);
		}	
		
	}
	
//	private boolean isValidBattlefield(char row, int col) {
//		if(row >= 'A' && row<='Z'){
//			if(col >= 1 && col <= 9){
//				return true;
//			}
//			else 
//				return false;
//		}
//		 return false;
//		
//	}

	private void buildShips(String shipDetails){
		String[] shipCells = shipDetails.split(" ");
		int width = Integer.parseInt(shipCells[1]);
		int height = Integer.parseInt(shipCells[2]);

		if(shipCells[0].equalsIgnoreCase("p")){
			addShipCells(shipCells[3],width,height,ShipCell.Shiptype.P);	
		}else if(shipCells[0].equalsIgnoreCase("q")) {
			addShipCells(shipCells[3],width,height,ShipCell.Shiptype.Q);	
		}
		
	}

	private void addShipCells(String origin, int width, int height,ShipCell.Shiptype type) {
//		ships = new HashSet<ShipCell>();
		int originXCoord = origin.charAt(1)-'0';
		char originYCoord = origin.charAt(0);
		Cell cell ;
//		=  new Cell(originXCoord,originYCoord);
		for (int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				cell = new Cell(originXCoord+j,(char) (originYCoord+i));
				if(isValidCell(cell)){
				  ShipCell ship = new ShipCell(cell,type);
				  addShip(ship, type.getCounter());
				}
			}
		}

	}

	private boolean isValidCell(Cell cell) {
		if(cell.getY_Coordinate() < 'A' && cell.getY_Coordinate()>rows )
			return false;
		if(cell.getX_Coordinate() < 1 && cell.getX_Coordinate()>cols )
			return false;
		else 
			return true;
		
	}
//	
//	private boolean isWidthValid(int width){
//		if(width>1 && width<cols)
//			 return true;
//			else
//				return false;
//		
//	}
//	
//	private boolean isHeightValid(int hieght){
//		if(hieght> 'A' && hieght<rows)
//		 return true;
//		else
//			return false;
//	}
//	
	public void addShip(ShipCell ship, int count){
		ships.put(ship, count);
	}
	
	public void removeShip(ShipCell ship){
		ships.remove(ship);
	}

	public boolean hasShip(ShipCell ship){
		if(ships.containsKey(ship)){
			return true;
		}else
			return false;
		
	}
	public int getShipCount(ShipCell ship){
		
		return ships.get(ship);
	}
	public boolean hasMoreShips(){
		if(ships.size()>0){
			return true;
		}else
			return false;
	}
	
	

//	public Ship getShips() {
//		return ships;
//	}
//
//	public void setShips(Ship ships) {
//		this.ships = ships;
//	}

	public char getRows() {
		return rows;
	}

	public void setRows(char rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Map<ShipCell, Integer> getShips() {
		return ships;
	}

	public void setShips(Map<ShipCell, Integer> ships) {
		this.ships = ships;
	}

	@Override
	public boolean isValid(Validator validator) {
		// TODO Auto-generated method stub
		return validator.validate(this);
	}

	
	
	
}
