/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.DAO;

import java.util.List;

/**
 *
 * @author HOME
 */
public interface GenericDAO <T>{
    
    public List<T> getAll();
    int insert(T c);
    T getById(int id);
    void delete(int id);
    void update(int id);
    
}
