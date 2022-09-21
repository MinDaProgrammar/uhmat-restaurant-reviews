package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

 
public class GmailSMTPAuthenticator extends Authenticator{
    
    PasswordAuthentication pa;
    
    public GmailSMTPAuthenticator() {
        String mail_id = System.getenv("SMTP_USER");          // Gmail account used to send mail
        String mail_pw = System.getenv("SMTP_APP_PASSWORD");  // Gmail app password
        
        pa = new PasswordAuthentication(mail_id, mail_pw);
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
