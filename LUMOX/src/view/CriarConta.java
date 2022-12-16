package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CriarConta {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfSenha;
	private JTextField tfSobrenome;
	private JTextField tfDataNascimento;
	private JTextField tfConfEmail;
	private JTextField tfConfSenha;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarConta window = new CriarConta();
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
	public CriarConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(44, 44, 44));
		frame.setBounds(100, 100, 715, 470);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cbEscolheFuncao = new JComboBox();
		cbEscolheFuncao.setForeground(new Color(255, 255, 255));
		cbEscolheFuncao.setBackground(new Color(76, 76, 76));
		cbEscolheFuncao.setBounds(336, 120, 29, 21);
		frame.getContentPane().add(cbEscolheFuncao);
		
		JLabel lblNewLabel_1 = new JLabel("Crie uma nova conta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(268, 90, 166, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		tfNome.setBounds(12, 141, 241, 26);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(12, 120, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(12, 179, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBounds(12, 239, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBounds(12, 302, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Sobrenome");
		lblNewLabel_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5.setBounds(448, 120, 75, 13);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Data de Nascimento");
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setBounds(448, 179, 143, 13);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Confirmar e-mail");
		lblNewLabel_1_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_7.setBounds(448, 239, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Confirmar senha");
		lblNewLabel_1_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_8.setBounds(448, 302, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_8);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBackground(new Color(20, 167, 245));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarConta.setBounds(308, 367, 105, 21);
		frame.getContentPane().add(btnCriarConta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(308, 400, 105, 21);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_1_9 = new JLabel("LUMOX");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_9.setBounds(318, 46, 70, 38);
		frame.getContentPane().add(lblNewLabel_1_9);
		
		tfCpf = new JTextField();
		tfCpf.setBackground(new Color(76, 76, 76));
		tfCpf.setForeground(new Color(255, 255, 255));
		tfCpf.setColumns(10);
		tfCpf.setBounds(12, 201, 241, 26);
		frame.getContentPane().add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setForeground(new Color(255, 255, 255));
		tfEmail.setColumns(10);
		tfEmail.setBounds(12, 264, 241, 26);
		frame.getContentPane().add(tfEmail);
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setForeground(new Color(255, 255, 255));
		tfSenha.setColumns(10);
		tfSenha.setBounds(12, 327, 241, 26);
		frame.getContentPane().add(tfSenha);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setBackground(new Color(76, 76, 76));
		tfSobrenome.setForeground(new Color(255, 255, 255));
		tfSobrenome.setColumns(10);
		tfSobrenome.setBounds(448, 141, 241, 26);
		frame.getContentPane().add(tfSobrenome);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBackground(new Color(76, 76, 76));
		tfDataNascimento.setForeground(new Color(255, 255, 255));
		tfDataNascimento.setColumns(10);
		tfDataNascimento.setBounds(448, 201, 241, 26);
		frame.getContentPane().add(tfDataNascimento);
		
		tfConfEmail = new JTextField();
		tfConfEmail.setBackground(new Color(76, 76, 76));
		tfConfEmail.setForeground(new Color(255, 255, 255));
		tfConfEmail.setColumns(10);
		tfConfEmail.setBounds(448, 264, 241, 26);
		frame.getContentPane().add(tfConfEmail);
		
		tfConfSenha = new JPasswordField();
		tfConfSenha.setBackground(new Color(76, 76, 76));
		tfConfSenha.setForeground(new Color(255, 255, 255));
		tfConfSenha.setColumns(10);
		tfConfSenha.setBounds(448, 328, 241, 26);
		frame.getContentPane().add(tfConfSenha);
	
	}
}
