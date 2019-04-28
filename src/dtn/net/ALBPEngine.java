package dtn.net;

import dtn.net.exceptions.ALBPException;
import dtn.net.exceptions.ALBPInitException;

/** ALBPEngine
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPEngine {
	
	private ALBPEngineForceEIDSchema forceEID = ALBPEngineForceEIDSchema.NOFORCE;
	private int IPNNodeForDTN2 = 0;
	
	private boolean initialized = false;
	
	/**
	 * Getter of EngineForceEID
	 * @return The ForceEIDSchema
	 */
	public ALBPEngineForceEIDSchema getForceEID() {
		return this.forceEID;
	}
	
	/**
	 * Sets the DorceEIDSchema
	 * @param forceEIDSchema To set
	 */
	public void setForceEIDSchema(ALBPEngineForceEIDSchema forceEIDSchema) {
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
	 * Before calling this function, if you need to, you have to call {@link #setForceEIDSchema(ALBPEngineForceEIDSchema)} and {@link #setIPNNodeForDTN2(int)}.<br>
	 * This function have to be called once before using {@link ALBPSocket}.<br>
	 * In case you will not call {@link #init()} the {@link ALBPSocket} will do it for you.
	 * @throws ALBPException See @{@link ALBPException}
	 */
	public void init() throws ALBPException {
		if (this.initialized) return;
		int error = ALBPEngine.c_init(this.forceEID.getCharForceEIDSchema(), this.IPNNodeForDTN2);
		ALBPExceptionManager.checkError(error, "Error on ALBPEngine.init.");
		this.initialized = true;
	}
	
	/**
	 * <b>Important function.</b><br>
	 * You have to call this function when you don't want to use {@link ALBPSocket}s anymore. 
	 */
	public void destroy() {
		if (this.initialized) {
			ALBPEngine.c_destroy();
			this.initialized = false;
		}
	}
	
	/**
	 * Returns the EIDFormat
	 * @return The EIDFormat
	 * @throws ALBPInitException In case of ALBPException
	 * @see ALBPException
	 */
	public ALBPEIDSchema getEIDFormat() throws ALBPInitException {
		if (this.initialized)
			return ALBPEIDSchema.getSchemaFromChar(ALBPEngine.c_get_eid_format());
		else
			throw new ALBPInitException("ALLBP not initialized.");
	}
	
	private static ALBPEngine instance = null;
	private ALBPEngine() {}
	/**
	 * The ALBPEngine is a singleton object.
	 * @return The instance of ALBPEngine
	 * @throws ALBPException In case of ALBPException.
	 * @see ALBPException
	 */
	public static ALBPEngine getInstance() throws ALBPException {
		if (ALBPEngine.instance == null) {
			ALBPLibraryLoader.loadLibrary();
			ALBPEngine.instance = new ALBPEngine();
			ALBPEngine.instance.init();
		}
		return ALBPEngine.instance;
	}
	
	private static native int c_init(char force_eid, int IPNNodeForDTN2);
	
	private static native void c_destroy();

	private static native char c_get_eid_format();
	
}
