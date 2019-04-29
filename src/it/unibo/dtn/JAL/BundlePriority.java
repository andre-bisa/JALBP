package it.unibo.dtn.JAL;

/** Bundle Priority
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BundlePriority {
	private BundlePriorityCardinal priority;
	private int ordinal;
	
	/**
	 * 
	 * @throws IllegalArgumentException If ordinal is set with priority not Expedited or priority is Reserved
	 * @param priority priority
	 */
	public BundlePriority(int priority) {
		this(priority, 0);
	}
	
	/**
	 * 
	 * @param priority priority
	 * @param ordinal ordinal
	 * @throws IllegalArgumentException If ordinal is set with priority not Expedited or priority is Reserved
	 */
	public BundlePriority(int priority, int ordinal) {
		this.priority = BundlePriorityCardinal.of(priority);
		if (!this.priority.equals(BundlePriorityCardinal.Expedited) && this.ordinal != 0)
			throw new IllegalArgumentException("Can't set ordinal unless cardinal priority is " + BundlePriorityCardinal.Expedited.toString());
		if (priority == BundlePriorityCardinal.Reserved.getValue())
			throw new IllegalArgumentException("Can't use " + BundlePriorityCardinal.Reserved.toString() + " as a priority.");
		this.ordinal = ordinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ordinal;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BundlePriority)) {
			return false;
		}
		BundlePriority other = (BundlePriority) obj;
		if (ordinal != other.ordinal) {
			return false;
		}
		if (priority != other.priority) {
			return false;
		}
		return true;
	}

	public BundlePriorityCardinal getPriority() {
		return priority;
	}

	public void setPriority(BundlePriorityCardinal priority) {
		this.priority = priority;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
}
