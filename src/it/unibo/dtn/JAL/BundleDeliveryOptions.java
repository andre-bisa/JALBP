package it.unibo.dtn.JAL;

/** DTNDeliveryOptions
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum BundleDeliveryOptions {
None(0),
Custody(1),
DeliveryReceipt(2),
ReceiveReceipt(4),
ForwardReceipt(8),
CustodyReceipt(16),
DeleteReceipt(32),
SingletonDestination(64),
MultinodeDestination(128),
DoNotFragment(256);
	
	private int intVal;
	private BundleDeliveryOptions(int val) {
		this.intVal = val;
	}
	
	public int getValue() {
		return this.intVal;
	}
	
	public static BundleDeliveryOptions of(int val) {
		switch (val) {
		case 0: return None;
		case 1: return Custody;
		case 2: return DeliveryReceipt;
		case 4: return ReceiveReceipt;
		case 8: return ForwardReceipt;
		case 16: return CustodyReceipt;
		case 32: return DeleteReceipt;
		case 64: return SingletonDestination;
		case 128: return MultinodeDestination;
		case 256: return DoNotFragment;
		
		default: return null;
		}
	}
	
}
