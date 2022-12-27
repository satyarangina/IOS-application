package com.motivity.interview.serviceimpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSender {

	@Autowired
	JavaMailSender javaMailSender;
	boolean html = false;
	public void mailSender(String to, String subject, String text) {
		try{
            MimeMessage mail=javaMailSender.createMimeMessage();
            MimeMessageHelper message=new MimeMessageHelper(mail);
            html=true;
            
            message.setFrom("motivityhospital@gmail.com","MLHR-TEAM");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text,html);
           
            javaMailSender.send(mail);
        }
        catch(Exception e){
            
        }    
		
	}
}
