package dtn.net;

/** Payload saved in Temporary File
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPBundlePayloadTemporaryFile extends ALBPBundlePayloadFile {
	/**
	 * The temporaryfile is deleted after first data reading
	 * @param fileName name of temporary file
	 */
	public ALBPBundlePayloadTemporaryFile(String fileName) {
		super(ALBPBundlePayloadLocation.TemporaryFile, fileName, true);
	}
}
