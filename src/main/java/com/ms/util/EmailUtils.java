/**
 * 
 */
package com.ms.util;

import java.io.File;

import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

/**
 * @author Sawant
 *
 */
@Component
public class EmailUtils {
    
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String subject,String body,String to,File f)
	{
		try {
			MimeMessage mimeMSg =mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMSg,true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo("manalisawant037@gmail.com");
			
			helper.addAttachment("Plan-Info", f);
			mailSender.send(mimeMSg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
