/**
 * This method checks a DNA sequence and determines if there a repeating
 * pattern in it. It also implements the interface Checker
 * @author Sergio Rangel Camacho
 *
 */
public class RepeatChecker implements Checker{
	
	/**
	 * These are the private variables for the RepeatChecker Class
	 */
	private final int seqLength;
	private final int repeatNumber;
	private final int position;
	private boolean fail;
	private String patternSoFar;
	private QueueADT<Character> previous;
	
	/**
	 * This is the constructor for the RepeatChecker Class
	 * It initializes the private variables and initializes seqLength, 
	 * and repeatNumber with the inputs that the user included
	 * @param seqLength
	 * @param repeatNumber
	 */
	public RepeatChecker(int seqLength, int repeatNumber) {
		this.seqLength = seqLength;
		this.repeatNumber = repeatNumber;
		position = 0;
		fail = false;
		patternSoFar = "";
		previous = new LinkedQueue<Character>();
	}
	
	/**
	 * This is a constructor for the RepeatChecker Class
	 * It initializes the private variables and initializes seqLength, 
	 * position, and seqLength with the inputs that the user included
	 * @param seqLength
	 * @param repeatNumber
	 * @param position
	 */
	private RepeatChecker(int seqLength, int repeatNumber,int position) {
		this.seqLength = seqLength;
		this.repeatNumber = repeatNumber;
		this.position = position;
		fail = false;
		patternSoFar = "";
		previous = new LinkedQueue<Character>();
	}
	
	/**
	 * This method is responsible for checking to see if there is a 
	 * repeating pattern and return a boolean value depending on the 
	 * results
	 */
	public boolean process(char c) {
		int queueSize = patternSoFar.length();
		
		patternSoFar += c;

		if(queueSize < seqLength) {
			previous.enqueue(c);
		}
		
		else{
			if(c == previous.first()) {
				previous.dequeue();
				previous.enqueue(c);
				fail = true;
			}
			else if(c != previous.first()) {
				while(!previous.isEmpty()) {
					previous.dequeue();
				}
				previous.enqueue('x');
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
	 * This method clone a new RepeatChecker but changes the position
	 * with what the user inputs
	 */
	public Checker cloneHere(int pos) {
		Checker previous2 = new RepeatChecker(seqLength, repeatNumber, pos);
		return previous2;
	}

	/**
	 * This toString returns a String the includes the seqLength, repeatNumber, position,
	 * and patternSoFar
	 */
	public String toString() {
		return "Repeat(" + seqLength + "," + repeatNumber +   ") - " + position + "{" + patternSoFar +"}";
	}

	
}
