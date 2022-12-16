package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class CadastrarPersonalCerto extends JFrame {

	private JPanel contentPane;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfCpf;
	private JTextField tfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPersonalCerto frame = new CadastrarPersonalCerto();
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
	public CadastrarPersonalCerto() {
		setTitle("Cadastro de Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_9 = new JLabel("LUMOX");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_9.setBounds(315, 24, 70, 38);
		contentPane.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Personal");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(275, 68, 151, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(30, 101, 105, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(30, 176, 105, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(420, 101, 105, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(420, 176, 105, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(299, 280, 105, 21);
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		contentPane.add(btnVoltar);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarConta.setBounds(299, 242, 105, 21);
		btnCriarConta.setBackground(new Color(20, 167, 245));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		contentPane.add(btnCriarConta);
		
		tfNome = new JTextField();
		tfNome.setBounds(30, 126, 241, 26);
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(Color.WHITE);
		tfEmail.setColumns(10);
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setBounds(420, 126, 241, 26);
		contentPane.add(tfEmail);
		
		tfCpf = new JTextField();
		tfCpf.setForeground(Color.WHITE);
		tfCpf.setColumns(10);
		tfCpf.setBackground(new Color(76, 76, 76));
		tfCpf.setBounds(30, 193, 241, 26);
		contentPane.add(tfCpf);
		
		tfSenha = new JTextField();
		tfSenha.setForeground(Color.WHITE);
		tfSenha.setColumns(10);
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setBounds(420, 193, 241, 26);
		contentPane.add(tfSenha);
		
		
		
		
	}
}
