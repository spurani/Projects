package app;

import java.time.LocalDateTime;
import java.util.List;

import dao.CompanyDao;
import dao.DbConnection;
import dao.UserDao;
import model.AdminUser;
import model.Company;
import model.CompanyType;
import model.User;

public class JpaApp2 {
	public static void main(String[] args) {
		System.out.println("-------------------List All Users-----------------");
		UserDao userDao = new UserDao();
		List<User> users = userDao.findAllActive();
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("-------------------List All Users By Type-----------------");
		List<User> usersByType = userDao.findByType(AdminUser.class);
		for (User user : usersByType) {
			System.out.println(user);
		}
		
		System.out.println("-------------------List All Admins-----------------");
		
		List<AdminUser> admins = userDao.findAllAdmins();
		for (AdminUser admin : admins) {
			System.out.println(admin);
			System.out.println(admin.getPrivilege());
		}
		
		System.out.println("------------------------------------");
		
		System.out.println(userDao.findByUsername("asmith"));
		
		System.out.println("-----------------Companies by Name-------------------");
		
		CompanyDao companyDao = new CompanyDao();
		List<Company> companies = companyDao.findByName("Y");
		
		for (Company company : companies) {
			System.out.println(company);
			System.out.println(company.getUsers());
		}
		
		System.out.println("-----------------Companies by Date-------------------");
		
		List<Company> companies2 = companyDao.findByDate(LocalDateTime.of(1990, 1, 1, 0, 0, 0),  LocalDateTime.of(2000, 1, 1, 0, 0, 0));
		
		for (Company company : companies2) {
			System.out.println(company);
		}
		
		System.out.println("----------------Companies by Type--------------------");
		
		List<Company> companies3 = companyDao.findByCompanyType(CompanyType.CORPORATION);
		
		for (Company company : companies3) {
			System.out.println(company);
		}
		
		DbConnection.getInstance().close();
	}
}
