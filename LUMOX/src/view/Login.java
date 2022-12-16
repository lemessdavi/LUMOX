package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AtletaCRUD;
import controller.PersonalCRUD;
import model.Atleta;
import model.Personal;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setForeground(new Color(255, 255, 255));
		textFieldLogin.setBackground(new Color(76, 76, 76));
		textFieldLogin.setBounds(245, 175, 210, 30);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(245, 217, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Login");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBounds(245, 155, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnCadastrase = new JButton("Cadastra-se");
		btnCadastrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarConta tela = new CriarConta();
				tela.show();
			}
		});
		btnCadastrase.setForeground(new Color(255, 255, 255));
		btnCadastrase.setBackground(new Color(76, 76, 76));
		btnCadastrase.setBounds(298, 326, 104, 23);
		contentPane.add(btnCadastrase);
		
		final JCheckBox chckbxPersonal = new JCheckBox("Personal");
		chckbxPersonal.setForeground(new Color(255, 255, 255));
		chckbxPersonal.setBackground(new Color(44, 44, 44));
		chckbxPersonal.setBounds(313, 357, 75, 23);
		contentPane.add(chckbxPersonal);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(20, 167, 245));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!chckbxPersonal.isSelected()) {
					AtletaCRUD crud = new AtletaCRUD();
					Atleta atleta = crud.verifyLogin(textFieldLogin.getText(),textFieldSenha.getText());
					System.out.println("tela login " + atleta.getId());
					if(atleta !=null) {
						HomeAtleta home = new HomeAtleta(atleta);
						home.show();
					}else {
						PopUp pop = new PopUp("Atleta nao existe");
						pop.show();
					}
				} else {
					PersonalCRUD crud = new PersonalCRUD();
					Personal personal = crud.verifyLogin(textFieldLogin.getText(),textFieldSenha.getText());
					if (personal != null) {
						HomePersonal home = new HomePersonal(personal);
						home.show();
					}else {
						PopUp pop = new PopUp("Personal nao existe");
						pop.show();
					}
					
				}
					
			}
		});
		btnLogin.setBounds(306, 291, 89, 23);
		contentPane.add(btnLogin);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setForeground(new Color(255, 255, 255));
		textFieldSenha.setBackground(new Color(76, 76, 76));
		textFieldSenha.setBounds(245, 236, 210, 30);
		contentPane.add(textFieldSenha);
		
		JLabel lblNewLabel_1 = new JLabel("LUMOX");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(298, 105, 104, 38);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
