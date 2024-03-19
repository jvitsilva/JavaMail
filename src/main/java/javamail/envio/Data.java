package javamail.envio;

public class Data {
	
	protected String user; //email
    protected String password;
    protected String recipientList; //lista de destinatários
    protected String sender; //quem está enviando, remetente
    protected String emailSubject; //Título do email, assunto do email
    protected String emailContent; // conteúdo do email

    public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public Data(String user, String password, String recipienteList, String sender, String emailSubject, String emailContent){
        this.user = user;
        this.password = password;
        this.recipientList = recipienteList;
        this.sender = sender;
        this.emailSubject = emailSubject; 
        this.emailContent = emailContent;
    }
    
}
