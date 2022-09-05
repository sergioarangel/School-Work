
/**
 * This is subclass of the Plank and Flooring class
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Tile extends Plank{
	
	/**
	 * This is the constructor for the Tile class
	 * @param material
	 * @param length
	 * @param price
	 */
	public Tile(String material, int length, double price) {
		super(material, length, length, price);
		super.setType("tile");
	}
	
	/**
	 * This getter returns the area of the material(area of a tile because they are sold by the tile not perSqInch)
	 */
	@Override
	public int getUnitArea() {
		return (int)super.getUnitArea();
	}
	
	/**
	 * This is the toString for the Tile class
	 */
	public String toString() {
		return "Flooring-" + super.getType() + " " + super.getMaterial() + " @" + super.getPricePerSqInch() + " per 1' by 1'";
	}
	
	
}
