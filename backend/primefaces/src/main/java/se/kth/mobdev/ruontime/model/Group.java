/**
 * 
 */
package se.kth.mobdev.ruontime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasper
 *
 */
public class Group {

	private String name;
	
	private List<User> supervisors;
	
	private List<User> participants;
	
	private List<Meeting> meetings;
	
	
	public Group(String name, User supervisor) {
		this.name = name;
		
		this.supervisors = new ArrayList<User>();
		this.supervisors.add(supervisor);
		
		this.participants = new ArrayList<User>();
		
		this.meetings = new ArrayList<Meeting>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getSupervisors() {
		return supervisors;
	}

	public void addSupervisor(User supervisor) {
		this.supervisors.add(supervisor);
	}
	
	public void removeSupervisor(User supervisor) {
		this.supervisors.remove(supervisor);
	}

	public List<User> getParticipants() {
		return participants;
	}

	
	public void addParticipant(User participant) {
		this.participants.add(participant);
	}
	
	public void removeParticipant(User participant) {
		this.participants.remove(participant);
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void addMeeting(Meeting meeting) {
		this.meetings.add(meeting);
	}
	
	public void removeMeeting(Meeting meeting) {
		this.meetings.remove(meeting);
	}
	
	public String toString(){
		return this.name;
	}
	
}
