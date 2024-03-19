package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javamail.envio.ObjetoEnviaEmail;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;


public class GUI2 {

	JFrame frame;
	GUI1 gui1 = new GUI1();
	
	private JTextField destinatarios,remetente,
						assunto,conteudo,anexo;
	
	private String user,password,destinatarioString,
					remetenteString,assuntoString,conteudoString,caminho;
	
	private File arquivo;
	private Integer controle = 1; //controla a decisao do usuario de fechar o JFileChooser sem nenhum arquivo
	  
	private JButton sairButton, enviarButton, procurarAnexo;
	
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
		
		
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(587, 445);
		frame.setLocationRelativeTo(null);  
		
		
		JLabel destinoLabel = new JLabel("Destinatários:");
		destinoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		destinoLabel.setBounds(54, 51, 85, 22);
		frame.getContentPane().add(destinoLabel);

		destinatarios = new JTextField();
		destinatarios.setBorder(null);
		destinatarios.setBackground(new Color(255, 255, 255));
		destinatarios.setBounds(149, 48, 302, 29);
		frame.getContentPane().add(destinatarios);
		destinatarios.setColumns(10);
		
		
		
		JLabel remetenteLabel = new JLabel("Remetente:");
		remetenteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		remetenteLabel.setBounds(69, 106, 69, 14);
		frame.getContentPane().add(remetenteLabel);

		remetente = new JTextField();
		remetente.setBorder(null);
		remetente.setBounds(149, 99, 302, 29);
		frame.getContentPane().add(remetente);
		remetente.setColumns(10);
		
		
		
		JLabel assuntoLabel = new JLabel("Assunto do email:");
		assuntoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		assuntoLabel.setBounds(39, 152, 100, 41);
		frame.getContentPane().add(assuntoLabel);

		assunto = new JTextField();
		assunto.setBorder(null);
		assunto.setBounds(149, 158, 302, 29);
		frame.getContentPane().add(assunto);
		assunto.setColumns(10);
		
		
		conteudo = new JTextField();
		conteudo.setBorder(null);
		conteudo.setEnabled(true);
		conteudo.setDisabledTextColor(new Color(177, 177, 177));
		conteudo.setHorizontalAlignment(SwingConstants.LEFT);
		conteudo.setBounds(149, 215, 302, 76);
		frame.getContentPane().add(conteudo);
		conteudo.setColumns(10);
		
		
		
		JLabel nomeLabel = new JLabel("(nome)");
		nomeLabel.setBounds(463, 106, 46, 14);
		frame.getContentPane().add(nomeLabel);
		
		JLabel emailsLabel = new JLabel("(e-mails)");
		emailsLabel.setBounds(460, 55, 69, 14);
		frame.getContentPane().add(emailsLabel);
		
		JLabel anexoLabel = new JLabel("Anexo:");
		anexoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		anexoLabel.setBounds(93, 347, 46, 14);
		frame.getContentPane().add(anexoLabel);
		
		anexo = new JTextField();
		anexo.setBounds(149, 344, 203, 20);
		frame.getContentPane().add(anexo);
		anexo.setColumns(10);
		
		
		
		
		// Botões
		
		sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sairButton.setBackground(new Color(208, 232, 230));
		sairButton.setBorder(null);
		sairButton.setBounds(362, 377, 89, 23);
		frame.getContentPane().add(sairButton);
		
		
		
		
		procurarAnexo = new JButton("Procurar");
		procurarAnexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				controle = file.showOpenDialog(null);
				if(controle==0) {
					System.out.println(controle);
					arquivo = file.getSelectedFile().getAbsoluteFile();
					caminho = arquivo.getAbsolutePath();
					anexo.setText(caminho);
				}
				
				
			}
		});
		procurarAnexo.setBounds(201, 375, 89, 23);
		frame.getContentPane().add(procurarAnexo);
		
		
		
		
		JCheckBox msgAuto = new JCheckBox("Mensagem automática");
		msgAuto.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		msgAuto.setHorizontalAlignment(SwingConstants.LEFT);
		msgAuto.setOpaque(false);
		msgAuto.setVerticalTextPosition(SwingConstants.BOTTOM);
		msgAuto.setBounds(228, 298, 161, 26);
		frame.getContentPane().add(msgAuto);
		
		
		msgAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(msgAuto.isSelected()) {
					conteudo.setBackground(new Color(192, 192, 192));
					conteudo.setEnabled(false);
					
					anexo.setEnabled(false);
					anexo.setBackground(new Color(192, 192, 192));
					
					procurarAnexo.setEnabled(false);
					conteudoString = strBuilder();
				} else {
					conteudo.setBackground(new Color(255, 255, 255));
					conteudo.setEnabled(true);
					
					anexo.setEnabled(true);
					anexo.setBackground(new Color(255, 255, 255));
					
					procurarAnexo.setEnabled(true);
					conteudoString = conteudo.getText();
					}
			}
		});

		

		enviarButton = new JButton("Enviar");
		enviarButton.setBackground(new Color(208, 232, 230));
		enviarButton.setBorder(null);
		enviarButton.setBounds(362, 343, 89, 23);
		frame.getContentPane().add(enviarButton);
		
		
		enviarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				destinatarioString = destinatarios.getText();
				remetenteString = remetente.getText();
				assuntoString = assunto.getText();
				
				
				
				if(controle == 0) {
					
					try {
						if(msgAuto.isSelected()) {
							
							ObjetoEnviaEmail enviaEmail = 
				                    new ObjetoEnviaEmail(user,password,destinatarioString,
				                    		     remetenteString,assuntoString,conteudoString);
		            		enviaEmail.enviarEmail(true); 
		            		System.exit(0);
		            		
		            	} else {
		            		
		            		conteudoString = conteudo.getText();
		            		ObjetoEnviaEmail enviaEmail = 
		    	                    new ObjetoEnviaEmail(user,password,destinatarioString,
		    	                    		     remetenteString,assuntoString,conteudoString);
		            		enviaEmail.enviarAnexo(caminho); 
	            		}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					} else{
 			            	try {
				            	
				            	if(msgAuto.isSelected()) {
				            		
				            		ObjetoEnviaEmail enviaEmail = 
		 			   	                    new ObjetoEnviaEmail(user,password,destinatarioString,
		 			   	                    		     remetenteString,assuntoString,conteudoString);
				            		enviaEmail.enviarEmail(true); 
				            		System.exit(0);
				            		
				            	} else {
				            		conteudoString = conteudo.getText();
				            		ObjetoEnviaEmail enviaEmail = 
				    	                    new ObjetoEnviaEmail(user,password,destinatarioString,
				    	                    		     remetenteString,assuntoString,conteudoString);
				            		conteudoString = conteudo.getText();
				            		enviaEmail.enviarEmail(false); 
				            		System.exit(0);
			            		}
			            	} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
			            	}
					  }
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

        stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://source.unsplash.com/random\" style=\"color:#000000; padding: 14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:30px; font-size: 20px; font-family: courier; border: 3px blue; background-color:#CCCCCC;\" >Clique aqui</a><br><br/>");
        
        stringBuilderTextoEmail.append("<span style=\"font-size:5px\">Projeto feito por João Vitor Silva.</span>");
        return stringBuilderTextoEmail.toString();
	}
}
