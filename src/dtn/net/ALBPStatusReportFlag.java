package dtn.net;

/** Status Report Flag
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum ALBPStatusReportFlag {
Received(1),
CustodyAccepted(2),
Forwarded(4),
Delivered(8),
Deleted(16),
AckedByApp(32);
	
	private int intVal;
	private ALBPStatusReportFlag(int val) {
		this.intVal = val;
	}
	
	public int getValue() {
		return this.intVal;
	}
	
	public static ALBPStatusReportFlag of(int val) {
		switch (val) {
		case 1: return Received;
		case 2: return CustodyAccepted;
		case 4: return Forwarded;
		case 8: return Delivered;
		case 16: return Deleted;
		case 32: return AckedByApp;
			
		default: return null;
		}
	}
	
}
