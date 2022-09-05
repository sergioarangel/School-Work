/**This is a subclass of the Monster Class
 * This class is responsible for the movements of the monster "Orbin"
 * Orbin moves in the direction given until it reaches the edge assuming it is not, then
 * it goes in circles around the grid
 * 
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Orbin extends Monster{
	
	//This is the private variable
	private String dir;
	
	//This is the constructor for the Orbin class
	//It initializes the col and row using the super method
	//It also initializes the dir variable
	public Orbin(int col, int row, String monster) {
		super(col, row);
		dir = monster;
	}
	
	/**
	 * This method is responsible for making sure Orbin stays in bounds the whole time
	 * and also is responsible for Orbin's movements
	 */
	public void dance(MonsterMash obj) {
		
		if(dir == "north" && getRow() != 0 && getCol() != 0 && getRow() != 4 && getCol() != 4) {
			setRow(getRow() - 1);
		}
		else if(dir == "east" && getRow() != 0 && getCol() != 0 && getRow() != 4 && getCol() != 4) {
			setCol(getCol() + 1);
		}
		else if(dir == "south" && getRow() != 0 && getCol() != 0 && getRow() != 4 && getCol() != 4) {
			setRow(getRow() + 1);
		}
		else if(dir == "west" && getRow() != 0 && getCol() != 0 && getRow() != 4 && getCol() != 4) {
			setCol(getCol() - 1);
		}
		else if(getCol() == 0 && getRow() == 0) {
			setCol(getCol() + 1);
		}
		else if(getCol() == 0 && getRow() == 4) {
			setRow(getRow() - 1);
		}
		else if(getCol() == 4 && getRow() == 0) {
			setRow(getRow() + 1);
		}
		else if(getCol() == 4 && getRow() == 4) {
			setCol(getCol() - 1);
		}
		else if(getCol() == 0 && getRow() > 0) {
			setRow(getRow() - 1);
		}
		else if(getCol() > 0 && getRow() == 0) {
			setCol(getCol() + 1);
		}
		else if(getCol() == 4 && getRow() > 0) {
			setRow(getRow() + 1);
		}
		else if(getCol() < 4 && getRow() == 4) {
			setCol(getCol() - 1);
		}
		
	}
}
