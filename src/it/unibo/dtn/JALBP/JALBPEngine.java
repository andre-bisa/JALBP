package it.unibo.dtn.JALBP;

import it.unibo.dtn.JALBP.exceptions.ALBPException;
import it.unibo.dtn.JALBP.exceptions.ALBPInitException;

/** ALBPEngine
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class JALBPEngine {
	
	private EngineForceEIDSchema forceEID = EngineForceEIDSchema.NOFORCE;
	private int IPNNodeForDTN2 = 0;
	
	private boolean initialized = false;
	
	/**
	 * Getter of EngineForceEID
	 * @return The ForceEIDSchema
	 */
	public EngineForceEIDSchema getForceEID() {
		return this.forceEID;
	}
	
	/**
	 * Sets the DorceEIDSchema
	 * @param forceEIDSchema To set
	 */
	public void setForceEIDSchema(EngineForceEIDSchema forceEIDSchema) {
		this.forceEID = forceEIDSchema;
	}
	
	/**
	 * Getter of IPNNodeForDTN2
	 * @return The IPNNodeForDTN2
	 */
	public int getIPNNodeForDTN2() {
		return this.IPNNodeForDTN2;
	}
	
	/**
	 * Sets the IPNNodeForDTN2
	 * @param IPNNodeForDTN2 To set
	 */
	public void setIPNNodeForDTN2(int IPNNodeForDTN2 ) {
		this.IPNNodeForDTN2 = IPNNodeForDTN2;
	}
	
	/**
	 * <b>Important function.</b><br>
	 * Before calling this function, if you need to, you have to call {@link #setForceEIDSchema(EngineForceEIDSchema)} and {@link #setIPNNodeForDTN2(int)}.<br>
	 * This function have to be called once before using {@link BPSocket}.<br>
	 * In case you will not call {@link #init()} the {@link BPSocket} will do it for you.
	 * @throws ALBPException See @{@link ALBPException}
	 */
	public void init() throws ALBPException {
		if (this.initialized) return;
		int error = JALBPEngine.c_init(this.forceEID.getCharForceEIDSchema(), this.IPNNodeForDTN2);
		ExceptionManager.checkError(error, "Error on ALBPEngine.init.");
		this.initialized = true;
	}
	
	/**
	 * <b>Important function.</b><br>
	 * You have to call this function when you don't want to use {@link BPSocket}s anymore. 
	 */
	public void destroy() {
		if (this.initialized) {
			JALBPEngine.c_destroy();
			this.initialized = false;
		}
	}
	
	/**
	 * Returns the EIDFormat
	 * @return The EIDFormat
	 * @throws ALBPInitException In case of ALBPException
	 * @see ALBPException
	 */
	public BundleSchemeFlag getEIDFormat() throws ALBPInitException {
		if (this.initialized)
			return BundleSchemeFlag.getSchemaFromChar(JALBPEngine.c_get_eid_format());
		else
			throw new ALBPInitException("ALLBP not initialized.");
	}
	
	private static JALBPEngine instance = null;
	private JALBPEngine() {}
	/**
	 * The ALBPEngine is a singleton object.
	 * @return The instance of ALBPEngine
	 * @throws ALBPException In case of ALBPException.
	 * @see ALBPException
	 */
	public static JALBPEngine getInstance() throws ALBPException {
		if (JALBPEngine.instance == null) {
			LibraryLoader.loadLibrary();
			JALBPEngine.instance = new JALBPEngine();
			JALBPEngine.instance.init();
		}
		return JALBPEngine.instance;
	}
	
	private static native int c_init(char force_eid, int IPNNodeForDTN2);
	
	private static native void c_destroy();

	private static native char c_get_eid_format();
	
}
