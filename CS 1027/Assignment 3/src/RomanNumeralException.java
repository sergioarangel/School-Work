/**
 * This is a custom Exception class that will be used in the
 * Roman2Arabic conversion. This constructor implements
 * the RuntimeException
 * @author Sergio Rangel Camacho
 *
 */
public class RomanNumeralException extends RuntimeException{
	
	/**
	 * This is the constructor for the exception that gets
	 * initialized by calling the parent class constructor
	 * @param input
	 */
	public RomanNumeralException(String input) {
		super(input);
	}
}
