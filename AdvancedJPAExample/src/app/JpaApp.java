package app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.CompanyDao;
import dao.DbConnection;
import dao.RoleDao;
import dao.UserDao;
import model.AdminUser;
import model.Company;
import model.CompanyType;
import model.Role;
import model.Stock;
import model.User;
import model.UserProfile;

public class JpaApp {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		RoleDao roleDao = new RoleDao();
		CompanyDao companyDao = new CompanyDao();
		
		Stock s1 = new Stock("GGL", 230.65F);
		Stock s2 = new Stock("MS", 78.21F);
		Stock s3 = new Stock("Y!", 20.46F);
		
		Company c1 = new Company("Google", "Mountain View, CA", 10000, LocalDateTime.of(1998, 10, 1, 0, 0, 0), s1, CompanyType.CORPORATION);
		Company c2 = new Company("Microsoft", "Redmond, WA", 15000, LocalDateTime.of(1980, 2, 1, 0, 0, 0), s2, CompanyType.LP);
		Company c3 = new Company("Yahoo!", "Sunnyvale, CA", 20000, LocalDateTime.of(1994, 4, 1, 0, 0, 0), s3, CompanyType.CORPORATION);
		
		companyDao.create(c1);
		companyDao.create(c2);
		companyDao.create(c3);
		
		Role r1 = new Role("Admin"); 
		Role r2 = new Role("Employee"); 
		Role r3 = new Role("Employer"); 
		
		roleDao.create(r1);
		roleDao.create(r2);
		roleDao.create(r3);
		
		List<Role> roles1 = new ArrayList<>();
		List<Role> roles2 = new ArrayList<>();
		List<Role> roles3 = new ArrayList<>();
		
		roles1.add(roleDao.findByName("Admin"));
		roles1.add(roleDao.findByName("Employer"));
		
		roles2.add(roleDao.findByName("Admin"));
		roles2.add(roleDao.findByName("Employee"));
		
		roles3.add(roleDao.findByName("Admin"));
		roles3.add(roleDao.findByName("Employee"));
		roles3.add(roleDao.findByName("Employer"));
		
		User u1 = new User("jdoe", "1234", "John", "Doe", new UserProfile("Toronto, ON", 23), companyDao.findById(c1.getId()), roles1, true);
		User u2 = new User("asmith", "5678", "Alex", "Smith", new UserProfile("London, ON", 28), companyDao.findById(c2.getId()), roles2, true);
		AdminUser u3 = new AdminUser("mjane", "9012", "Mary", "Jane", new UserProfile("Vancouver, BC", 25), companyDao.findById(c3.getId()), roles3, true);
		u3.setPrivilege("Some privileges....");
		
		userDao.create(u1);
		userDao.create(u2);
		userDao.create(u3);
		
		System.out.println("Data stored.");
		
		DbConnection.getInstance().close();
	}
}
