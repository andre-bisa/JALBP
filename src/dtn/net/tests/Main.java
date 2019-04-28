package dtn.net.tests;

import java.io.IOException;

import dtn.net.ALBPBundle;
import dtn.net.ALBPSocket;
import dtn.net.endpoint.DTNEndpointID;
import dtn.net.exceptions.ALBPException;

public class Main {

	public static void main(String[] args) throws ALBPException, IOException {
		ALBPSocket socket = ALBPSocket.of(10);
		
		ALBPBundle bundle = socket.receive();
		bundle.setDestination(DTNEndpointID.of("ipn:5.1"));
		bundle.setExpiration(60);
		socket.send(bundle);
		
		socket.close();
	}

}
