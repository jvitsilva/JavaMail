package javamail.envio;

public class Data {
	
	protected String user; //email
    protected String password;
    protected String recipientList; //lista de destinatários
    protected String sender; //quem está enviando, remetente
    protected String emailSubject; //Título do email, assunto do email
    protected String emailContent; // conteúdo do email

    public Data(String user, String password, String recipienteList, String sender, String emailSubject, String emailContent){
        this.user = user;
        this.password = password;
        this.recipientList = recipienteList;
        this.sender = sender;
        this.emailSubject = emailSubject; 
        this.emailContent = emailContent;
    }
    
    /*private String user = "enviaemailtestejava@gmail.com"; //email
    private String password = "clfc mpfl yxcs qtmr";
    private String recipientList = "vitsilva900@gmail.com"; //lista de destinatários
    private String sender = "Vitor"; //quem está enviando, remetente
    private String emailSubject = "Projeto JavaMail"; //Título do email, assunto do email
    private String emailContent = "Ola programador, voce acaba de receber um email enviado de um projeto de envio de emails desenvolvido por Joao Vitor"; // conteúdo do email
    */

}
