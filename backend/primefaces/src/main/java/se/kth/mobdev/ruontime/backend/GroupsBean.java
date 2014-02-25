/**
 * 
 */
package se.kth.mobdev.ruontime.backend;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import se.kth.mobdev.ruontime.model.Group;
import se.kth.mobdev.ruontime.model.User;

/**
 * @author Jasper
 *
 */

@ManagedBean(name = "groupsBean")
public class GroupsBean {
	
//	@ManagedProperty(value = "persistence")
	Persistance store;

	private DualListModel<Group> allGroups;
	
	private Group selectedGroup;
	
	private DualListModel<User> allUsers;

	public DualListModel<Group> getAllGroups() {
		return allGroups;
	}

	public void setAllGroups(DualListModel<Group> allGroups) {
		this.allGroups = allGroups;
	}

	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public DualListModel<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(DualListModel<User> allUsers) {
		this.allUsers = allUsers;
	}
	
	
	@PostConstruct
	public void init(){
		List<Group> source = new ArrayList<Group>();
		List<Group> target = new ArrayList<Group>();
		source.add(new Group("group 1", null));
		source.add(new Group("group 2", null));
		source.add(new Group("group 3", null));
		Group group4 = new Group("group 4", null);
		selectedGroup = group4;
		source.add(group4);
		this.allGroups =  new DualListModel<Group>(source, target); 
		
	}
	
	
}
