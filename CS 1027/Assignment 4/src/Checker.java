/**
 * 
 * @author Sergio Rangel Camacho
 *
 *This class is an interface that defines abstract method for the other 
 *classes
 */
public interface Checker {
	
	public abstract boolean process(char c);
	//Used to process a single char c
	
	public abstract boolean finished();
	//Looks and checks if the Checker's work is complete
	
	public abstract Checker cloneHere(int pos);
	//Creates a new Checker with the same attributes. The only thing it changes
	//is that it restarts at the pos position in the DNA's sequence
}
