package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PersonalCRUD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldSenha;
	private JTextField textFieldLogin;
	private PersonalCRUD controllerPersonal = new PersonalCRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPersonal frame = new CadastroPersonal();
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
	
	
	public CadastroPersonal() {
		setTitle("Cadastro de Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 326, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(24, 46, 102, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 30, 46, 14);
		contentPane.add(lblNome);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(24, 109, 102, 20);
		contentPane.add(textFieldCPF);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(24, 93, 46, 14);
		contentPane.add(lblCPF);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(171, 109, 102, 20);
		contentPane.add(textFieldSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(171, 93, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(171, 46, 102, 20);
		contentPane.add(textFieldLogin);
		
		JLabel lblLogin = new JLabel("Login (email)");
		lblLogin.setBounds(171, 30, 77, 14);
		contentPane.add(lblLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(controllerPersonal.cadastrarPersonal(textFieldNome.getText(), textFieldCPF.getText(), textFieldLogin.getText(), textFieldSenha.getText())) {
					PopUp telaOk = new PopUp("Cadastro Realizado");
					telaOk.show(true);
				}else {
					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
				telaErro.show(true);
				}
			
				//controllerPersonal.cadastrarPersonal(textFieldNome.getText(), textFieldCPF.getText(), textFieldLogin.getText(), textFieldSenha.getText());
			}
		});
		btnCadastrar.setBounds(101, 164, 106, 23);
		contentPane.add(btnCadastrar);
	}
}
