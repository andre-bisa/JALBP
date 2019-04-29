package it.unibo.dtn.JALBP.tests;

import java.io.IOException;

import it.unibo.dtn.JALBP.Bundle;
import it.unibo.dtn.JALBP.BPSocket;
import it.unibo.dtn.JALBP.BundleEID;
import it.unibo.dtn.JALBP.exceptions.ALBPException;

class Main {

	public static void main(String[] args) throws ALBPException, IOException {
		BPSocket socket = BPSocket.of(10);
		
		Bundle bundle = socket.receive();
		bundle.setDestination(BundleEID.of("ipn:5.1"));
		bundle.setExpiration(60);
		socket.send(bundle);
		
		socket.close();
	}

}
