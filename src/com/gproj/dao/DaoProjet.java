package com.gproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.entities.Projet;
import com.gproj.idao.IDao;

@Repository("daoProjet")
@Transactional
@EnableTransactionManagement
public class DaoProjet implements IDao<Projet>{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Projet> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Projet").list();
	}

	@Override
	public Projet FindById(int id) {
		return sessionFactory.getCurrentSession().get(Projet.class,id);
	}

	@Override
	public Projet getOne(String nom) {
		return (Projet) sessionFactory.getCurrentSession().createQuery("from Projet where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Projet obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Projet obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Projet obj) {
		try {	
			System.out.println(obj);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	} 
	

}
