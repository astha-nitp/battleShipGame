import common.Utilities;

public class ValidatorImpl implements Validator{

	@Override
	public boolean validate(BattleField battleField) {
		if(battleField.getRows() >= 'A' && battleField.getRows()<='Z'){
			if(battleField.getCols() >= 1 && battleField.getCols() <= 9){
				return true;
			}
			else 
				return false;
		}
		 return false;
	}

	@Override
	public boolean validate(Cell cell) {
//		if(cell.getY_Coordinate() < 'A' && cell.getY_Coordinate()>battleField.getRows() )
//			return false;
//		if(cell.getX_Coordinate() < 1 && cell.getX_Coordinate()>battleField.getCols() )
//			return false;
//		else 
			return true;
	}

	@Override
	public boolean validate(Game game) {
		String[] inputs = game.getInputs();
		String fieldsize = inputs[0];
		String[] dimensions = fieldsize.split(" ");
		String rows = dimensions[1];
		int cols = Integer.parseInt(dimensions[0]);
		int noOfships = Integer.parseInt(inputs[1]);
		int rowInInt = Utilities.convertLetterToInt(rows);
		if(noOfships <= (cols*rowInInt) && noOfships>=1)
			return true;
		return false;
		
	}

	
}
