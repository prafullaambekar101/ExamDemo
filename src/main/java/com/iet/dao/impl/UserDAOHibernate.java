package com.iet.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iet.bean.User;
import com.iet.dao.UserDAO;
@Repository
public class UserDAOHibernate implements UserDAO {
	@Autowired SessionFactory sessionFactory;
	@Override
	public User save(User user) {
		Session s=sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		int id=(int) s.save(user);
		user = s.get(User.class, id);
		tr.commit();
		s.close();
		return user;
	}

}
