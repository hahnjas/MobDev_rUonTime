/**
 * 
 */
package se.kth.mobdev.ruontime.backend;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import se.kth.mobdev.ruontime.model.Meeting;

/**
 * @author Jasper
 *
 */

@ManagedBean(name = "newMeetingBean")
public class NewMeetingBean {
	
//	@ManagedProperty(value = "persistence")
	Persistance store;

	private Meeting newMeeting;
	
	public String create(){
		store.createNewMeeting(newMeeting);
		return "welcome.xhtml";
	}

	public Meeting getNewMeeting() {
		return newMeeting;
	}

	public void setNewMeeting(Meeting newMeeting) {
		this.newMeeting = newMeeting;
	}
	
	
	
	
}
