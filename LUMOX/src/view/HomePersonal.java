package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Personal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class HomePersonal extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	/**
	 * Create the frame.
	 */
	public HomePersonal(Personal personal1) {
		personal = personal1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSelectrExercicios = new JButton("Ver Exercícios");
		btnSelectrExercicios.setBackground(new Color(58, 58, 58));
		btnSelectrExercicios.setForeground(new Color(255, 255, 255));
		btnSelectrExercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalExercicios tela = new PersonalExercicios(personal);
				tela.show();
			}
		});
		btnSelectrExercicios.setBounds(12, 303, 143, 23);
		contentPane.add(btnSelectrExercicios);
		
		JButton btnSelectAlimentos = new JButton("Ver Alimentos");
		btnSelectAlimentos.setBackground(new Color(58, 58, 58));
		btnSelectAlimentos.setForeground(new Color(255, 255, 255));
		btnSelectAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalAlimentos tela = new PersonalAlimentos(personal);
				tela.show();
			}
		});
		btnSelectAlimentos.setBounds(178, 303, 143, 23);
		contentPane.add(btnSelectAlimentos);
		
		JButton btnCadastrarPlanoTreino = new JButton("Adicionar Plano de Treino");
		btnCadastrarPlanoTreino.setForeground(new Color(255, 255, 255));
		btnCadastrarPlanoTreino.setBackground(new Color(20, 167, 245));
		btnCadastrarPlanoTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoTreinos tela = new CadastroPlanoTreinos(personal);
				tela.show();
			}
		});
		btnCadastrarPlanoTreino.setBounds(12, 110, 191, 23);
		contentPane.add(btnCadastrarPlanoTreino);
		
		JButton btnCadastrarPlanoAlimentar = new JButton("Adicionar Plano de Dieta");
		btnCadastrarPlanoAlimentar.setForeground(new Color(255, 255, 255));
		btnCadastrarPlanoAlimentar.setBackground(new Color(20, 167, 245));
		btnCadastrarPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoAlimentos tela = new CadastroPlanoAlimentos(personal);
				tela.show();
			}
		});
		btnCadastrarPlanoAlimentar.setBounds(302, 110, 191, 23);
		contentPane.add(btnCadastrarPlanoAlimentar);
		
		JButton btnCadastrarAlimento = new JButton("Adicionar Alimento");
		btnCadastrarAlimento.setForeground(new Color(255, 255, 255));
		btnCadastrarAlimento.setBackground(new Color(20, 167, 245));
		btnCadastrarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlimento tela = new CadastroAlimento();
				tela.show();
			}
		});
		btnCadastrarAlimento.setBounds(178, 237, 143, 23);
		contentPane.add(btnCadastrarAlimento);
		
		JButton btnAlterarAlimento = new JButton("Alterar Alimento");
		btnAlterarAlimento.setBackground(new Color(76, 76, 76));
		btnAlterarAlimento.setForeground(new Color(255, 255, 255));
		btnAlterarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarAlimento tela = new AlterarAlimento();
				tela.show();
			}
		});
		btnAlterarAlimento.setBounds(178, 270, 143, 23);
		contentPane.add(btnAlterarAlimento);
		
		JButton btnCadastrarExercicio = new JButton("Adicionar Exercício");
		btnCadastrarExercicio.setForeground(new Color(255, 255, 255));
		btnCadastrarExercicio.setBackground(new Color(20, 167, 245));
		btnCadastrarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroExercicio tela = new CadastroExercicio();
				tela.show();
			}
		});
		btnCadastrarExercicio.setBounds(12, 237, 143, 23);
		contentPane.add(btnCadastrarExercicio);
		
		JButton btnAlterarExercicio = new JButton("Alterar Exercício");
		btnAlterarExercicio.setBackground(new Color(76, 76, 76));
		btnAlterarExercicio.setForeground(new Color(255, 255, 255));
		btnAlterarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarExercicio tela = new AlterarExercicio();
				tela.show();
			}
		});
		btnAlterarExercicio.setBounds(12, 270, 143, 23);
		contentPane.add(btnAlterarExercicio);
		
		JButton btnAlterarPlanoTreino = new JButton("Alterar Plano de Treino");
		btnAlterarPlanoTreino.setBackground(new Color(76, 76, 76));
		btnAlterarPlanoTreino.setForeground(new Color(255, 255, 255));
		btnAlterarPlanoTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoTreinos tela = new AlterarPlanoTreinos(personal);
				tela.show();
			}
		});
		btnAlterarPlanoTreino.setBounds(12, 143, 191, 23);
		contentPane.add(btnAlterarPlanoTreino);
		
		JButton btnAlterarPlanoAlimentar = new JButton("Alterar Plano de Dieta");
		btnAlterarPlanoAlimentar.setBackground(new Color(76, 76, 76));
		btnAlterarPlanoAlimentar.setForeground(new Color(255, 255, 255));
		btnAlterarPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoAlimentos tela = new AlterarPlanoAlimentos(personal);
				tela.show();
			}
		});
		btnAlterarPlanoAlimentar.setBounds(302, 143, 191, 23);
		contentPane.add(btnAlterarPlanoAlimentar);
		
		JButton btnSelectTreino = new JButton("Ver Planos de Treino");
		btnSelectTreino.setBackground(new Color(58, 58, 58));
		btnSelectTreino.setForeground(new Color(255, 255, 255));
		btnSelectTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalPlanosTreino tela = new PersonalPlanosTreino();
				tela.show();
			}
		});
		btnSelectTreino.setBounds(12, 176, 191, 23);
		contentPane.add(btnSelectTreino);
		
		JButton btnSelectPlanoAlimentar = new JButton("Ver Planos de Dieta");
		btnSelectPlanoAlimentar.setBackground(new Color(58, 58, 58));
		btnSelectPlanoAlimentar.setForeground(new Color(255, 255, 255));
		btnSelectPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalPlanosAlimento tela = new PersonalPlanosAlimento();
				tela.show();
			}
		});
		btnSelectPlanoAlimentar.setBounds(302, 176, 191, 23);
		contentPane.add(btnSelectPlanoAlimentar);
		
		JButton btnCadastroPlanoSemanal = new JButton("Adicionar Plano Semanal");
		btnCadastroPlanoSemanal.setForeground(new Color(255, 255, 255));
		btnCadastroPlanoSemanal.setBackground(new Color(20, 167, 245));
		btnCadastroPlanoSemanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoSemanal tela = new CadastroPlanoSemanal(personal);
				tela.show();
			}
		});
		btnCadastroPlanoSemanal.setBounds(37, 62, 200, 25);
		contentPane.add(btnCadastroPlanoSemanal);
		
		JButton btnAlterarPlanoSemanal = new JButton("Alterar Plano Semanal");
		btnAlterarPlanoSemanal.setBackground(new Color(76, 76, 76));
		btnAlterarPlanoSemanal.setForeground(new Color(255, 255, 255));
		btnAlterarPlanoSemanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoSemanal tela = new AlterarPlanoSemanal(personal);
				tela.show();
			}
		});
		btnAlterarPlanoSemanal.setBounds(274, 62, 200, 25);
		contentPane.add(btnAlterarPlanoSemanal);
		
		JButton btnCadastrarAtleta = new JButton("Adicionar Atleta");
		btnCadastrarAtleta.setForeground(new Color(255, 255, 255));
		btnCadastrarAtleta.setBackground(new Color(20, 167, 245));
		btnCadastrarAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAtletaCerto tela = new CadastrarAtletaCerto();
				tela.show();
			}
		});
		btnCadastrarAtleta.setBounds(349, 252, 144, 23);
		contentPane.add(btnCadastrarAtleta);
		
		JButton btnCadastrarAvaliacao = new JButton("Adicionar Avaliação");
		btnCadastrarAvaliacao.setForeground(new Color(255, 255, 255));
		btnCadastrarAvaliacao.setBackground(new Color(20, 167, 245));
		btnCadastrarAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAvaliacao tela = new CadastroAvaliacao();
				tela.show();
			}
		});
		btnCadastrarAvaliacao.setBounds(349, 287, 144, 23);
		contentPane.add(btnCadastrarAvaliacao);
		
		JLabel lblNewLabel_1_9 = new JLabel("LUMOX");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_9.setBounds(226, 12, 70, 38);
		contentPane.add(lblNewLabel_1_9);
	}
}
