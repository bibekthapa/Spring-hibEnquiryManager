/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.DAOImpl;

import com.leapfrog.enquirymanager.DAO.MessageDAO;
import com.leapfrog.enquirymanager.entity.Message1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "messageDAO")
public class MessageDAOimpl implements MessageDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public Message1 getByName(String name) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        Message1 msg=(Message1)session.get(Message1.class, name);
        trans.commit();
        session.close();
        return msg;

    }
    
}
