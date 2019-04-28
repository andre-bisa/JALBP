package dtn.net;

/** Status Report Reason
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum ALBPStatusReportReason {
NoAddtlInfo(0),
LifetimeExpired(1),
ForwardedUnidirLink(2),
TransmissionCancelled(3),
DepletedStorage(4),
EndpointIDUnintelligible(5),
NoRouteToDest(6),
NoTimelyContact(7),
BlockUnintelligible(8);
	
	private int intVal;
	private ALBPStatusReportReason(int val) {
		this.intVal = val;
	}
	
	public int getValue() {
		return this.intVal;
	}
	
	public static ALBPStatusReportReason of(int val) {
		switch (val) {
		case 0: return NoAddtlInfo;
		case 1: return LifetimeExpired;
		case 2: return ForwardedUnidirLink;
		case 3: return TransmissionCancelled;
		case 4: return DepletedStorage;
		case 5: return EndpointIDUnintelligible;
		case 6: return NoRouteToDest;
		case 7: return NoTimelyContact;
		case 8: return BlockUnintelligible;
		
		default: return null;
		}
	}
	
}
