/**
 * 
 * @author Sergio Andres Rangel Camacho
 *
 *This class contains methods that are associated with the materials.
 *It is also the parent class of the subclasses: Roll, Plank, and Tile.
 */
public class Flooring {
	
	/**
	 * Here are the private variables
	 */
	private String type;
	private String materialName;
	private double pricePerSqInch;
	
	/**
	 * This is the constructor for the Flooring class
	 * 
	 * @param materialName  = This is the name of the material
	 * @param pricePerSqInch = This is the price of the material(per sq inch)
	 */
	public Flooring(String materialName, double pricePerSqInch) {
		this.materialName = materialName;
		this.pricePerSqInch = pricePerSqInch;
		type = "poured";
	}
	
	/**
	 * This is a getter for type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**This returns the area of the unit(floor is sold in sq inches, so by 1)
	 * 
	 * @return area of unit
	 */
	public int getUnitArea() {
		return 1;
	}
	
	/**
	 * This is a setter for type
	 * @param type
	 */
	public void setType(String newType) {
		type = newType;
	}
	
	/**
	 * This is a getter for material
	 * @return materialName
	 */
	public String getMaterial() {
		return materialName;
	}
	
	/**
	 * This getter for the price per sq inch
	 * @return pricePerSqInch
	 */
	public double getPricePerSqInch() {
		return pricePerSqInch;
	}
	
	/**
	 * This method calculates the amount of material needed by
	 * calculating the area
	 * @param length
	 * @param width
	 * @return area
	 */
	public int amountOfMaterial(int length, int width) {
		return length * width;
	}
	
	/*
	 * This method calculates the cost of the floor after material prices
	 * and markup commission costs
	 */
	public int quoteCents(int length, int width, double commission) {
		int area = amountOfMaterial(length, width) / getUnitArea();
		double estimate = (area * pricePerSqInch * (1 + commission) * 100);

		if(estimate % 1 != 0) {
			estimate = Math.ceil(estimate);
		}
		return (int)estimate;
	}
	
	/**
	 * This method takes in the number of inches and turn it into
	 *  feet in a string
	 * @param inches
	 * @return feet
	 */
	public static String toFeet(int inches) {
		String str;
		int feet = Math.round(inches/12);
		int remInches = inches % 12;
		if(feet == 0) {
			str = remInches + "''";
		}
		else if(remInches == 0) {
			str = feet + "'";

		}
		else {
			str = feet + "'" + remInches + "''";

		}
		return str;
	}
	
	/**
	 * This method calculates the amount of material that cost to waste
	 * @param length
	 * @param width
	 * @return waste
	 */
	public int unusedMaterial(int length, int width) {
		
		return 0;
	}
	
	/**
	 * This method calculates the ratio for the amount of waste
	 * @param length
	 * @param width
	 * @return wasteRatio
	 */
	public double wasteRatio(int length, int width) {
		
		double waste = unusedMaterial(length, width);
		double used = amountOfMaterial(length, width);
		double ratio = waste / used;
		return ratio;
	}
	
	/**
	 * This is the toString for the class
	 */
	public String toString() {
		String str = "Flooring-" + type + " " + materialName + " @" + pricePerSqInch + " sq. in";
		return str;
	}
	
	
}
