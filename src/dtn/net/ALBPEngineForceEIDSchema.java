package dtn.net;

/** Force EID Schema
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum ALBPEngineForceEIDSchema {
NOFORCE('N'),
IPN('I'),
DTN('D');
	
	private char forceEIDSchema; 
	
	private ALBPEngineForceEIDSchema(char forceEID) {
		this.forceEIDSchema = forceEID;
	}
	
	/**
	 * Returns the char referred to the forcing schema
	 * @return The char referred to the forcing schema
	 */
	public char getCharForceEIDSchema() {
		return this.forceEIDSchema;
	}
}
