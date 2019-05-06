package it.unibo.dtn.JAL;

import it.unibo.dtn.JAL.exceptions.JALException;
import it.unibo.dtn.JAL.exceptions.JALInitException;
import it.unibo.dtn.JAL.exceptions.JALLibraryNotFoundException;

/** 
 * Class used to force some parameters in DTN sockets.<br>
 * You can force the EID scheme and the local IPN Node in case you are using DTN2 implementation and you are forcing IPN scheme.<br>
 * <p>
 * <b>Usage:</b><br>
 * <ol>
 * <li>Call {@link #getInstance()} to get the instance.</li>
 * <li>(Optional) Set the forcing parameters before opening {@link BPSocket}s ({@link #setForceEIDSchema(EngineForceEIDSchema)} and {@link #setIPNNodeForDTN2(int)}).</li>
 * <li>(Optional) Call {@link #init()} function.</li>
 * <li>Call {@link #destroy()} function when all {@link BPSocket}s are unregistered and you are not willing to open anymore.</li>
 * </ol>
 * </p>
 * 
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class JALEngine {
	private EngineForceEIDSchema forceEID = EngineForceEIDSchema.NOFORCE;
	private int IPNNodeForDTN2 = 0;
	
	private boolean initialized = false;
	
	/**
	 * Returns the Force EID scheme
	 * @return The Force EID
	 */
	public EngineForceEIDSchema getForceEID() {
		return this.forceEID;
	}
	
	/**
	 * Requires to force the scheme
	 * @param forceEIDSchema - the scheme to force
	 * @return This object (for serial settings calls)
	 * @throws IllegalStateException In case you try to change after the creation of a {@link BPSocket}
	 */
	public JALEngine setForceEIDSchema(EngineForceEIDSchema forceEIDSchema) throws IllegalStateException {
		if (this.initialized)
			throw new IllegalStateException();
		this.forceEID = forceEIDSchema;
		return this;
	}
	
	/**
	 * Returns the IPNNodeForDTN2
	 * @return The IPNNodeForDTN2
	 */
	public int getIPNNodeForDTN2() {
		return this.IPNNodeForDTN2;
	}
	
	/**
	 * Sets the local IPN node number. To be used if forcing IPN scheme and using DTN2 implementation.
	 * @param IPNNodeForDTN2 - local IPN Node number
	 * @return This object (for serial settings calls)
	 * @throws IllegalStateException In case you try to change after the creation of a {@link BPSocket}
	 */
	public JALEngine setIPNNodeForDTN2(int IPNNodeForDTN2) throws IllegalStateException {
		if (this.initialized)
			throw new IllegalStateException();
		this.IPNNodeForDTN2 = IPNNodeForDTN2;
		return this;
	}
	
	/**
	 * <b>Important function.</b><br>
	 * Before calling this function, if you need to, you have to call {@link #setForceEIDSchema(EngineForceEIDSchema)} and {@link #setIPNNodeForDTN2(int)}.<br>
	 * This function have to be called once before using {@link BPSocket}.<br>
	 * In case you will not call {@link #init()} the {@link BPSocket} will do it for you.
	 * @throws JALException See @{@link JALException}
	 */
	public void init() throws JALException {
		if (this.initialized) return;
		int error = JALEngine.c_init(this.forceEID.getCharForceEIDSchema(), this.IPNNodeForDTN2);
		ExceptionManager.checkError(error, "Error on ALBPEngine.init.");
		this.initialized = true;
	}
	
	/**
	 * <b>Important function.</b><br>
	 * You have to call this function when all {@link BPSocket}s are closed and you don't want to use {@link BPSocket}s anymore. 
	 */
	public void destroy() {
		if (this.initialized) {
			JALEngine.c_destroy();
			this.initialized = false;
		}
	}
	
	/**
	 * Returns the EIDFormat
	 * @return The EIDFormat
	 * @throws JALInitException In case of ALBPException
	 * @see JALException
	 */
	public BundleSchemeFlag getEIDFormat() throws JALInitException {
		if (this.initialized)
			return BundleSchemeFlag.getSchemaFromChar(JALEngine.c_get_eid_format());
		else
			throw new JALInitException("ALLBP not initialized.");
	}
	
	private static JALEngine instance = null; // Singleton
	private JALEngine() {}
	/**
	 * Returns the instance of JALEngine.
	 * @return The instance of JALEngine
	 * @throws JALLibraryNotFoundException In case the library is not found in the system (probably not installed)
	 * @throws JALException In case of Exceptions.
	 * @see JALException
	 */
	public static JALEngine getInstance() throws JALException {
		if (JALEngine.instance == null) {
			JALEngine.loadLibrary();
			JALEngine.instance = new JALEngine();
			JALEngine.instance.init();
		}
		return JALEngine.instance;
	}
	
	/**
	 * Loads the al_bp library for JNI.
	 * @throws JALLibraryNotFoundException In case the library is not found in the system (probably not installed)
	 */
	private static void loadLibrary() throws JALLibraryNotFoundException {
		final String libraryName = "al_bp";
		try {
			System.loadLibrary(libraryName);
		} catch (Throwable e) {
			throw new JALLibraryNotFoundException("Error, library " + libraryName + " not found in: " + System.getProperty("java.library.path"), e);
		}
	}
	
	private static native int c_init(char force_eid, int IPNNodeForDTN2);
	private static native void c_destroy();
	private static native char c_get_eid_format();
	
}
