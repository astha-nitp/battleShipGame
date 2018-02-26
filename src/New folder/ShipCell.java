
public class ShipCell {
	
 private Shiptype type;
 
 private Cell cellNo;
 
 private int count;
 
 
 
 public ShipCell(Cell cellNo,Shiptype type) {
	this.cellNo = cellNo;
	this.type = type;
	count = type.getCounter();
}


public ShipCell(Cell cell) {
	this.cellNo = cell;
}

public void decrementCount(){
	count--;
}

//private void setCount(){
//	
//} 

public enum Shiptype{
	 P(1),Q(2);
	 
	 private int counter;
	 Shiptype(int counter){
		this.counter = counter; 
	 }
	 
	 public int getCounter(){
		 return this.counter;
	 }
 }

public Shiptype getType() {
	return type;
}

public void setType(Shiptype type) {
	this.type = type;
}

public Cell getCellNo() {
	return cellNo;
}

public void setCellNo(Cell cellNo) {
	this.cellNo = cellNo;
}


public int getCount() {
	return count;
}


public void setCount(int count) {
	this.count = count;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ShipCell other = (ShipCell) obj;
	if (cellNo == null) {
		if (other.cellNo != null)
			return false;
	} else if (!cellNo.getCellName().equals(other.cellNo.getCellName()))
		return false;
	return true;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cellNo.getCellName() == null) ? 0 : cellNo.getCellName().hashCode());
	return result;
}
 
}
