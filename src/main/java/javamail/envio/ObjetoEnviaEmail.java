package javamail.envio;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class ObjetoEnviaEmail extends Data{
    

    public ObjetoEnviaEmail(String user, String password, String recipienteList, String sender, String emailSubject,
            String emailContent) {
        super(user, password, recipienteList, sender, emailSubject, emailContent);
    }

    Properties properties = new Properties();


    public void enviarEmail(Boolean envioHTML) throws Exception {
        
        try{ 
                properties();

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(user, password);
                    }
                });

                Address[] toUser = InternetAddress.parse(recipientList);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(user, sender));
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject(emailSubject);
                if (envioHTML){
                    message.setContent(emailContent, "text/html; charset=utf-8");
                } else{
                    message.setText(emailContent);
                }
                
                
                Transport.send(message);

            }catch (Exception e){
                e.printStackTrace();
                }

    }

    
    
    /*
     * Esse método simula o PDF ou qualquer arquivo que possa ser enviado em anexo por email,
     * você pode pegar seu arquivo no banco de dados base64, byte[], stream de arquivos.
     * Pode estar em um banco de dados ou uma pasta.
     * 
     * Retorna um PDF em branco com o texto do parágrafo de exemplo
     */
     

     public void enviarAnexo(String caminho) throws Exception {
        
        try{ 

        properties();
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(user, password.toString());
            }
        });

        Address[] toUser = InternetAddress.parse(recipientList);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user, sender));
        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject(emailSubject);
        
        MimeBodyPart corpoemail = new MimeBodyPart();
       
        corpoemail.setText(emailContent);
        
        
     // Anexo
        

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(corpoemail);
        
        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.attachFile(caminho);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);
        
        Transport.send(message);

            }catch (Exception e){
                e.printStackTrace();
                }

    }

    private void properties(){
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.auth", "true"); // Autorizacão
        properties.put("mail.smtp.starttls.enable", "true"); // Autenticacão
        properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor gmail Google
    	properties.put("mail.smtp.port", "465"); // Porta do servidor
        properties.put("mail.smtp.socketFactory.port", "465"); // Expecifica a porta a ser conectada pelo socket
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket de conexão ao SMTP
    }
     
}
