/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.thread;

import java.util.Properties;
import javax.inject.Scope;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

@Component

public class MessageThread extends Thread {
    
    private String msgFrom;
    private String msgTo;
    private String msgHost;

    public MessageThread(String msgFrom, String msgTo, String msgHost) {
        this.msgFrom = msgFrom;
        this.msgTo = msgTo;
        this.msgHost = msgHost;
    }
    
    

    @Override
    public void run() {
     Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", msgHost);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(msgFrom));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(msgTo));

         // Set Subject: header field
         message.setSubject("Hello");

         // Now set the actual message
         message.setText("hello all how are you");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
      
    }
    
    
    
    
    
}
