package com.gproj.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.entities.*;
import com.gproj.idao.IDao;

@Repository("daoRole")
@Transactional
@EnableTransactionManagement
public class DaoRole implements IDao<Role>{
    
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Role> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public Role FindById(int id) {
		return sessionFactory.getCurrentSession().get(Role.class,id);
		}

	@Override
	public Role getOne(String nom) {
		return (Role) sessionFactory.getCurrentSession().createQuery("from Role where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Role obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Role obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Role obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	

}
