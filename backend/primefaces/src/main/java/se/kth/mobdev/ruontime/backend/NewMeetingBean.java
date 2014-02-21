/**
 * 
 */
package se.kth.mobdev.ruontime.backend;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import se.kth.mobdev.ruontime.model.Meeting;

/**
 * @author Jasper
 *
 */

@ManagedBean(name = "newMeetingBean")
public class NewMeetingBean {

	private Meeting newMeeting;
	
	

	public Meeting getNewMeeting() {
		return newMeeting;
	}

	public void setNewMeeting(Meeting newMeeting) {
		this.newMeeting = newMeeting;
	}
	
	
	
	
}
