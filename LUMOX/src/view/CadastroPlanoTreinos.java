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

public class CadastroPlanoTreinos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private ExercicioCRUD crudExercico = new ExercicioCRUD();
	private PlanoTreinoCRUD crudPlano = new PlanoTreinoCRUD();
	private Personal personal;

	
	public CadastroPlanoTreinos(Personal p) {
		personal = p;
		setTitle("Cadastro de Plano de Treino");
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
		
		final ArrayList<Exercicio> exerciciosAdicionados = new ArrayList<>();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(20, 167, 245));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(crudPlano.cadastrarPlanoTreino(textFieldNome.getText(), exerciciosAdicionados, personal)) {
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
		btnCadastrar.setBounds(137, 169, 169, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Plano de Treinos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(118, 10, 204, 36);
		contentPane.add(lblNewLabel);
		
		ArrayList<Exercicio> exercicios = crudExercico.selectAllExerciciosToArray();
		
		final JComboBox cbExercicios = new JComboBox(exercicios.toArray());
		cbExercicios.setBackground(new Color(76, 76, 76));
		cbExercicios.setForeground(new Color(255, 255, 255));
		cbExercicios.setBounds(28, 122, 180, 20);
		contentPane.add(cbExercicios);
		
		JButton btnCadastrar_1 = new JButton("+");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciciosAdicionados.add((Exercicio) cbExercicios.getSelectedItem());
			}
		});
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setBackground(new Color(20, 167, 245));
		btnCadastrar_1.setBounds(218, 121, 46, 23);
		contentPane.add(btnCadastrar_1);
	}
}
