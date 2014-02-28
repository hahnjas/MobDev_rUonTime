/**
 * 
 */
package se.kth.mobdev.ruontime.backend;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import se.kth.mobdev.ruontime.model.Group;
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
	
	private List<Group> allGroups;

	private Group selectedGroup;
	
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

	public List<Group> getAllGroups() {
		return allGroups;
	}

	public void setAllGroups(List<Group> allGroups) {
		this.allGroups = allGroups;
	}
	
	@PostConstruct
	public void init(){
		allGroups = new ArrayList<Group>();
		allGroups.add(new Group("group 1", null));
		allGroups.add(new Group("group 2", null));
		allGroups.add(new Group("group 3", null));
		Group group4 = new Group("group 4", null);
		setSelectedGroup(group4);
		allGroups .add(group4);
	}

	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
	
	
}
