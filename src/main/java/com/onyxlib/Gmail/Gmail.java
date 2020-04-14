package com.onyxlib.Gmail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import com.onyxlib.Gmail.ConfigWorker.*;
import com.onyxlib.ObjectDeserializer.*;

  public class Gmail {
    private String user, recipient, host, password, subject, text;
    private int port;
    boolean html;
    private String WarningMessage_LessSecureApps = "Allow Less Secure Apps has to be enabled.";
	    public Gmail(String pUser, String pRecipient, String pHost, int pPort, String pPassword, String pSubject, String pText, boolean pHtml) {
	           System.out.println("\n\r"+WarningMessage_LessSecureApps+"\n\r");
	           this.user = pUser;
	           this.recipient = pRecipient;
	           this.host = pHost;
	           this.password = pPassword;
	           this.subject = pSubject;
	           this.text = pText;
	           this.port = pPort;
	           this.html = pHtml;
	      }
    	public Gmail(ConfigWorker pSettings, String pRecipient, String pSubject, String pText, boolean pHtml) {
    		this.user = pSettings.getConfigUser();
    		this.host = pSettings.getConfigHost();
    		this.port = pSettings.getConfigPort();
    		this.password = pSettings.getConfigPassword();
    		this.html = pHtml;
            this.text = pText;
            this.subject = pSubject;
            this.recipient = pRecipient;
    	}
    	public Gmail(String pConfigPath, String pRecipient, String pSubject, String pText, boolean pHtml) throws IOException {
    		ObjectDeserializer<ConfigWorker> configDeserializer = new ObjectDeserializer<ConfigWorker>(pConfigPath);
    		ConfigWorker tmp;
    		try {
        	tmp = configDeserializer.deserializeObject();
        	this.user = tmp.getConfigUser();
    		this.host = tmp.getConfigHost();
    		this.port = tmp.getConfigPort();
    		this.password = tmp.getConfigPassword();
    		this.html = pHtml;
            this.text = pText;
            this.subject = pSubject;
            this.recipient = pRecipient;
    		} catch(IOException ioex) {
    			ioex.printStackTrace();
    			System.exit(0b00);
    		}
    	}

      public void sendMail() {
             Properties props = new Properties();
             props.put("mail.smtp.host", host);
             props.put("mail.smtp.port", port);
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.socketFactory.port", port);
             props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
             Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                               return new PasswordAuthentication(user, password);
                       }
               });
               session.setDebug(true);
               try {
                   Message msg = new MimeMessage(session);
                   msg.setFrom(new InternetAddress(user));
                   msg.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
                    msg.setSubject(subject);
                    if(html == true) {
                            msg.setContent(text+"\n\n\n\n"+"sent by com.KronyxLib.Gmail", "text/html");
                      } else {
                            msg.setText(text+"\n\n\n\n"+"sent by com.KronyxLib.Gmail");
                        }
                    Transport.send(msg);
                    System.out.println("\n\r"+"Email sent succsessfully."+"\n\r");
               } catch(MessagingException mex) {
               mex.printStackTrace();
               }
      }
  }