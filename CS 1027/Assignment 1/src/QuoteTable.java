/**
 * This class takes in all of the values of the classes
 * to then compare and show them to the contractor for prices and
 * material amounts
 * @author Sergio Rangel Camacho
 *
 */
public class QuoteTable {
	
	/**
	 * These are the private variables
	 */
	private Flooring[] option;
	private int lengthInch;
	private int widthInch;
	private double markup;
	
	/**
	 * This is the constructor for the QuoteTable class
	 * @param option
	 * @param length
	 * @param width
	 * @param commission
	 */
	public QuoteTable(Flooring[] option, int length, int width, double commission) {
		this.option = option;
		lengthInch = length;
		widthInch = width;
		markup = commission;
	}
	
	/**
	 * A setter to input a new flooring option
	 * @param option
	 */
	public void setOptions(Flooring[] option) {
		this.option = option;
	}
	
	/**
	 * A setter that set the length
	 * @param length
	 */
	public void setLength(int length) {
		lengthInch = length;
	}
	
	/**
	 * A setter that sets the width
	 * @param width
	 */
	public void setWidth(int width) {
		widthInch = width;
	}
	
	/**
	 * A setter that sets the markup commission
	 * @param commission
	 */
	public void setMarkup(double commission) {
		markup = commission;
	}
	
	/**
	 * This method compares all of the options given and returns the 
	 * cheapest flooring
	 * @return cheapest flooring
	 */
	public int getCheapestValue() {
		int counter = 0;
		int cheapestValue = option[counter].quoteCents(lengthInch, widthInch, markup);
		int cheap = 0;
		while(counter != option.length) {
			cheap = option[counter].quoteCents(lengthInch, widthInch, markup);
			if(cheap < cheapestValue) {
				cheapestValue = cheap;
			}
			
			counter++;
		}
		
		return cheapestValue;
	}
	
	/**
	 * This method returns the cleanest floor option according to the
	 * amount of unused material it uses
	 * @return cleanest flooring
	 */
	public double getCleanestValue() {
		int counter = 0;
		double cleanest = 1;
		double type = 0;
		
		while(counter != option.length) {
			type = option[counter].wasteRatio(lengthInch, widthInch);
			if(type < cleanest) {
				cleanest = type;
			}
			counter++;
		}
		
		return cleanest;
		

	}
	
	//THIS CLASS WAS PROVIDED
	private static String displayHundredths(int hundredths) {
		return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
	}

	//THIS CLASS WAS PROVIDED
	public String display() {
		String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";
        
        int cheapestValue = getCheapestValue();
        double cleanestValue = getCleanestValue();
		
		out += "Material\tWaste\tCost\n";
		out += "--------\t-----\t----\n";
		for (int i = 0; i < option.length; i++) {
			double waste = option[i].wasteRatio(lengthInch, widthInch);
			int cost = option[i].quoteCents(lengthInch, widthInch, markup);

			out += option[i].getType() + "-";
			out += option[i].getMaterial() + "\t";
			out += displayHundredths((int) (10000 * waste)) + "%\t";
			out += "$" + displayHundredths(cost);
			if (waste == cleanestValue)
				out += " Eco";
			if (cost == cheapestValue)
				out += " $$";
			out += "\n";
		}
		return out;
	}
}
