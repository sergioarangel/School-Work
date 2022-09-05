/**This is another subclass of the Monster class
 * It is responsible for the way the "Grink" monster moves
 * The Grink monster will move according to the string array
 * that is given. It moves 4 different ways:
 * North, East, South, and West
 * 
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Grink extends Monster{
	
	//Theses are the private variables
	private LinearNode<String> actions;
	private LinearNode<String> currAction;
	
	//This is the constructor for the Grink class
	//It calls the super method and initializes the col and row parameters
	//If the string array monster is not empty it will create a linked list for it
	public Grink(int col, int row, String[] Monster) {
		super(col, row);
		
		if(Monster != null) {
			createActionList(Monster);
		}
	}
	
	/**This method is responsible for creating a linked list for the monster
	 * string array
	 * 
	 * @param dance
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createActionList(String[] dance) {
		actions = new LinearNode();
		LinearNode<String> node = actions;
		currAction = node;
		for(int i = 0; i < dance.length; i++) {
			LinearNode spot = new LinearNode<String>();
			node.setElement(dance[i]);
			node.setNext(spot);
			node = node.getNext();
		}
		
	}
	
	//This method returns the actions variable(getter)
	public LinearNode<String> getActions(){		
		return actions;
	}
	
	/**
	 * This method is responsible for Grink's movements.
	 * It will make sure the monster stays in bounds and
	 * will move the monster according to the linked list that is given
	 */
	public void dance(MonsterMash obj) {
		if(currAction.getElement() == "repeat") {
			currAction = actions;
		}
		if(currAction.getElement() == "north" && getRow() != 0) {
			setRow(getRow() - 1);
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "east" && getCol() != 4) {
			setCol(getCol() + 1);
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "south" && getRow() != 4) {
			setRow(getRow() + 1);
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "west" && getCol() != 0) {
			setCol(getCol() - 1);
			currAction = currAction.getNext();
		}	
		else if(currAction.getElement() == "north" && getRow() == 0) {
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "east" && getCol() == 4) {
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "south" && getRow() == 4) {
			currAction = currAction.getNext();
		}
		else if(currAction.getElement() == "west" && getCol() == 0) {
			currAction = currAction.getNext();
		}
	}
}
