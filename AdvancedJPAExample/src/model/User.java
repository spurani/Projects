package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_USER")
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING, length = 20)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "user.findAllActive", query = "SELECT u FROM User u WHERE u.active = true"),
	@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u where u.username = :uname"),
	@NamedQuery(name = "user.findAllAdmins", query = "SELECT u FROM AdminUser u where TYPE(u) = AdminUser"),
	@NamedQuery(name = "user.findByType", query = "SELECT u FROM User u where TYPE(u) = :type")
})
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String username;
	
	@Column(name = "pw", length = 30, nullable = false)
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Embedded
	private UserProfile profile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "JPA_USER_ROLE")
	private List<Role> roles;
	
	@Column(columnDefinition = "Number(1)")
	private boolean active;
	
	public User() {
		super();
	}

	public User(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public User(String username, String password, String firstname, String lastname, UserProfile profile) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profile = profile;
	}
	
	public User(String username, String password, String firstname, String lastname, UserProfile profile, Company company) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profile = profile;
		this.company = company;
	}
	
	public User(String username, String password, String firstname, String lastname, UserProfile profile,
			Company company, List<Role> roles, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profile = profile;
		this.company = company;
		this.roles = roles;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", profile=" + profile + ", company=" + company + ", roles=" + roles
				+ ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
