package com.stancu.customerrelationshipmanagement.dao;

import com.stancu.customerrelationshipmanagement.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CustomerDaoImpl implements CustomerDao {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.openSession();

        // create a query  ... sort by last name
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName",
                        Customer.class);

        // execute query and get result list

        // return the results
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session
        Session currentSession = sessionFactory.openSession();
        Transaction txn = currentSession.beginTransaction();
        // save/update the customer ... finally LOL
        currentSession.saveOrUpdate(theCustomer);
        txn.commit();

    }

    @Override
    public Customer getCustomer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.openSession();

        // now retrieve/read from database using the primary key

        return currentSession.get(Customer.class, theId);
    }

    @Override
    @Transactional

    public void deleteCustomer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.openSession();
        Transaction txn = currentSession.beginTransaction();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
        txn.commit();
    }
}












