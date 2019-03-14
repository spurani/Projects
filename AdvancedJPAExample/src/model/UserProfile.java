package model;

import javax.persistence.Embeddable;

@Embeddable
public class UserProfile {

	private String address;
	private int age;
	
	public UserProfile() {
		super();
	}
	
	public UserProfile(String address, int age) {
		super();
		this.address = address;
		this.age = age;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserProfile [address=" + address + ", age=" + age + "]";
	}
}
