/**
 * This is the subclass for the class Flooring
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Plank extends Flooring{

	/**
	 * These are the private variables
	 */
	private int plankLengthInch;
	private int plankWidthInch;
	private double plankPrice;
	
	/**
	 * This is the constructor for the Plank class
	 * @param material
	 * @param length
	 * @param width
	 * @param price
	 */
	public Plank(String material, int length, int width, double price) {
		super(material, price);
		plankLengthInch = length;
		plankWidthInch = width;	
		super.setType("plank");
	}
	
	/**
	 * This getter returns the area of the material(area of a plank because they are sold by the plank not perSqInch)
	 */
	@Override
	public int getUnitArea() {
		int area = plankLengthInch * plankWidthInch;
		return area;
	}
	
	
	/**
	 * This is the Overridden method from Flooring. It calculates the 
	 * amount of material needed by using the least amount by checking
	 * to install it length or width wise
	 */
	@Override
	public int amountOfMaterial(int length, int width) {
		int plankArea = plankLengthInch * plankWidthInch;
		int stripLength = length / plankLengthInch;
		int stripWidth = width / plankWidthInch;
		if(length % plankLengthInch != 0) {
			stripLength++;
		}
		
		if(width % plankWidthInch != 0) {
			stripWidth++;
		}
		int numPlanks = stripWidth * stripLength;
		
		
		
		int stripLength2 = width / plankLengthInch;
		int stripWidth2 = length / plankWidthInch;
		
		if(length % plankWidthInch != 0) {
			stripWidth2++;
		}
		
		if(width % plankLengthInch != 0) {
			stripLength2++;
		}
		
		int numPlanks2 = stripWidth2 * stripLength2;
		
		if(numPlanks < numPlanks2) {
			return numPlanks * plankArea;
		}
		
		else {
			return numPlanks2 * plankArea;
		}
			}
	
	/**
	 * This overridden method calculates the amount of material that
	 * is unused
	 */
	@Override
	public int unusedMaterial(int length, int width) {
		int area = length * width;
		return amountOfMaterial(length, width) - area;
	}
	
	/**
	 * This is the toString method for the Plank class
	 */
	public String toString() {
		return "Flooring-" + super.getType() + " " + super.getMaterial() + " @" + super.getPricePerSqInch() + " per " + super.toFeet(plankLengthInch) + " by " + plankWidthInch + "''";
	}
}