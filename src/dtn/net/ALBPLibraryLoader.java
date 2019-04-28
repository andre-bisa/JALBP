package dtn.net;

/** Utility class. Loads the AL_BP library
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
class ALBPLibraryLoader {
	
	private ALBPLibraryLoader() {}

	/**
	 * Loads the al_bp library.
	 * @throws Throwable In case the library is not installed in the system
	 */
	public static void loadLibrary() {
		try {
			System.loadLibrary("al_bp");
			// TODO caricare tutte le librerie
		} catch (Throwable e) {
			System.err.println("Error, library al_bp not found in: " + System.getProperty("java.library.path"));
			throw e;
		}
	}

}
