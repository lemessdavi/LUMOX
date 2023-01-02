package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.PlanoAlimentarCRUD;
import model.Alimento;
import model.Personal;
import model.PlanoAlimentar;

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

public class CadastroPlanoAlimentos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private PlanoAlimentarCRUD crud = new PlanoAlimentarCRUD();
	private AlimentoCRUD crudAlimento = new AlimentoCRUD();
	private Personal personal;
	/**
	 * Create the frame.
	 */
	public CadastroPlanoAlimentos(Personal p) {
		personal = p;
		setTitle("Cadastro de Plano de Alimentos\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(255, 255, 255));
		textFieldNome.setBackground(new Color(76, 76, 76));
		textFieldNome.setBounds(28, 76, 180, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Alimentos");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
		contentPane.add(lblCalorias);
		
		final ArrayList<Alimento> alimentosAdicionados =  new ArrayList<>();
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(20, 167, 245));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(crud.cadastrarPlanoAlimentar(textFieldNome.getText(),alimentosAdicionados, personal)) {
						PopUp telaOk = new PopUp("Cadastro Realizado");
						telaOk.show(true);
					}else {
						PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
					}
				} catch (NumberFormatException ex) {
					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
				}
			}
		});
		btnCadastrar.setBounds(135, 267, 169, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Plano de Alimentos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(110, 10, 220, 36);
		contentPane.add(lblNewLabel);
		
		ArrayList<Alimento> alimentos = crudAlimento.selectAllAlimentosToArray();
		
		final JComboBox cbAlimentos = new JComboBox(alimentos.toArray());
		cbAlimentos.setBackground(new Color(76, 76, 76));
		cbAlimentos.setForeground(new Color(255, 255, 255));
		cbAlimentos.setBounds(28, 122, 180, 20);
		contentPane.add(cbAlimentos);
		
		JButton btnCadastrar_1 = new JButton("+");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alimentosAdicionados.add((Alimento) cbAlimentos.getSelectedItem());
			}
		});
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setBackground(new Color(20, 167, 245));
		btnCadastrar_1.setBounds(220, 122, 46, 20);
		contentPane.add(btnCadastrar_1);
	}
}
