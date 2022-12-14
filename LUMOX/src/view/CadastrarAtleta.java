package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AtletaCRUD;
import controller.PersonalCRUD;
import controller.PlanoSemanalCRUD;
import model.PlanoSemanal;

import javax.swing.JComboBox;

public class CadastrarAtleta extends JFrame {
	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfSenha;
	private JPasswordField passwordField;

	
	public CadastrarAtleta() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(44, 44, 44));
		frame.setBounds(100, 100, 715, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Atleta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(281, 66, 130, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		tfNome.setBounds(29, 198, 241, 26);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(29, 177, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(29, 236, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBounds(424, 170, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBounds(424, 233, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(298, 345, 105, 21);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_1_9 = new JLabel("LUMOX");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_9.setBounds(311, 22, 70, 38);
		frame.getContentPane().add(lblNewLabel_1_9);
		
		tfCpf = new JTextField();
		tfCpf.setBackground(new Color(76, 76, 76));
		tfCpf.setForeground(new Color(255, 255, 255));
		tfCpf.setColumns(10);
		tfCpf.setBounds(29, 258, 241, 26);
		frame.getContentPane().add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setForeground(new Color(255, 255, 255));
		tfEmail.setColumns(10);
		tfEmail.setBounds(424, 195, 241, 26);
		frame.getContentPane().add(tfEmail);
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setForeground(new Color(255, 255, 255));
		tfSenha.setColumns(10);
		tfSenha.setBounds(424, 258, 241, 26);
		frame.getContentPane().add(tfSenha);
		
		PlanoSemanalCRUD crudSemanal = new PlanoSemanalCRUD();
		ArrayList<PlanoSemanal> planos = crudSemanal.selectAllPlanosToArray();
		final JComboBox comboBox = new JComboBox(planos.toArray());
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(76, 76, 76));
		comboBox.setBounds(278, 136, 145, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Plano Semanal:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(298, 112, 105, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBackground(new Color(20, 167, 245));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaCRUD crudAtelta = new AtletaCRUD();
				try {
					if(crudAtelta.cadastrarAtleta(tfNome.getText(), tfCpf.getText(), tfEmail.getText(), tfSenha.getText(), (PlanoSemanal) comboBox.getSelectedItem())) {
						PopUp telaOk = new PopUp("Cadastro Realizado");
						telaOk.show(true);
					}else {
						PopUp telaErro = new PopUp("Erro, Cadastro N??o Realizado");
						telaErro.show(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCriarConta.setBounds(298, 312, 105, 21);
		frame.getContentPane().add(btnCriarConta);
		
		
	}


}
