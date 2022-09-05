import java.util.Iterator;

/**
 * This uses the Repeat and Palindrome Checkers to find
 * different patterns in the DNA sequences
 * @author Sergio Rangel Camacho
 *
 */
public class DnaAnalyser {
	
	/**
	 * These are the private instance variables for the DnaAnalyser class
	 */
	private LinkedQueue<Checker> checkers;
	private LinkedQueue<String> results;
	
	/**
	 * This is the constructor for the DnaAnalyser class.
	 * It initializes the checkers with the user input and
	 * creates a new LinkedQueue for the results variable
	 * @param checkers
	 */
	public DnaAnalyser(LinkedQueue<Checker> checkers) {
		this.checkers = checkers;
		results = new LinkedQueue<String>();
	}
	
	/**
	 * This method is responsible for checking the given input and returning
	 * which patterns the class has and where the are found
	 * @param dnaSequence
	 * @return
	 */
	public String search(Iterator<Character> dnaSequence) {
		char seqChar;
		String str = "";
		int strLen = 0;
		
		LinkedQueue<Checker> activeCheckers = new LinkedQueue<Checker>();
		while(!results.isEmpty()) {
			results.dequeue();
		}

		while(dnaSequence.hasNext()) {
			seqChar = dnaSequence.next();
			str += seqChar;
			
			checkers.enqueue(checkers.first());
			activeCheckers.enqueue(checkers.dequeue().cloneHere(strLen));
			activeCheckers.first().process(seqChar);
			checkers.enqueue(checkers.first());
			activeCheckers.enqueue(checkers.dequeue().cloneHere(strLen));
			activeCheckers.first().process(seqChar);
			
			if(activeCheckers.first().finished() == true) {
				results.enqueue(activeCheckers.first().toString());
			}
		
			strLen++;
		}
		results.enqueue("....*....1....*....2....*....3....*....4....*....5");
		results.enqueue(str);
		
		return results.first();
	}
 
	/**
	 * This method is responsible for returning a String that includes
	 * all patterns found the given String. It will be separated by a comma
	 * @param dnaSequence
	 * @return
	 */
	public String displayAnalysis(String dnaSequence) {
		String str = "";
		
		while(!results.isEmpty()) {
			str += results.dequeue();
			str += " \n";
		}
		return str;
	}


	
}
