package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.PersonalCRUD;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CriarConta extends JFrame {

	

	
	public CriarConta() {
		
		JFrame frame;
		final JTextField tfNome;
		final JTextField tfCpf;
		final JTextField tfEmail;
		final JTextField tfSenha;
		JPasswordField passwordField;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(44, 44, 44));
		frame.setBounds(100, 100, 715, 372);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crie uma conta de Personal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(236, 90, 229, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		tfNome.setBounds(22, 160, 241, 26);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(22, 139, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(22, 198, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBounds(417, 132, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBounds(417, 195, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(298, 300, 105, 21);
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
		tfCpf.setBounds(22, 220, 241, 26);
		frame.getContentPane().add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setForeground(new Color(255, 255, 255));
		tfEmail.setColumns(10);
		tfEmail.setBounds(417, 157, 241, 26);
		frame.getContentPane().add(tfEmail);
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setForeground(new Color(255, 255, 255));
		tfSenha.setColumns(10);
		tfSenha.setBounds(417, 220, 241, 26);
		frame.getContentPane().add(tfSenha);
		
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
		btnCriarConta.setBounds(298, 267, 105, 21);
		frame.getContentPane().add(btnCriarConta);
	
	}

}
