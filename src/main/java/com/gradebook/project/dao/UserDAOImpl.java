package com.gradebook.project.dao;

import com.gradebook.project.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManagerFactory;

    @Override
    public List<User> getUsers() {

        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<User> query =
                currentSession.createQuery("from User",User.class);


        return query.getResultList();
    }



}
