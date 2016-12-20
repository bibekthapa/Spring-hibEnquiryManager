/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.controller;

import com.leapfrog.enquirymanager.DAO.CourseDAO;
import com.leapfrog.enquirymanager.DAO.EnquiryDAO;
import com.leapfrog.enquirymanager.DAO.EnquiryStatusDAO;
import com.leapfrog.enquirymanager.DAO.MessageDAO;
import com.leapfrog.enquirymanager.entity.Courses;
import com.leapfrog.enquirymanager.entity.Enquiry;
import com.leapfrog.enquirymanager.entity.Message1;
import com.leapfrog.enquirymanager.thread.MessageThread;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private EnquiryDAO enquiryDAO;
    
    @Autowired
    private EnquiryStatusDAO enquiryStatusDAO;
    
    @Autowired
    private MessageDAO messageDAO;
    
    @Autowired
    private MessageThread msgthread;

    @RequestMapping(method = RequestMethod.GET)
    
    
     public String index(Model model) {
       model.addAttribute("courses", courseDAO.getAll());
        model.addAttribute("enquirystatus",enquiryStatusDAO.getAll());
        return "dashboard/index";
    }

    public String index1(Model model) {
        model.addAttribute("courses", courseDAO.getAll());
        model.addAttribute("enquirystatus",enquiryStatusDAO.getAll());
        return "dashboard/admin/";
    }
    
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)
    {
        model.addAttribute("enquiries",enquiryDAO.getAll());
        return "dashboard/list";
    
    
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String save(@ModelAttribute("enquiry")Enquiry enquiry ) {

        enquiryDAO.insert(enquiry);
        return "redirect:/dashboard/list";

    }
    
    @RequestMapping(value = "/sendmail/{id}",method = RequestMethod.GET)
    
    public String testMail(Model model,@PathVariable("id")int id){
        
       model.addAttribute("enquiry",enquiryDAO.getById(id));
       model.addAttribute("msgFrom",messageDAO.getByName("MSG_FROM"));
       model.addAttribute("msgHost",messageDAO.getByName("MSG_HOST"));
        
     
      return "dashboard/admin/messageform";
    }
    
    @RequestMapping(value = "/send1",method = RequestMethod.POST)
    public String sendMail(HttpServletRequest request)
    {
        
        
     String to = request.getParameter("enquiryEmail");
     
     
      // Sender's email ID needs to be mentioned
      String from = request.getParameter("name");
     
      // Assuming you are sending email from localhost
      String host = request.getParameter("host");

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(request.getParameter("subject"));

         // Now set the actual message
         message.setText(request.getParameter("message"));

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
      
      return "redirect:/dashboard/admin/";
    
    
    }
    
    @RequestMapping(value="/sendall",method = RequestMethod.GET)
    public String sendAll(Model model)
    {
        model.addAttribute("enquiries",enquiryDAO.getAll());
        model.addAttribute("msgFrom",messageDAO.getByName("MSG_FROM"));
         model.addAttribute("msgHost",messageDAO.getByName("MSG_HOST"));
    
     return "dashboard/admin/msgformforall";
    }
    
    @RequestMapping(value="/send",method = RequestMethod.POST)
    public String sendEmailToall()
    {
        
        
        String to ="bibek.thapahere@gmail.com";
        String from ="dixanta@gmail.com";
        String host="smtp.ntc.net.np";
        msgthread=new MessageThread(from,to,host);
        
        
    
    return null;
    }
}
