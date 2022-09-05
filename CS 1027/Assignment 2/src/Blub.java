/**This class is responsible for the "Blub" monster.
 * his/her movements are that it moves either vertically or horizontally.
 * This class is also a subclass of the Monster class
 * 
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Blub extends Monster{
	
	//Theses are the private variables
	private String axis;
	private int dir;
	
	//This is the constructor that initializes the axis and dir.
	//It also initializes the col and row by calling the super method
	public Blub(int col, int row, String monster) {
		super(col, row);
		axis = monster;
		dir = 1;
	}
	
	//This method moves the monster in its assigned spots while checking to see 
	//if it stay in bounds
	//If the input is vertical it moves down first
	//If the input is horizontal it moves right first
	public void dance(MonsterMash object) {
		if(axis == "vertical" && dir == 1 && getRow() != 4) {
			setRow(getRow() + 1);
			dir = -1;
		}

		else if(axis == "vertical" && dir == -1) {
			setRow(getRow() - 1);
			dir = 1;
		}
		
		else if (axis == "horizontal" && getCol() != 0 && dir == 1) {
			setCol(getCol() + 1);
			dir = -1;
		}
		
		else if(axis == "horizontal" && dir == -1) {
			setCol(getCol() - 1);
			dir = 1;
		}
		}
}
