package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.AtletaCRUD;
import controller.PersonalCRUD;
import controller.PlanoSemanalCRUD;
import model.PlanoSemanal;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class CadastrarAtletaCerto extends JFrame {

	private JPanel contentPane;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfCpf;
	private JTextField tfSenha;


	public CadastrarAtletaCerto() {
		setTitle("Cadastro de Atleta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 425);
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
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Atleta");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(285, 68, 130, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Plano Semanal:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(298, 111, 105, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(29, 166, 105, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(29, 241, 105, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(419, 166, 105, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(419, 241, 105, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(298, 345, 105, 21);
		btnVoltar.setBackground(new Color(76, 76, 76));
		btnVoltar.setForeground(new Color(255, 255, 255));
		contentPane.add(btnVoltar);
		tfNome = new JTextField();
		tfNome.setBounds(29, 191, 241, 26);
		tfNome.setBackground(new Color(76, 76, 76));
		tfNome.setForeground(new Color(255, 255, 255));
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(Color.WHITE);
		tfEmail.setColumns(10);
		tfEmail.setBackground(new Color(76, 76, 76));
		tfEmail.setBounds(419, 191, 241, 26);
		contentPane.add(tfEmail);
		
		tfCpf = new JTextField();
		tfCpf.setForeground(Color.WHITE);
		tfCpf.setColumns(10);
		tfCpf.setBackground(new Color(76, 76, 76));
		tfCpf.setBounds(29, 258, 241, 26);
		contentPane.add(tfCpf);
		
		tfSenha = new JTextField();
		tfSenha.setForeground(Color.WHITE);
		tfSenha.setColumns(10);
		tfSenha.setBackground(new Color(76, 76, 76));
		tfSenha.setBounds(419, 258, 241, 26);
		contentPane.add(tfSenha);
		
		PlanoSemanalCRUD crudSemanal = new PlanoSemanalCRUD();
        ArrayList<PlanoSemanal> planos = crudSemanal.selectAllPlanosToArray();
		final JComboBox comboBox = new JComboBox(planos.toArray());
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(76, 76, 76));
		comboBox.setBounds(278, 136, 145, 22);
		contentPane.add(comboBox);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaCRUD crudAtelta = new AtletaCRUD();
                try {
                    if(crudAtelta.cadastrarAtleta(tfNome.getText(), tfCpf.getText(), tfEmail.getText(), tfSenha.getText(), (PlanoSemanal) comboBox.getSelectedItem())) {
                        PopUp telaOk = new PopUp("Cadastro Realizado");
                        telaOk.show(true);
                    }else {
                        PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
                        telaErro.show(true);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
            
        });
		btnCriarConta.setBounds(298, 307, 105, 21);
		btnCriarConta.setBackground(new Color(20, 167, 245));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		contentPane.add(btnCriarConta);
		
		
		
		
		
		
	}
}
