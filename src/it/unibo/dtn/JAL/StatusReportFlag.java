package it.unibo.dtn.JAL;

import java.util.LinkedList;
import java.util.List;

/** Status Report Flag
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum StatusReportFlag {
Received(1),
CustodyAccepted(2),
Forwarded(4),
Delivered(8),
Deleted(16),
AckedByApp(32);
	
	private int intVal;
	private StatusReportFlag(int val) {
		this.intVal = val;
	}
	
	public int getValue() {
		return this.intVal;
	}
	
	public static List<StatusReportFlag> of(int val) {
		List<StatusReportFlag> result = new LinkedList<>();
		if (val >= AckedByApp.getValue()) {
			val -= AckedByApp.getValue();
			result.add(AckedByApp);
		}
		if (val >= Deleted.getValue()) {
			val -= Deleted.getValue();
			result.add(Deleted);
		}
		if (val >= Delivered.getValue()) {
			val -= Delivered.getValue();
			result.add(Delivered);
		}
		if (val >= Forwarded.getValue()) {
			val -= Forwarded.getValue();
			result.add(Forwarded);
		}
		if (val >= CustodyAccepted.getValue()) {
			val -= CustodyAccepted.getValue();
			result.add(CustodyAccepted);
		}
		if (val >= Received.getValue()) {
			val -= Received.getValue();
			result.add(Received);
		}
		return result;
	}
	
}
