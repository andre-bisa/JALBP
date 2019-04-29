package it.unibo.dtn.JAL;

/** 
 * EID Schema
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum BundleSchemeFlag {
IPN, DTN;
	
	/**
	 * Returns the EIDSchema from a char
	 * @param schema as a char. (I=IPN, D=DTN)
	 * @return The EIDSchema
	 */
	public static BundleSchemeFlag getSchemaFromChar(char schema) {
		switch (schema) {
		case 'I':
			return BundleSchemeFlag.IPN;

		case 'D':
			return BundleSchemeFlag.DTN;
			
		default:
			return null;
		}
	}
	
}
