package it.unibo.dtn.JAL;

/** 
 * Bundle Scheme Flag
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum BundleSchemeFlag {
IPN, DTN;
	
	/**
	 * Returns the EIDSchema from a char (according to C code)
	 * @param schema as a char. (I=IPN, D=DTN)
	 * @return The Bundle Scheme Flag or null if the param is not 'I' or 'D'
	 */
	static BundleSchemeFlag getSchemaFromChar(char schema) {
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
