package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

	/**
	 * Create the application.
	 */
	public GUI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 587, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel1 = new JLabel("Bem vindo ao JavaMail");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblNewLabel1.setBounds(140, 35, 289, 43);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Primeiro, digite seu email e senha");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(191, 94, 182, 18);
		frame.getContentPane().add(lblNewLabel2);
		
		JLabel lblNewLabel3 = new JLabel("(Não se preocupe, eles estarão seguros, ");
		lblNewLabel3.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel3.setBounds(132, 121, 296, 19);
		frame.getContentPane().add(lblNewLabel3);

		JLabel lblMasTenhaCerteza = new JLabel("mas tenha certeza que estão corretos! )");
		lblMasTenhaCerteza.setBounds(183, 144, 207, 14);
		frame.getContentPane().add(lblMasTenhaCerteza);
		
		JLabel lblNewLabel4 = new JLabel("Email:");
		lblNewLabel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel4.setBounds(159, 189, 58, 18);
		frame.getContentPane().add(lblNewLabel4);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("");
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setDropMode(DropMode.INSERT);
		textFieldEmail.setBounds(169, 222, 227, 24);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		
		
		JLabel lblNewLabel5 = new JLabel("Senha:");
		lblNewLabel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel5.setBounds(158, 257, 58, 18);
		frame.getContentPane().add(lblNewLabel5);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(170, 286, 227, 24);
		frame.getContentPane().add(passwordField);
		
		JCheckBox exibirSenha = new JCheckBox("Mostrar");
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
		exibirSenha.setBounds(414, 287, 97, 23);
		frame.getContentPane().add(exibirSenha);
			
		
		
		
		buttonNext = new JButton("Avançar");
		buttonNext.setBounds(224, 331, 101, 27);
		frame.getContentPane().add(buttonNext);
		
		
		
		buttonNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI2 window2 = new GUI2();
				email = textFieldEmail.getText();
				password = new String(passwordField.getPassword());
				window2.recebeDados(email, password);
				
				EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									System.out.println("aqui1");
									System.out.println(email+password);
									System.out.println("aqui2");
									
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
