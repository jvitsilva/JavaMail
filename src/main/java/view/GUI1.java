package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Cursor;

public class GUI1 {
	
	public JFrame frame;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JButton buttonNext;
	private String email;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GUI1() {
		try {
			initialize();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(208, 232, 230));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(587, 445);
		frame.setLocationRelativeTo(null);  
		

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("OptionPane.border"));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(90, 25, 416, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel welcomeLabel = new JLabel("Bem vindo ao JavaMail");
		welcomeLabel.setBounds(0, 11, 416, 48);
		panel.add(welcomeLabel);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		
		
		JLabel label3 = new JLabel("mas tenha certeza que estão corretos.");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setBounds(85, 141, 249, 14);
		panel.add(label3);
				
				
				
		
				

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(74, 166, 58, 18);
		panel.add(emailLabel);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(74, 200, 260, 24);
		panel.add(textFieldEmail);
		textFieldEmail.setBorder(null);
		textFieldEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		textFieldEmail.setToolTipText("");
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setDropMode(DropMode.INSERT);
		textFieldEmail.setColumns(10);
		
		
		
		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setBounds(74, 235, 58, 18);
		panel.add(senhaLabel);
		senhaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				
		passwordField = new JPasswordField();
		passwordField.setBounds(75, 264, 259, 24);
		panel.add(passwordField);
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 15));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
				
		
		
		// Botões
		buttonNext = new JButton("Log In");
		buttonNext.setBounds(153, 299, 101, 27);
		panel.add(buttonNext);
		buttonNext.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		buttonNext.setBorder(null);
		buttonNext.setBackground(new Color(208, 232, 230));
		
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sairButton.setBorder(null);
		sairButton.setBackground(new Color(208, 232, 230));
		sairButton.setBounds(153, 337, 101, 23);
		panel.add(sairButton);
		
		JLabel label1 = new JLabel("Login de acesso");
		label1.setBounds(109, 66, 207, 24);
		panel.add(label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label2 = new JLabel("Não se preocupe, eles estarão seguros, ");
		label2.setBounds(65, 118, 296, 19);
		panel.add(label2);
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		

		// Exibicão da senha
		JCheckBox exibirSenha = new JCheckBox("Mostrar");
		exibirSenha.setBounds(339, 265, 71, 23);
		panel.add(exibirSenha);
		exibirSenha.setOpaque(false);
		exibirSenha.setBackground(new Color(192, 192, 192));
		exibirSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		exibirSenha.addMouseListener((MouseListener) new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		if (exibirSenha.isSelected()) {
		passwordField.setEchoChar((char) 0);
		} else {
		passwordField.setEchoChar('*');
		}
		}
		});
		
		
		
		buttonNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI2 window2 = new GUI2();
				email = textFieldEmail.getText();
				password = new String(passwordField.getPassword());
				window2.recebeDados(email, password);
				
				frame.dispose(); //desabilita o primeiro frame
				
				EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									
									window2.frame.setVisible(true);
									
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				
				
			
		});
		
		
	}
}
