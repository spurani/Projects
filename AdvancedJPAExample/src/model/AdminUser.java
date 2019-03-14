package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity //Although it extends User, we still need to explicitly define it as an entity.
@DiscriminatorValue(value = "Admin")
public class AdminUser extends User {

	private String privilege;
	
	public AdminUser() {
		super();
	}

	public AdminUser(String username, String password, String firstname, String lastname, UserProfile profile,
			Company company, List<Role> roles, boolean active) {
		super(username, password, firstname, lastname, profile, company, roles, active);
	}

	public AdminUser(String username, String password, String firstname, String lastname, UserProfile profile,
			Company company) {
		super(username, password, firstname, lastname, profile, company);
	}

	public AdminUser(String username, String password, String firstname, String lastname, UserProfile profile) {
		super(username, password, firstname, lastname, profile);
	}

	public AdminUser(String username, String password, String firstname, String lastname) {
		super(username, password, firstname, lastname);
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
