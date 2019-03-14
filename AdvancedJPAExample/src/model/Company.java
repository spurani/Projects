package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_COMPANY")
@NamedQueries({
	@NamedQuery(name = "company.findByName", query = "SELECT c FROM Company c WHERE c.name LIKE :cn"),
	@NamedQuery(name = "company.findByDate", query = "SELECT c FROM Company c WHERE c.established BETWEEN :fr AND :to"),
	@NamedQuery(name = "company.findByCompanyType", query = "SELECT c FROM Company c WHERE c.companyType = :ct")
})
@SecondaryTables({
	@SecondaryTable(name = "JPA_COMPANY_PROFILE", pkJoinColumns = @PrimaryKeyJoinColumn)
})
public class Company {

	@Id
	@SequenceGenerator(name = "companySequence", sequenceName="COMPANY_CUSTOM_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companySequence")
	@Column(name = "company_id")
	private int id;
	
	@Column(name = "company_name")
	private String name;
	
	@OneToMany(mappedBy = "company")
	private List<User> users;
	
	@Column(table = "JPA_COMPANY_PROFILE")
	private String address;
	
	@Column(table = "JPA_COMPANY_PROFILE")
	private int numOfEmployees;
	
	@Column(table = "JPA_COMPANY_PROFILE")
	//@Convert(converter = LocalDateTimeAttributeConverter.class) /*If autoapply is set to false, you need to add the javax.persistence.Convert annotation to all attributes that shall be converted and specify the Converter class.*/
	private LocalDateTime established;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Stock stock;
	
	@Column(name = "company_type")
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;

	public Company() {
		super();
	}
	
	public Company(String name, String address, int numOfEmployees, LocalDateTime established) {
		super();
		this.name = name;
		this.address = address;
		this.numOfEmployees = numOfEmployees;
		this.established = established;
	}

	public Company(String name, String address, int numOfEmployees, LocalDateTime established, Stock stock, CompanyType companyType) {
		super();
		this.name = name;
		this.address = address;
		this.numOfEmployees = numOfEmployees;
		this.established = established;
		this.stock = stock;
		this.companyType = companyType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public LocalDateTime getEstablished() {
		return established;
	}

	public void setEstablished(LocalDateTime established) {
		this.established = established;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", numOfEmployees=" + numOfEmployees
				+ ", established=" + established + ", stock=" + stock + ", companyType=" + companyType + "]";
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
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
