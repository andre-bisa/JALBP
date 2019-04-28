package dtn.net;

/** EID Schema
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum ALBPEIDSchema {
IPN, DTN;
	
	/**
	 * Returns the EIDSchema from a char
	 * @param schema as a char. (I=IPN, D=DTN)
	 * @return The EIDSchema
	 */
	public static ALBPEIDSchema getSchemaFromChar(char schema) {
		switch (schema) {
		case 'I':
			return ALBPEIDSchema.IPN;

		case 'D':
			return ALBPEIDSchema.DTN;
			
		default:
			return null;
		}
	}
	
}
