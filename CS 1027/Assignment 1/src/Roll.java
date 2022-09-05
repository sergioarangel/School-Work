/**
 * This is a subclass of Flooring. It's purpose is to calculate flooring 
 * for the roll
 * @author Sergio Andres Rangel Camacho
 *
 */
public class Roll extends Flooring{
	/**
	 * These are the private variables
	 */
	private int rollWidthInch;
	private double rollPricePerInch;
	
	/**
	 * This is the constructor for the Roll class
	 * @param material
	 * @param rollWidthInch
	 * @param rollPricePerInch
	 */
	public Roll(String material, int rollWidthInch, double rollPricePerInch) {
		super(material, rollPricePerInch);
		this.rollWidthInch = rollWidthInch;
		super.setType("roll");
	}
	
	/**This returns the area of the unit(roll is sold in sq inches, so by 1)
	 * 
	 * @return area of unit
	 */
	public int getUnitArea() {
		return rollWidthInch;
	}
	
	/**
	 * This method overrides the Flooring method and it calculates
	 * The amount of material with the least amount of waste
	 * by checking to see if installing it width or length wise
	 */
	@Override
	public int amountOfMaterial(int length, int width) {
		int strips = (int)Math.ceil((double)width / (double)rollWidthInch);
		int stripsArea = strips * (length * (int)rollWidthInch);
		
		int strips2 = (int)Math.ceil((double)length / (double)rollWidthInch);
		int stripsArea2 = strips2 * (width * (int)rollWidthInch);
		
		if(stripsArea < stripsArea2) {
			return stripsArea;
		}
		
		else {
			return stripsArea2;
		}
	}
	
	/**
	 * This method overrides the Flooring method and it calculates the 
	 * amount of unused material
	 */
	@Override
	public int unusedMaterial(int length, int width) {
		int area = length * width;
		return amountOfMaterial(length, width) - area;
	}
	
	/*
	 * This is the Overridden toString method for the Roll class
	 */
	@Override
	public String toString() {
		String str = "Flooring-" + super.getType() + " " + super.getMaterial() + " @" + super.getPricePerSqInch() + " per inch of a 12' roll";
		return str;
	}
}
