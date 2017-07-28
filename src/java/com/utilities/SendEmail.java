
package com.utilities;
import com.datamodel.Customer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Random;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SendEmail extends ActionSupport
{
   private String email;
   
    public static Integer generateOTP()
    { 
    Random random=new Random(); 
    Integer OTP= random.nextInt(99999);
    return OTP;
    }
    public static String generateTxnId()
    {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
    public static void sendEmail(String to,String content)
   {
       final String username = "rjvirus100@gmail.com";
       final String password = "rahulvirus100@gmail.com";
       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       
       
       Session session = Session.getInstance(props
                                  ,new javax.mail.Authenticator(){
			          protected PasswordAuthentication getPasswordAuthentication() {
				  return new PasswordAuthentication(username, password);}
		                  });
      try 
      {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress("rjvirus100@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
         message.setSubject("Verify Email via OTP : theBookworm");
         message.setText("Thank You For Registering in bookworm.com\nYour OTP: "+content);
         Transport.send(message);
      }
      catch (MessagingException mex) 
      {
         mex.printStackTrace();
      }
   }
    public static void sendIdPass(String to,String content)
   {
       
       final String username = "rjvirus100@gmail.com";
       final String password = "rahulvirus100@gmail.com";
       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       
       
       Session session = Session.getInstance(props
                                  ,new javax.mail.Authenticator(){
			          protected PasswordAuthentication getPasswordAuthentication() {
				  return new PasswordAuthentication(username, password);}
		                  });
      try 
      {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress("rjvirus100@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
         message.setSubject("Mail From Accessorize.com");
         message.setText(content);
         Transport.send(message);
      }
      catch (MessagingException mex) 
      {
         mex.printStackTrace();
      }
   }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   }