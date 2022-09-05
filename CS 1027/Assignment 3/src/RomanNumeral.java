/**This class compares two Roman numerals stored in a string
 * and determines which is larger than the other.
 * It also extends the Roman2Arabic and implements
 * Comparable<RomanNumeral>
 * 
 * @author Sergio Rangel Camacho
 *
 */
public class RomanNumeral extends Roman2Arabic implements Comparable<RomanNumeral>{
	
	//This is the private variable
	private String numeral;
	
	/**
	 * THis is the constructor that initializes the numeral 
	 * string to the variable
	 * @param numeral
	 */
	public RomanNumeral(String numeral) {
		this.numeral = numeral;
	}
	
	/**
	 * This method is a toString that returns the numeral variable
	 */
	public String toString() {
		return numeral;
	}
	
	/**
	 * This method compares the two RomanNumerals and determines 
	 * which of the two numerals are larger.
	 */
	public int compareTo(RomanNumeral input) {
	
		int orig = convertWholeNumeral(numeral);
		int diff = convertWholeNumeral(input.toString());
		if(orig == diff) {
			return 0;
		}
		else if(orig > diff) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
