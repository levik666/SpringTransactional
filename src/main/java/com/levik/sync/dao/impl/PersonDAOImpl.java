package com.levik.sync.dao.impl;

import com.levik.sync.dao.PersonDAO;
import com.levik.sync.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final String FIND_ALL_PERSON = "from Person";

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Person p) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.persist(p);
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Person> list() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.createQuery(FIND_ALL_PERSON).list();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

}
