package it.unibo.dtn.JAL.tests;

import java.io.IOException;

import it.unibo.dtn.JAL.BPSocket;
import it.unibo.dtn.JAL.Bundle;
import it.unibo.dtn.JAL.BundleEID;
import it.unibo.dtn.JAL.BundlePayloadLocation;
import it.unibo.dtn.JAL.exceptions.JALException;
import it.unibo.dtn.JAL.exceptions.JALReceptionInterruptedException;

class Main {

	public static void main(String[] args) throws JALException, IOException {
		BPSocket socket = BPSocket.register(10);
		
		boolean stop = false;
		Bundle bundle = null;
		while (!stop) {
			try {
				bundle = socket.receive();
			} catch (JALReceptionInterruptedException e) {continue;}
			bundle.setDestination(BundleEID.of("ipn:5.1"));
			bundle.setExpiration(60);
			socket.send(bundle);
		}
		
		socket.close();
	}

}
