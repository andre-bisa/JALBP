package it.unibo.dtn.JAL;

/** 
 * Force EID Schema used in some {@link JALEngine} functione
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum EngineForceEIDSchema {
NOFORCE('N'),
IPN('I'),
DTN('D');
	
	private final char forceEIDSchema; 
	
	private EngineForceEIDSchema(char forceEID) {
		this.forceEIDSchema = forceEID;
	}
	
	/**
	 * Returns the char referred to the forcing schema (according to C code)
	 * @return The char referred to the forcing schema (according to C code)
	 */
	char getCharForceEIDSchema() {
		return this.forceEIDSchema;
	}
}
