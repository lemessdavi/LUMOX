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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

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
		setBounds(100, 100, 583, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(64, 86, 210, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(64, 67, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(64, 177, 210, 28);
		contentPane.add(textFieldSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(64, 158, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnCadastrase = new JButton("Cadastra-se");
		btnCadastrase.setBounds(396, 284, 104, 23);
		contentPane.add(btnCadastrase);
		
		final JCheckBox chckbxPersonal = new JCheckBox("Personal");
		chckbxPersonal.setBounds(414, 138, 97, 23);
		contentPane.add(chckbxPersonal);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!chckbxPersonal.isSelected()) {
					AtletaCRUD crud = new AtletaCRUD();
					Atleta atleta = crud.verifyLogin(textFieldLogin.getText(),textFieldSenha.getText());
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
		btnLogin.setBounds(117, 284, 89, 23);
		contentPane.add(btnLogin);
		
	
	}
}
