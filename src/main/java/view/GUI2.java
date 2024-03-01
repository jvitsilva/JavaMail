package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javamail.envio.ObjetoEnviaEmail;

public class GUI2 {

	JFrame frame;
	GUI1 gui1 = new GUI1();
	
	private JTextField destinatarios;
	private JTextField remetente;
	private JTextField assunto;
	private JTextField conteudo;
	
	private String user;
	private String password;
	private String destinatarioString;
	private String remetenteString;
	private String assuntoString;
	private String conteudoString;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		System.out.println(user + password);
		System.out.println("aqui3");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 587, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel destinoLabel = new JLabel("Destinatários:");
		destinoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		destinoLabel.setBounds(54, 55, 85, 22);
		frame.getContentPane().add(destinoLabel);

		destinatarios = new JTextField();
		destinatarios.setBackground(new Color(255, 255, 255));
		destinatarios.setBounds(149, 48, 302, 29);
		frame.getContentPane().add(destinatarios);
		destinatarios.setColumns(10);
		
		
		
		JLabel remetenteLabel = new JLabel("Remetente:");
		remetenteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		remetenteLabel.setBounds(70, 117, 69, 14);
		frame.getContentPane().add(remetenteLabel);

		remetente = new JTextField();
		remetente.setBounds(149, 110, 302, 29);
		frame.getContentPane().add(remetente);
		remetente.setColumns(10);
		
		
		
		JLabel assuntoLabel = new JLabel("Assunto do email:");
		assuntoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		assuntoLabel.setBounds(39, 169, 100, 41);
		frame.getContentPane().add(assuntoLabel);

		assunto = new JTextField();
		assunto.setBounds(149, 175, 302, 29);
		frame.getContentPane().add(assunto);
		assunto.setColumns(10);
		
		
		
		conteudo = new JTextField();
		conteudo.setHorizontalAlignment(SwingConstants.LEFT);
		conteudo.setBounds(149, 240, 302, 76);
		frame.getContentPane().add(conteudo);
		conteudo.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("(nome)");
		lblNewLabel_3.setBounds(461, 117, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(e-mails)");
		lblNewLabel_4.setBounds(461, 55, 69, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		JButton enviarButton = new JButton("Enviar");
		enviarButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		enviarButton.setBounds(253, 340, 89, 23);
		frame.getContentPane().add(enviarButton);
		
		enviarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				destinatarioString = destinatarios.getText();
				remetenteString = remetente.getText();
				assuntoString = assunto.getText();
				conteudoString = conteudo.getText();
				
				ObjetoEnviaEmail enviaEmail = 
	                    new ObjetoEnviaEmail(user,
	                                        password,
	                                        destinatarioString, 
	                                        remetenteString,
	                                        assuntoString,
	                                        conteudoString);

	            try {
					enviaEmail.enviarEmail(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            //enviaEmail.enviarEmailAnexo(true);
				
			}
		});
		
		
	}
	
	public void recebeDados(String email, String senha) {
		this.user = email;
		this.password = senha;
	}
	
	public String strBuilder() {
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
        stringBuilderTextoEmail.append("Olá, <br></br>");
        stringBuilderTextoEmail.append("Você está recebendo um email teste <br></br>");
        stringBuilderTextoEmail.append("Se você está lendo isto, quer dizer que o projeto está funcionando normalmente <br><br/>");
        stringBuilderTextoEmail.append("Aperte no botão abaixo, você será redirecionado para um site com uma imagem aleatória <br><br/>");

        stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://random.imagecdn.app/5000/2000\" style=\"color:#000000; padding: 14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:30px; font-size: 20px; font-family: courier; border: 3px blue; background-color:#CCCCCC;\" >Clique aqui</a><br><br/>");
        
        stringBuilderTextoEmail.append("<span style=\"font-size:5px\">Projeto feito por João Vitor Silva.</span>");
        return stringBuilderTextoEmail.toString();
	}

}
