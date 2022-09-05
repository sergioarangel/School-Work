/**This class is responsible for creating a linkedgrid for the monsters to move around 
 * and dance on in 2D
 * 
 * @author Sergio Andres Rangel Camacho
 *
 * @param <T>
 */
public class LinkedGrid<T> {
	
	//Theses are the private variables
	private int width;
	private int height;
	private LinearNode<T>[] grid;
	
	//This is the constructor that put together the linked grid
	//It also initializes the width and the height
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LinkedGrid(int width, int height) {
		this.width = width;
		this.height = height;
		
		grid = new LinearNode[width];
		
		for(int i = 0; i < width; i++) {
			grid[i] = new LinearNode<T>();
			LinearNode node = grid[i];
			
			for(int n = 0; n < height; n++) {
				LinearNode spot = new LinearNode<T>();
				node.setNext(spot);
				node = node.getNext();
			}
		}
	}
	
	//This method is responsible for finding a specific node and
	//then setting the parameter data into it
	public void setElement(int col, int row, T data) throws LinkedListException{
		
		if(col >= width || col <= -1 || row >= height || row <= -1) {
			throw new LinkedListException("Out of bounds.");
		}
		
		LinearNode<T> node = grid[col];
		int rowCount = 0;
		
		while(rowCount != row) {
			node = node.getNext();
			rowCount++;
			
		}
		node.setElement(data);
		
	}
	
	//This method is responsible for finding and returning the correct node
	public LinearNode<T> getElement(int col, int row) throws LinkedListException{
		
		if(col >= width || col <= -1 || row >= height || row <= -1) {
			throw new LinkedListException("Out of bounds.");
		}
		LinearNode<T> node = grid[col];
		int rowCount = 0;
		
		while(rowCount != row) {
			node = node.getNext();
			rowCount++;
		}
		return node;

	}
	
	//This method returns the width of the grid(getter)
	public int getWidth() {
		return width;
	}
	
	//This method returns the height of the grid(getter)
	public int getHeight() {
		return height;
	}
	
	//This toString prints a 2d image of the linked grid
	//following the specific format
	public String toString() {
		String str = "";
		int level = 0;
		LinearNode node;

		for(int i = 0; i < height; i++) {
			int col = 0;
			
			if(level != 0) {
				
				while(col < width) {
					node = grid[col];
					int count = 0;

					while(count < level) {
						node = node.getNext();
						count++;
					}
					str += node.getElement() + "  ";
					col++;
				}
			}
			else {
				
				for(int y = 0; y < width; y++) {
					node = grid[y];
					str += node.getElement() + "  ";
				}
			}
			level++;
			str += "\n";
		}
		return str;
	}
}


