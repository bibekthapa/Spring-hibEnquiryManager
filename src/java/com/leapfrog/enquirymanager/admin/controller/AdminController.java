/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.admin.controller;

import com.leapfrog.enquirymanager.DAO.CourseDAO;
import com.leapfrog.enquirymanager.DAO.EnquiryDAO;
import com.leapfrog.enquirymanager.DAO.EnquiryStatusDAO;
import com.leapfrog.enquirymanager.entity.Enquiry;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/dashboard/admin/")
public class AdminController {
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private EnquiryDAO enquiryDAO;
    @Autowired
    private EnquiryStatusDAO enquiryStatusDAO;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model)
    {
        model.addAttribute("enquiries", enquiryDAO.getAll());
       
        return "dashboard/admin/enquirylist";
       
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id,Model model)
    {
        model.addAttribute("enquiry",enquiryDAO.getById(id));
         model.addAttribute("courses",courseDAO.getAll());
         model.addAttribute("enquirystatus",enquiryStatusDAO.getAll());
        
     return "dashboard/admin/updateform";   
    }
    
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id)
    {
        enquiryDAO.delete(id);
        return "redirect:/dashboard/admin/";
        
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("enquiry")Enquiry enquiry)
    {
        if(enquiry.getEnquiryId()==null)
        {
            enquiryDAO.insert(enquiry);
        }
        else{
        enquiryDAO.update(enquiry.getEnquiryId());
        }
        return "redirect:/dashboard/admin/"; // In redirect jsp source is not given , over here the request mappting value is given
    }
    
}
