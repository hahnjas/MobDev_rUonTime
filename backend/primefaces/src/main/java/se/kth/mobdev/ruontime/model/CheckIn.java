/**
 * 
 */
package se.kth.mobdev.ruontime.model;

import java.util.Calendar;

/**
 * @author Jasper
 *
 */
public class CheckIn {
	
	private User associatedUser;
	
	private Calendar timestamp;
	
	private int minutesLate;
	
	private boolean firstToShowUp;
	
	private boolean lastToShowUp;
	

	public CheckIn(User associatedUser, Calendar timestamp, int minutesLate,
			boolean firstToShowUp, boolean lastToShowUp) {
		super();
		this.associatedUser = associatedUser;
		this.timestamp = timestamp;
		this.minutesLate = minutesLate;
		this.firstToShowUp = firstToShowUp;
		this.lastToShowUp = lastToShowUp;
	}

	public User getAssociatedUser() {
		return associatedUser;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public int getMinutesLate() {
		return minutesLate;
	}

	public boolean isFirstToShowUp() {
		return firstToShowUp;
	}

	public boolean isLastToShowUp() {
		return lastToShowUp;
	}

}
