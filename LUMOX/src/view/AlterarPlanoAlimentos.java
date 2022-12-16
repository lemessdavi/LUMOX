package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.PlanoAlimentarCRUD;
import controller.PlanoTreinoCRUD;
import model.Alimento;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoTreino;

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

public class AlterarPlanoAlimentos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private PlanoAlimentarCRUD crud= new PlanoAlimentarCRUD();
	private PlanoAlimentar plano;
	private Personal personal;
	
	
	public AlterarPlanoAlimentos(Personal p) {
		personal = p;
		setTitle("Alterar Plano de Alimentos\r\n");
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
		
		JLabel lblCalorias = new JLabel("Alimentos:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
		contentPane.add(lblCalorias);
		

		JLabel lblNewLabel = new JLabel("Alterar Plano de Alimentos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(115, 10, 210, 36);
		contentPane.add(lblNewLabel);
		
		ArrayList<Alimento> alimentos = alimentoController.selectAllAlimentosToArray();
		
		final JComboBox cbAlimentoManha = new JComboBox(alimentos.toArray());
		cbAlimentoManha.setBackground(new Color(76, 76, 76));
		cbAlimentoManha.setForeground(new Color(255, 255, 255));
		cbAlimentoManha.setBounds(28, 122, 180, 20);
		contentPane.add(cbAlimentoManha);
		
		
		ArrayList<PlanoAlimentar> planos = crud.selectPlanosAlimentaresToArray();
		
		final JComboBox cbPlanos = new JComboBox(planos.toArray());
		cbPlanos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plano = (PlanoAlimentar) cbPlanos.getSelectedItem();
				textFieldNome.setText(plano.getNome());
				
			}
		});
		cbPlanos.setForeground(Color.WHITE);
		cbPlanos.setBackground(new Color(76, 76, 76));
		cbPlanos.setBounds(253, 76, 161, 20);
		contentPane.add(cbPlanos);
		
		JLabel lblPlano = new JLabel("Plano:");
		lblPlano.setForeground(Color.WHITE);
		lblPlano.setBounds(253, 59, 161, 14);
		contentPane.add(lblPlano);
		
		
		final ArrayList<Alimento> alimentosAdicionados = new ArrayList<>();
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(20, 167, 245));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(crud.updatePlanoAlimentar(plano.getId(),textFieldNome.getText(),alimentosAdicionados, personal)) {
						PopUp telaOk = new PopUp("Cadastro Realizado");
						telaOk.show(true);
					}else {
						PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
					}
				} catch (NumberFormatException e1) {
					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
				}
			}
		});
		btnConfirmar.setBounds(135, 267, 169, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnConfirmar_1 = new JButton("+");
		btnConfirmar_1.setToolTipText("");
		btnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alimentosAdicionados.add((Alimento) cbAlimentoManha.getSelectedItem());
			}
		});
		btnConfirmar_1.setForeground(Color.WHITE);
		btnConfirmar_1.setBackground(new Color(20, 167, 245));
		btnConfirmar_1.setBounds(218, 121, 41, 23);
		contentPane.add(btnConfirmar_1);
		
	}
}
