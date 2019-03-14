package com.mypackage.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mypackage.dao.IUser;
import com.mypackage.model.IStorable;
import com.mypackage.model.T_User;

public class UserDao implements IUser {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public UserDao() {
		super();
		emf = Persistence.createEntityManagerFactory("SpringMVC");
		em = emf.createEntityManager();
	}

	
	@Override
	public boolean create(T_User t) {
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		em.close();
		return false;
	}

	@Override
	public boolean delete(T_User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T_User readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(T_User t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<T_User> readAll() {
		List <T_User> allUsers = new ArrayList<T_User>();
		
		Query query = em.createQuery("SELECT u FROM T_User u", T_User.class );
		allUsers = query.getResultList();
		
		System.out.println(">>>AllUsers: " + allUsers);
		
		return allUsers;
	}
	
	public T_User userByUsernameAndPassword(String username, String pw){
		List <T_User> found = new ArrayList<T_User>();
		Query query = em.createQuery("SELECT u FROM T_User u WHERE u.username = '" + username +"' AND u.password = '" + pw +"'", T_User.class );

		found = query.getResultList();

		T_User foundUser = found.get(0);
		return foundUser;
	}

}
