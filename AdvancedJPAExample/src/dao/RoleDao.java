package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Role;

public class RoleDao {

	private DbConnection connection;

	public RoleDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public Role create(Role role){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		em.close();
		
		return role;
	}
	
	public void remove(Role role){
		EntityManager em = connection.getEntityManager();
		Role foundRole = em.find(Role.class, role.getId());
		em.getTransaction().begin();
		em.remove(foundRole);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Role role){
		EntityManager em = connection.getEntityManager();
		Role foundRole = em.find(Role.class, role.getId());
		em.getTransaction().begin();
		
		if (role.getName() != null && !role.getName().equals(""))
			foundRole.setName(role.getName());

		em.getTransaction().commit();
		em.close();
	}
	
	public Role findById(int id) {
		EntityManager em = connection.getEntityManager();
		Role role = em.find(Role.class, id);
		em.close();
		return role;
	}
	
	public List<Role> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Role> query = em.createNamedQuery("role.findAll", Role.class);
		List<Role> roles = query.getResultList();
		em.close();
		return roles;
	}
	
	public Role findByName(String name) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Role> query = em.createNamedQuery("role.findByName", Role.class);
		query.setParameter("n", name);
		List<Role> roles = query.getResultList();
		em.close();
		
		if (roles != null && roles.size() == 1){
			return roles.get(0);
		}
		
		return null;
	}
}
