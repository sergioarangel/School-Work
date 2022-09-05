/**
 * 
 * @author Sergio Rangel Camacho
 * 
 * This class checks the DNA sequence to check for palindrome patterns
 *Also, this class implements the interface Checker
 *
 */
public class PalindromeChecker implements Checker{
	
	/**
	 * These are the private instance variables for the PalindromeChecker class
	 */
	private final int seqLength;
	private final int position;
	private boolean fail;
	private String patternSoFar;
	private StackADT<Character> previous;
	
	/**
	 * This is the constructor of the PalindromeChecker Class that
	 * initializes the private variables
	 * It initializes the seqLength with what the user inputs
	 * @param seqLength
	 */
	public PalindromeChecker(int seqLength) {
		this.seqLength = seqLength;
		position = 0;
		fail = false;
		patternSoFar = "";
		previous = new ArrayStack<Character>();
	}
	
	/**
	 * This is a second constructor that has two parameters which are
	 * seqLength and position. Theses will be used to initialize the this.seqLength
	 * and this.position with those specifications. The other private varaibles 
	 * will just be initialized normally
	 * @param seqLength
	 * @param position
	 */
	private PalindromeChecker(int seqLength, int position) {
		this.seqLength = seqLength;
		this.position = position;
		fail = false;
		patternSoFar = "";
		previous = new ArrayStack<Character>();
	}
	
	/**
	 * This method is responsible for checking the dna sequence
	 * for the palindrome pattern and will return a boolean value
	 * depending on the results
	 */
	public boolean process(char c) {
		int stackSize = patternSoFar.length();
		int lenSize = seqLength / 2;
		
		patternSoFar += c;
		if(seqLength % 2 == 0) {
			if(stackSize < lenSize) {
				previous.push(c);
			}
			else if(stackSize >= lenSize) {
				if(previous.peek() == c) {
					previous.pop();
					fail = true;
				}
				else if(previous.peek() != c) {
					previous.push('x');
				}	
			}
		}
		
		else if(seqLength % 2 != 0){
			if(stackSize < Math.floor(lenSize)) {
				previous.push(c);
			}
			else if (stackSize > Math.ceil(lenSize)) {
				if(previous.peek() == c) {
					previous.pop();
					fail = true;
				}
				else if (previous.peek() != c) {
					previous.push('x');
				}
			}
		}
		return fail;
	}
	
	/**
	 * This method returns the fail variable
	 */
	public boolean finished() {
		return fail;
	}
	
	/**
	 * This method clones a new PalindromeChecker but initializes it
	 * with the position that the user inputed
	 */
	public Checker cloneHere(int pos) {
		Checker previous2 = new PalindromeChecker(seqLength, pos);
		return previous2;
	}
	
	/**
	 * This method is a toString that returns a String that includes
	 * the seqLength, position, and patternSoFar
	 */
	public String toString() {
		return "Palindrome(" + seqLength + ") - " + position + "{" + patternSoFar +"}";
	}
}
