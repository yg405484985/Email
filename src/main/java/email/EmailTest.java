package email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.RecipientStringTerm;

public class EmailTest {
	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.163.com"); 
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		Message msg = getMsg(session,"405484985@qq.com","m15915481543@163.com");
		try {
			Transport transport = session.getTransport();
			transport.connect("m15915481543@163.com", "jing9518000.");
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static Message getMsg(Session session,String addressto,String addressfrom) throws MessagingException{
		MimeMessage message = new MimeMessage(session);
		try {
			message.setContent("Hello","text/html;charset=utf-8");
			message.setSubject("你好");
			message.setSentDate(new Date());
			
			message.setFrom(new InternetAddress(addressfrom,"guang","utf-8"));
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(addressto, "XX用户", "UTF-8"));
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		message.saveChanges();
		
		return message;
	}
}
