package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.AtletaCRUD;
import controller.DiaDaSemanaCRUD;
import controller.ExercicioCRUD;
import controller.PlanoAlimentarCRUD;
import controller.PlanoSemanalCRUD;
import controller.PlanoTreinoCRUD;
import model.Atleta;
import model.DiaDaSemana;
import model.Exercicio;
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

public class CadastroPlanoSemanal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private PlanoTreinoCRUD crudPlanoTreino = new PlanoTreinoCRUD();
	private PlanoAlimentarCRUD crudPlanoAlimentar = new PlanoAlimentarCRUD();
	private PlanoSemanalCRUD crudPlanoSemanal = new PlanoSemanalCRUD();
	private DiaDaSemanaCRUD diaCRUD = new DiaDaSemanaCRUD();
	private AtletaCRUD atletaCrud = new AtletaCRUD();
	
	private Personal personal;



	/**
	 * Create the frame.
	 */
	public CadastroPlanoSemanal(Personal p) {
		personal = p;
		setTitle("Cadastro de Plano Semanal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(255, 255, 255));
		textFieldNome.setBackground(new Color(76, 76, 76));
		textFieldNome.setBounds(28, 76, 279, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Atleta:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
		contentPane.add(lblCalorias);
		
		
		JLabel lblNewLabel = new JLabel("Cadastrar Plano Semanal");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(309, 10, 220, 36);
		contentPane.add(lblNewLabel);
		
		
		ArrayList<Atleta> atletas = atletaCrud.selectAllAtletasToArray();
		
		JComboBox cbAtleta = new JComboBox(atletas.toArray());
		cbAtleta.setBackground(new Color(76, 76, 76));
		cbAtleta.setForeground(new Color(255, 255, 255));
		cbAtleta.setBounds(28, 122, 279, 20);
		contentPane.add(cbAtleta);
		
		JLabel lblSegundafeira = new JLabel("Segunda-feira");
		lblSegundafeira.setForeground(Color.WHITE);
		lblSegundafeira.setBounds(28, 233, 100, 14);
		contentPane.add(lblSegundafeira);
		
		JLabel lblCalorias_1_1 = new JLabel("Terça-feira");
		lblCalorias_1_1.setForeground(Color.WHITE);
		lblCalorias_1_1.setBounds(158, 233, 68, 14);
		contentPane.add(lblCalorias_1_1);
		
		JLabel lblCalorias_1_2 = new JLabel("Quarta-feira");
		lblCalorias_1_2.setForeground(Color.WHITE);
		lblCalorias_1_2.setBounds(270, 233, 70, 14);
		contentPane.add(lblCalorias_1_2);
		
		JLabel lblCalorias_1_3 = new JLabel("Quinta-feira");
		lblCalorias_1_3.setForeground(Color.WHITE);
		lblCalorias_1_3.setBounds(393, 233, 83, 14);
		contentPane.add(lblCalorias_1_3);
		
		JLabel lblCalorias_1_4 = new JLabel("Sexta-feira");
		lblCalorias_1_4.setForeground(Color.WHITE);
		lblCalorias_1_4.setBounds(511, 233, 83, 14);
		contentPane.add(lblCalorias_1_4);
		
		JLabel lblCalorias_1_5 = new JLabel("Sábado");
		lblCalorias_1_5.setForeground(Color.WHITE);
		lblCalorias_1_5.setBounds(637, 233, 68, 14);
		contentPane.add(lblCalorias_1_5);
		
		JLabel lblCalorias_1_6 = new JLabel("Domingo");
		lblCalorias_1_6.setForeground(Color.WHITE);
		lblCalorias_1_6.setBounds(744, 233, 70, 14);
		contentPane.add(lblCalorias_1_6);
		
		final ArrayList<PlanoAlimentar> planosAlimentares = crudPlanoAlimentar.selectPlanosAlimentaresToArray();
		final ArrayList<PlanoTreino> planosTreino = crudPlanoTreino.selectPlanosTreinosToArray();
		
		final JComboBox cbPlanAliSegunda = new JComboBox(planosAlimentares.toArray());
		cbPlanAliSegunda.setForeground(Color.WHITE);
		cbPlanAliSegunda.setBackground(new Color(76, 76, 76));
		cbPlanAliSegunda.setBounds(28, 259, 89, 20);
		contentPane.add(cbPlanAliSegunda);
		
		
		final JComboBox cbPlanTreiSegunda = new JComboBox(planosTreino.toArray());
		cbPlanTreiSegunda.setForeground(Color.WHITE);
		cbPlanTreiSegunda.setBackground(new Color(76, 76, 76));
		cbPlanTreiSegunda.setBounds(28, 291, 89, 20);
		contentPane.add(cbPlanTreiSegunda);
		
		final JComboBox cbPlanAliTerca = new JComboBox(planosAlimentares.toArray());
		cbPlanAliTerca.setForeground(Color.WHITE);
		cbPlanAliTerca.setBackground(new Color(76, 76, 76));
		cbPlanAliTerca.setBounds(150, 259, 89, 20);
		contentPane.add(cbPlanAliTerca);
		
		final JComboBox cbPlanTreiTerca = new JComboBox(planosTreino.toArray());
		cbPlanTreiTerca.setForeground(Color.WHITE);
		cbPlanTreiTerca.setBackground(new Color(76, 76, 76));
		cbPlanTreiTerca.setBounds(150, 291, 89, 20);
		contentPane.add(cbPlanTreiTerca);
		
		final JComboBox cbPlanAliQuarta = new JComboBox(planosAlimentares.toArray());
		cbPlanAliQuarta.setForeground(Color.WHITE);
		cbPlanAliQuarta.setBackground(new Color(76, 76, 76));
		cbPlanAliQuarta.setBounds(261, 259, 89, 20);
		contentPane.add(cbPlanAliQuarta);
		
		final JComboBox cbPlanTreiQuarta = new JComboBox(planosTreino.toArray());
		cbPlanTreiQuarta.setForeground(Color.WHITE);
		cbPlanTreiQuarta.setBackground(new Color(76, 76, 76));
		cbPlanTreiQuarta.setBounds(261, 291, 89, 20);
		contentPane.add(cbPlanTreiQuarta);
		
		final JComboBox cbPlanAliQuinta = new JComboBox(planosAlimentares.toArray());
		cbPlanAliQuinta.setForeground(Color.WHITE);
		cbPlanAliQuinta.setBackground(new Color(76, 76, 76));
		cbPlanAliQuinta.setBounds(387, 259, 89, 20);
		contentPane.add(cbPlanAliQuinta);
		
		final JComboBox cbPlanTreiQuinta = new JComboBox(planosTreino.toArray());
		cbPlanTreiQuinta.setForeground(Color.WHITE);
		cbPlanTreiQuinta.setBackground(new Color(76, 76, 76));
		cbPlanTreiQuinta.setBounds(387, 291, 89, 20);
		contentPane.add(cbPlanTreiQuinta);
		
		final JComboBox cbPlanAliSexta = new JComboBox(planosAlimentares.toArray());
		cbPlanAliSexta.setForeground(Color.WHITE);
		cbPlanAliSexta.setBackground(new Color(76, 76, 76));
		cbPlanAliSexta.setBounds(505, 259, 89, 20);
		contentPane.add(cbPlanAliSexta);
		
		final JComboBox cbPlanTreiSexta = new JComboBox(planosTreino.toArray());
		cbPlanTreiSexta.setForeground(Color.WHITE);
		cbPlanTreiSexta.setBackground(new Color(76, 76, 76));
		cbPlanTreiSexta.setBounds(505, 291, 89, 20);
		contentPane.add(cbPlanTreiSexta);
		
		final JComboBox cbPlanAliSabado = new JComboBox(planosAlimentares.toArray());
		cbPlanAliSabado.setForeground(Color.WHITE);
		cbPlanAliSabado.setBackground(new Color(76, 76, 76));
		cbPlanAliSabado.setBounds(616, 259, 89, 20);
		contentPane.add(cbPlanAliSabado);
		
		final JComboBox cbPlanTreiSabado = new JComboBox(planosTreino.toArray());
		cbPlanTreiSabado.setForeground(Color.WHITE);
		cbPlanTreiSabado.setBackground(new Color(76, 76, 76));
		cbPlanTreiSabado.setBounds(616, 291, 89, 20);
		contentPane.add(cbPlanTreiSabado);
		
		final JComboBox cbPlanAliDomingo = new JComboBox(planosAlimentares.toArray());
		cbPlanAliDomingo.setForeground(Color.WHITE);
		cbPlanAliDomingo.setBackground(new Color(76, 76, 76));
		cbPlanAliDomingo.setBounds(725, 259, 89, 20);
		contentPane.add(cbPlanAliDomingo);
		
		final JComboBox cbPlanTreiDomingo = new JComboBox(planosTreino.toArray());
		cbPlanTreiDomingo.setForeground(Color.WHITE);
		cbPlanTreiDomingo.setBackground(new Color(76, 76, 76));
		cbPlanTreiDomingo.setBounds(725, 291, 89, 20);
		contentPane.add(cbPlanTreiDomingo);
		
		JLabel lblSemanaPlano = new JLabel("Dia / Planos");
		lblSemanaPlano.setForeground(Color.WHITE);
		lblSemanaPlano.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSemanaPlano.setBounds(369, 165, 100, 36);
		contentPane.add(lblSemanaPlano);
		
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(20, 167, 245));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PlanoAlimentar segundaAlimentar = (PlanoAlimentar) cbPlanAliSegunda.getSelectedItem();
					PlanoAlimentar tercaAlimentar = (PlanoAlimentar) cbPlanAliTerca.getSelectedItem();
					PlanoAlimentar quartaAlimentar = (PlanoAlimentar) cbPlanAliQuarta.getSelectedItem();
					PlanoAlimentar quintaAlimentar = (PlanoAlimentar) cbPlanAliQuinta.getSelectedItem();
					PlanoAlimentar sextaAlimentar = (PlanoAlimentar) cbPlanAliSexta.getSelectedItem();
					PlanoAlimentar sabadoAlimentar = (PlanoAlimentar) cbPlanAliSabado.getSelectedItem();
					PlanoAlimentar domingoAlimentar = (PlanoAlimentar) cbPlanAliDomingo.getSelectedItem();
					
					PlanoTreino segundaTreino = (PlanoTreino) cbPlanTreiSegunda.getSelectedItem();
					PlanoTreino tercaTreino = (PlanoTreino) cbPlanTreiTerca.getSelectedItem();
					PlanoTreino quartaTreino = (PlanoTreino) cbPlanTreiQuarta.getSelectedItem();
					PlanoTreino quintaTreino = (PlanoTreino) cbPlanTreiQuinta.getSelectedItem();
					PlanoTreino sextaTreino = (PlanoTreino) cbPlanTreiSexta.getSelectedItem();
					PlanoTreino sabadoTreino = (PlanoTreino) cbPlanTreiSabado.getSelectedItem();
					PlanoTreino domingoTreino = (PlanoTreino) cbPlanTreiDomingo.getSelectedItem();
					
					DiaDaSemana segunda = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),segundaAlimentar,segundaTreino);
					DiaDaSemana terca = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),tercaAlimentar,tercaTreino);
					DiaDaSemana quarta = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),quartaAlimentar,quartaTreino);
					DiaDaSemana quinta = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),quintaAlimentar,quintaTreino);
					DiaDaSemana sexta = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),sextaAlimentar,sextaTreino);
					DiaDaSemana sabado = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),sabadoAlimentar,sabadoTreino);
					DiaDaSemana domingo = diaCRUD.cadastrarDiaDaSemanaAndReturn("segunda " + textFieldNome.getText(),domingoAlimentar,domingoTreino);
					
					
					if(crudPlanoSemanal.cadastrarPlanoSemanal(textFieldNome.getText(), segunda, terca, quarta, quinta, sexta, sabado, domingo)) {
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
		btnCadastrar.setBounds(334, 334, 169, 23);
		contentPane.add(btnCadastrar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(51, 213, 736, 5);
		contentPane.add(panel);
	}
}
