package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CriarConta {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		frame.setBounds(100, 100, 715, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LUMOX");
		lblNewLabel.setBounds(191, 17, 46, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox cbEscolheFuncao = new JComboBox();
		cbEscolheFuncao.setBounds(200, 63, 29, 21);
		frame.getContentPane().add(cbEscolheFuncao);
		
		JLabel lblNewLabel_1 = new JLabel("Crie uma nova conta");
		lblNewLabel_1.setBounds(146, 40, 105, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(25, 92, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(25, 121, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(25, 153, 96, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(25, 182, 96, 19);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(298, 92, 96, 19);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(298, 121, 96, 19);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(298, 153, 96, 19);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(298, 182, 96, 19);
		frame.getContentPane().add(textField_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setBounds(25, 67, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setBounds(25, 110, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setBounds(25, 144, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setBounds(25, 167, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Sobrenome");
		lblNewLabel_1_5.setBounds(289, 67, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Data de Nascimento");
		lblNewLabel_1_6.setBounds(289, 110, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Confirmar e-mail");
		lblNewLabel_1_7.setBounds(289, 144, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Confirmar senha");
		lblNewLabel_1_8.setBounds(289, 167, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_8);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBounds(166, 202, 85, 21);
		frame.getContentPane().add(btnCriarConta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(166, 232, 85, 21);
		frame.getContentPane().add(btnVoltar);
	}
}
