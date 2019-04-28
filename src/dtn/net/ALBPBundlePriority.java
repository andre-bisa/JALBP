package dtn.net;

/** Bundle Priority
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPBundlePriority {
	private DTNPriority priority;
	private int ordinal;
	
	/**
	 * 
	 * @param priority priority
	 * @param ordinal ordinal
	 */
	public ALBPBundlePriority(int priority, int ordinal) {
		this.priority = DTNPriority.of(priority);
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
		if (!(obj instanceof ALBPBundlePriority)) {
			return false;
		}
		ALBPBundlePriority other = (ALBPBundlePriority) obj;
		if (ordinal != other.ordinal) {
			return false;
		}
		if (priority != other.priority) {
			return false;
		}
		return true;
	}

	public DTNPriority getPriority() {
		return priority;
	}

	public void setPriority(DTNPriority priority) {
		this.priority = priority;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
}
