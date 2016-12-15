/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.DAOImpl;

import com.leapfrog.enquirymanager.DAO.EnquiryDAO;
import com.leapfrog.enquirymanager.entity.Enquiry;
import com.leapfrog.enquirymanager.entity.Enquirystatus;
import java.util.List;
import javax.ws.rs.client.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HOME
 */
@Repository(value = "enquiryDAO")
public class EnquiryDAOimpl implements EnquiryDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public List<Enquiry> getAll() {
        session=sessionFactory.openSession();
        List<Enquiry> enquirylst=session.createQuery("SELECT e FROM Enquiry e").list();
        session.close();
        return enquirylst;

    }

    @Override
    public int insert(Enquiry c) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        int result=(int)session.save(c);
        trans.commit();
        session.close();
        return result;

    }

    @Override
    public Enquiry getById(int id) {
        Enquiry e=null;
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        e=(Enquiry)session.get(Enquiry.class, id);
        trans.commit();
        session.close();
        return e;

    }

    @Override
    public void delete(int id) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        Enquiry e=(Enquiry)session.get(Enquiry.class, id);
        session.delete(e);
        trans.commit();
        session.close();
       

    }

    @Override
    public void update(int id) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        Client c=(Client)session.get(Enquiry.class, id);
        session.update(c);
        trans.commit();
        session.close();

    }
    
   

    

}
