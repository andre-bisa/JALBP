package dtn.net.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dtn.net.endpoint.DTNEndpointID;

class TestEndpoint {

	@Test
	void testDTNEndpoint() {
		String str = "dtn:prova/ciao";
		DTNEndpointID e = DTNEndpointID.of(str);
		assertEquals(str, e.getEndpointID());
		assertEquals(str, e.toString());
		assertEquals("prova", e.getLocalString());
		assertEquals("ciao", e.getDemuxString());
	}
	
	void testIPNEndpoint() {
		String str = "ipn:5.100";
		DTNEndpointID e = DTNEndpointID.of(str);
		assertEquals(str, e.getEndpointID());
		assertEquals(str, e.toString());
		assertEquals(""+5, e.getLocalString());
		assertEquals(""+100, e.getDemuxString());
	}

}
