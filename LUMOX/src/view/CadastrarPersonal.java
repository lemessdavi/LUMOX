package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PersonalCRUD;

public class CadastrarPersonal extends JFrame {

	private JPanel contentPane;

	public CadastrarPersonal() {
		
		JFrame frame;
		final JTextField tfNome;
		final JTextField tfCpf;
		final JTextField tfEmail;
		final JTextField tfSenha;
		JPasswordField passwordField;
		
		frame = new JFrame();
		contentPane.setBackground(new Color(44, 44, 44));
		frame.setBounds(100, 100, 715, 470);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crie uma de Personal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(268, 90, 184, 17);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		tfNome.setBounds(22, 179, 241, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(22, 158, 105, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(22, 217, 105, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBounds(417, 151, 105, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBounds(417, 214, 105, 13);
		contentPane.add(lblNewLabel_1_4);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(308, 400, 105, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1_9 = new JLabel("LUMOX");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_9.setBounds(318, 46, 70, 38);
		contentPane.add(lblNewLabel_1_9);
		
		tfCpf = new JTextField();
		tfCpf.setBackground(new Color(76, 76, 76));
		tfCpf.setForeground(new Color(255, 255, 255));
		tfCpf.setColumns(10);
		tfCpf.setBounds(22, 239, 241, 26);
		contentPane.add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setForeground(new Color(255, 255, 255));
		tfEmail.setColumns(10);
		tfEmail.setBounds(417, 176, 241, 26);
		contentPane.add(tfEmail);
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setForeground(new Color(255, 255, 255));
		tfSenha.setColumns(10);
		tfSenha.setBounds(417, 239, 241, 26);
		contentPane.add(tfSenha);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBackground(new Color(20, 167, 245));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalCRUD controllerPersonal = new PersonalCRUD();
				if(controllerPersonal.cadastrarPersonal(tfNome.getText(), tfCpf.getText(), tfEmail.getText(), tfSenha.getText())) {
					PopUp telaOk = new PopUp("Cadastro Realizado");
					telaOk.show(true);
				}else {
					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
				telaErro.show(true);
				}
			}
		});
		btnCriarConta.setBounds(308, 367, 105, 21);
		contentPane.add(btnCriarConta);
	
	}

}
