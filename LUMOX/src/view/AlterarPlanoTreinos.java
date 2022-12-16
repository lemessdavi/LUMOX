package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.ExercicioCRUD;
import controller.PlanoTreinoCRUD;
import model.Exercicio;
import model.Personal;
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

public class AlterarPlanoTreinos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private PlanoTreinoCRUD planoCRUD = new PlanoTreinoCRUD();
	private PlanoTreino plano;
	private ExercicioCRUD exercicioCRUD= new ExercicioCRUD();
	private Personal personal;

	
	
	public AlterarPlanoTreinos(Personal p) {
		personal = p;
		setTitle("Alterar Plano de Treino");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 247);
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
		
		JLabel lblCalorias = new JLabel("Exercícios");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
		contentPane.add(lblCalorias);
		
		JLabel lblNewLabel = new JLabel("Alterar Plano de Treinos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(127, 10, 185, 36);
		contentPane.add(lblNewLabel);
		
		final ArrayList<Exercicio> exercicios = exercicioCRUD.selectAllExerciciosToArray();
		final JComboBox cbExercicios = new JComboBox(exercicios.toArray());
		cbExercicios.setBackground(new Color(76, 76, 76));
		cbExercicios.setForeground(new Color(255, 255, 255));
		cbExercicios.setBounds(28, 122, 180, 20);
		contentPane.add(cbExercicios);
		
		JLabel lblPlanos = new JLabel("Planos:");
		lblPlanos.setForeground(Color.WHITE);
		lblPlanos.setBounds(248, 59, 161, 14);
		contentPane.add(lblPlanos);
		
		ArrayList<PlanoTreino> planos = planoCRUD.selectPlanosTreinosToArray();
		final JComboBox cbExercicios_1 = new JComboBox(planos.toArray());
		cbExercicios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plano = (PlanoTreino) cbExercicios_1.getSelectedItem();
				textFieldNome.setText(plano.getNome());
			}
		});
		cbExercicios_1.setForeground(Color.WHITE);
		cbExercicios_1.setBackground(new Color(76, 76, 76));
		cbExercicios_1.setBounds(248, 75, 180, 20);
		contentPane.add(cbExercicios_1);
		
		final ArrayList<Exercicio> exerciciosNovos = new ArrayList<>();
		
		JButton btnConfirmar_1 = new JButton("+");
		btnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciciosNovos.add((Exercicio) cbExercicios.getSelectedItem());
			}
		});
		btnConfirmar_1.setForeground(Color.WHITE);
		btnConfirmar_1.setBackground(new Color(20, 167, 245));
		btnConfirmar_1.setBounds(217, 121, 41, 23);
		contentPane.add(btnConfirmar_1);
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(20, 167, 245));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(plano.getId());
					System.out.println(textFieldNome.getText());
					System.out.println(personal.getId());
					if(planoCRUD.updatePlanoTreino(plano.getId(), textFieldNome.getText(), exerciciosNovos, personal)) {
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
		btnConfirmar.setBounds(137, 169, 169, 23);
		contentPane.add(btnConfirmar);
		
		
		
		
		
	
	}
}
