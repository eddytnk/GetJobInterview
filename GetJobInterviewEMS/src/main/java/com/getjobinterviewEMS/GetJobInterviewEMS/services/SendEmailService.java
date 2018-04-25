package com.getjobinterviewEMS.GetJobInterviewEMS.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.getjobinterviewEMS.GetJobInterviewEMS.dtos.EmailAdress;
import com.getjobinterviewEMS.GetJobInterviewEMS.dtos.SendMailDTO;

@Service
public class SendEmailService {

	@Autowired
	private JavaMailSender sender;

	public void sendEmail(String to, String subject, String content) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(to);
		helper.setText(content);
		helper.setSubject(subject);

		sender.send(message);
	}

	 public void sendEmail(String to, String subject, String content,String attachement) throws Exception{
        MimeMessage message = sender.createMimeMessage();

        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setText(content);
        helper.setSubject(subject);
        ClassPathResource file = new ClassPathResource(attachement);
        helper.addAttachment(attachement, file);
       sender.send(message);
	 }
	 
	 public void sendEmail(SendMailDTO mails) throws Exception {

		  String subject = mails.getSubject();
		  String message = mails.getMessage();
		  
		  for(EmailAdress e:mails.getEmails()){
			  
			MimeMessage msg = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(e.getEmail());
			String content = message.replaceAll(":name", e.getName())
						.replaceAll(":email", e.getEmail());
			helper.setText(content);
			helper.setSubject(subject);

			sender.send(msg);
			//System.out.println(msg.getContent().toString());
		  }
		}
	 
	 
}
