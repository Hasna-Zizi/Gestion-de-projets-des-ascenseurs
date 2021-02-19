package com.gproj.dao;
import com.gproj.entities.*;
import com.gproj.idao.IDao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("daoTache")
@Transactional
@EnableTransactionManagement
public class DaoTache implements IDao<Tache> {
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Tache> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Tache").list();
	}

	@Override
	public Tache FindById(int id) {
		return sessionFactory.getCurrentSession().get(Tache.class,id);
	}

	@Override
	public Tache getOne(String nom) {
		return (Tache) sessionFactory.getCurrentSession().createQuery("from Tache where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Tache obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Tache obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Tache obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

}
