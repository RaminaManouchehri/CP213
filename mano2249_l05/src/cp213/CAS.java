package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author
 * @version 2022-02-25
 */
public class CAS extends Professor {

    // your code here
    String term;

    public CAS(String lastName, String firstName, String deparment, String term) {
	super(lastName, firstName, deparment);

	this.term = term;
    }

    public String getTerm() {
	return this.term;

    }

    @Override
    public String toString() {

	return (super.toString() + "\nTerm: " + this.term);
    }

}
