package it.unibo.dtn.JALBP;

/** Payload saved in Temporary File
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BundlePayloadTemporaryFile extends BundlePayloadFile {
	/**
	 * The temporaryfile is deleted after first data reading
	 * @param fileName name of temporary file
	 */
	public BundlePayloadTemporaryFile(String fileName) {
		super(BundlePayloadLocation.TemporaryFile, fileName, true);
	}
}
