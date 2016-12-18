/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.DAOImpl;

import com.leapfrog.enquirymanager.DAO.EnquiryStatusDAO;
import com.leapfrog.enquirymanager.entity.Enquirystatus;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "enquirystatusDAO")
public class EnquiryStatusDAOImpl implements EnquiryStatusDAO{
    
    @Autowired
    private SessionFactory sessionfactory;
    private Session session;
    private Transaction trans;

    @Override
    public List<Enquirystatus> getAll() {
        session=sessionfactory.openSession();
       List<Enquirystatus> enquiryStatusList=session.createQuery("SELECT e FROM Enquirystatus e").list();
       session.close();
       return enquiryStatusList;
        

    }

    @Override
    public int insert(Enquirystatus c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquirystatus getById(int id) {
       Enquirystatus enquirystatus=null;
        session=sessionfactory.openSession();
        trans=session.beginTransaction();
        enquirystatus=(Enquirystatus)session.get(Enquirystatus.class, id);
        trans.commit();
        session.close();
        return enquirystatus;
        
        
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquirystatus getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
