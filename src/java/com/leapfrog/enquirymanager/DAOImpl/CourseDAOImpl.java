/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.DAOImpl;

import com.leapfrog.enquirymanager.DAO.CourseDAO;
import com.leapfrog.enquirymanager.entity.Courses;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;
    
    @Override
    public List<Courses> getAll() {
        session=sessionFactory.openSession();
       List<Courses> courselst=session.createQuery("SELECT d FROM Courses d").list();
        session.close();
        return courselst;  
    }

    @Override
    public int insert(Courses c) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        int result=(int)session.save(c);
        trans.commit();
        session.close();
        return result;
        

    }

    @Override
    public Courses getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
