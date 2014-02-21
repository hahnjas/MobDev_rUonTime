/**
 * 
 */
package se.kth.mobdev.ruontime.model;

/**
 * @author Jasper
 *
 */
public class User {

	private String username;
	
	private String pwHash;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwHash() {
		return pwHash;
	}

	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}
	
	
	
}
