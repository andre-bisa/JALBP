package dtn.net;

/** DTN Priority
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum DTNPriority {
Bulk(0),
Normal(1),
Expedited(2),
Reserved(3);
	
	private int intVal;
	
	private DTNPriority(int val) {
		this.intVal = val;
	}
	
	/**
	 * Gets the value according to C code
	 * @return The value
	 */
	public int getValue() {
		return this.intVal;
	}
	
	/**
	 * Creates a DTNPriority from an integer value according to C code.
	 * @param val The value
	 * @return A DTNPriority instance
	 */
	public static DTNPriority of(int val) {
		switch (val) {
		case 0: return Bulk;
		case 1: return Normal;
		case 2: return Expedited;
		case 3: return Reserved;
		default: return null;
		}
	}
	
}
