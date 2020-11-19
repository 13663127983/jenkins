package com.freemarker;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.webtest.utils.ReadProperties;

import net.sf.saxon.functions.StaticBaseURI;

public class MailUtil {
	static String server;
	static String from;
	static String protocol;
	static String sender;
	static String auth_code;
	static {
		try {
			 server=ReadProperties.getPropertyValue("server");
			 from=ReadProperties.getPropertyValue("from");
			 protocol=ReadProperties.getPropertyValue("protocol");
			 sender=ReadProperties.getPropertyValue("sender");
			 auth_code=ReadProperties.getPropertyValue("auth_code");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void sendEmail(String email, String subject, String body) throws UnsupportedEncodingException {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.transport.protocol", protocol);
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.host", server);
			
			Session session=Session.getInstance(props, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(sender, auth_code);
				}
				
			});
			
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());

			InternetAddress fromAddress = new InternetAddress(sender, from, "UTF-8");
			msg.setFrom(fromAddress);
			String emailList[] = email.split(",");
			InternetAddress[] toAddress = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++) {
				toAddress[i] = new InternetAddress(emailList[i]);
			}
			// msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.addRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject, "UTF-8");
			msg.setContent(body, "text/html;charset=utf-8");
			msg.saveChanges();
			Transport.send(msg, msg.getAllRecipients());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}