package it.unibo.dtn.JAL.tests;

import java.io.IOException;

import it.unibo.dtn.JAL.BPSocket;
import it.unibo.dtn.JAL.Bundle;
import it.unibo.dtn.JAL.JALEngine;
import it.unibo.dtn.JAL.exceptions.JALException;
import it.unibo.dtn.JAL.exceptions.JALReceptionInterruptedException;
import it.unibo.dtn.JAL.exceptions.JALTimeoutException;

class Main {

	public static void main(String[] args) throws JALException, IOException {
		BPSocket socket = BPSocket.register(10);
		
		boolean stop = false;
		Bundle bundle = null;
		while (!stop) {
			try {
				bundle = socket.receive();
				System.out.print(new String(bundle.getData()));
			} catch (JALReceptionInterruptedException e) {continue;}
			catch (JALTimeoutException e) {
				System.out.println("Timeout");
			}
			bundle.setDestination(bundle.getSource());
			bundle.setExpiration(60);
			socket.send(bundle);
		}
		
		socket.close();
		JALEngine.getInstance().destroy();
	}

}
