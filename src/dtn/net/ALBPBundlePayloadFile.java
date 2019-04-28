package dtn.net;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Payload saved in File 
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPBundlePayloadFile extends ALBPBundlePayload {
	private final Path path;
	private byte[] data = null;
	private final boolean tempFile;
	
	public ALBPBundlePayloadFile(final String fileName) {
		this(ALBPBundlePayloadLocation.File, fileName, false);
	}
	
	protected ALBPBundlePayloadFile(final ALBPBundlePayloadLocation payloadLocation, final String fileName, boolean isTempFile) {
		super(payloadLocation);
		this.path = Paths.get(fileName);
		this.tempFile = isTempFile;
	}

	@Override
	public byte[] getData() {
		if (data != null)
			return data;
		try {
			this.data = Files.readAllBytes(this.path);
			if (this.tempFile)
				Files.delete(this.path);
		} catch (IOException e) {}
		return data;
	}
	
	public String getFileName() {
		return this.path.toString();
	}


}
