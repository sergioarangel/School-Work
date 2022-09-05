/**
 * This class is responsible for converting a Roman numeral string/ character
 * into the corresponding Arabic value
 * @author Sergio Rangel Camacho
 *
 */
public class Roman2Arabic{
	
	/**This method converts the Roman character that is given
	 * into the Arabic value. It will also throw a
	 * RomanNumeralException is the character given is not
	 * 1 of the 7 Roman numeral characters.
	 * 
	 * @param input
	 * @return num
	 * @throws RomanNumeralException
	 */
	public static int convertSingleNumeral(char input) throws RomanNumeralException{
		
		if(input == 'I' || input == 'V' || input == 'X' || input == 'L' ||
				input == 'C' || input == 'D' || input == 'M') {
			int num = 0;
			if(input == 'I') {
				num = 1;
			}
			else if(input == 'V') {
				num = 5;
			}
			else if(input == 'X') {
				num = 10;
			}
			else if(input == 'L') {
				num = 50;
			}
			else if(input == 'C') {
				num = 100;
			}
			else if(input == 'D') {
				num = 500;
			}
			else if(input == 'M') {
				num = 1000;
			}
			return num;
		}
		else {
			throw new RomanNumeralException("Error");
		}
	}
	
	/**
	 * This method takes in a String of Roman Numerals, puts it into
	 * a stack, and returns the value of the RomanNumeral string.
	 * It will also throw a RomanNumeralException if any of the rules
	 * that were given are violated.
	 * 
	 * @param wholeNum
	 * @return
	 * @throws RomanNumeralException
	 */
	public static int convertWholeNumeral(String wholeNum) throws RomanNumeralException{
		
		ArrayStack<Character> converter = new ArrayStack<Character>();
		char var;
		int currVal = 0 ;
		int result = 0;
		int Icount = 0;
		int Dcount = 0;
		int Vcount = 0;
		int Lcount = 0;
		for(int i = 0; i < wholeNum.length(); i++) {
			var = wholeNum.charAt(i);
			if(converter.isEmpty()) {
				currVal = convertSingleNumeral(var);
				result += currVal;
				converter.push(var);
			}
			else {
				if(convertSingleNumeral(var) <= convertSingleNumeral(converter.peek())) {
					currVal = convertSingleNumeral(var);
					result += currVal;
					converter.push(var);
				}
				else {
					result -= currVal;
					result += convertSingleNumeral(var) - convertSingleNumeral(converter.pop());
				}
			}
			if(var == 'D') {
				Dcount++;
				if(Dcount == 2) {
					throw new RomanNumeralException("Error");
				}
			}
			else if(var == 'V') {
				Vcount++;
				if(Vcount == 2) {
					throw new RomanNumeralException("Error");
				}
			}
			else if(var == 'L') {
				Lcount++;
				if(Lcount == 2) {
					throw new RomanNumeralException("Error");
				}
			}
			else if(var == 'I') {
				Icount++;
				if(Icount == 4) {
					throw new RomanNumeralException("Error");
				}
			}
			else {
				Dcount = 0;
				Vcount = 0;
				Lcount = 0;
				Icount = 0;
			}
		}		
		return result;
	}
}
