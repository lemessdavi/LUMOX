package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Personal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePersonal extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	/**
	 * Create the frame.
	 */
	public HomePersonal(Personal personal1) {
		personal = personal1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSelectrExercicios = new JButton("Ver Exercicios");
		btnSelectrExercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalExercicios tela = new PersonalExercicios(personal);
				tela.show();
			}
		});
		btnSelectrExercicios.setBounds(46, 54, 124, 23);
		contentPane.add(btnSelectrExercicios);
		
		JButton btnSelectAlimentos = new JButton("Ver Alimentos");
		btnSelectAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalAlimentos tela = new PersonalAlimentos(personal);
				tela.show();
			}
		});
		btnSelectAlimentos.setBounds(46, 100, 124, 23);
		contentPane.add(btnSelectAlimentos);
		
		JButton btnCadastrarPlanoTreino = new JButton("Cadastrar Plano de Treino");
		btnCadastrarPlanoTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoTreinos tela = new CadastroPlanoTreinos(personal);
				tela.show();
			}
		});
		btnCadastrarPlanoTreino.setBounds(46, 162, 191, 23);
		contentPane.add(btnCadastrarPlanoTreino);
		
		JButton btnCadastrarPlanoAlimentar = new JButton("Cadastrar Plano de Dieta");
		btnCadastrarPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoAlimentos tela = new CadastroPlanoAlimentos(personal);
				tela.show();
			}
		});
		btnCadastrarPlanoAlimentar.setBounds(272, 162, 191, 23);
		contentPane.add(btnCadastrarPlanoAlimentar);
		
		JButton btnCadastrarAlimento = new JButton("Adicionar Alimento");
		btnCadastrarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlimento tela = new CadastroAlimento();
				tela.show();
			}
		});
		btnCadastrarAlimento.setBounds(200, 100, 124, 23);
		contentPane.add(btnCadastrarAlimento);
		
		JButton btnAlterarAlimento = new JButton("Alterar Alimento");
		btnAlterarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarAlimento tela = new AlterarAlimento();
				tela.show();
			}
		});
		btnAlterarAlimento.setBounds(355, 100, 124, 23);
		contentPane.add(btnAlterarAlimento);
		
		JButton btnCadastrarExercicio = new JButton("Adicionar Exercicio");
		btnCadastrarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroExercicio tela = new CadastroExercicio();
				tela.show();
			}
		});
		btnCadastrarExercicio.setBounds(200, 54, 124, 23);
		contentPane.add(btnCadastrarExercicio);
		
		JButton btnAlterarExercicio = new JButton("Alterar Exercicio");
		btnAlterarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarExercicio tela = new AlterarExercicio();
				tela.show();
			}
		});
		btnAlterarExercicio.setBounds(355, 54, 124, 23);
		contentPane.add(btnAlterarExercicio);
		
		JButton btnAlterarPlanoTreino = new JButton("Alterar Plano de Treino");
		btnAlterarPlanoTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoTreinos tela = new AlterarPlanoTreinos(personal);
				tela.show();
			}
		});
		btnAlterarPlanoTreino.setBounds(46, 196, 191, 23);
		contentPane.add(btnAlterarPlanoTreino);
		
		JButton btnAlterarPlanoAlimentar = new JButton("Alterar Plano de Dieta");
		btnAlterarPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoAlimentos tela = new AlterarPlanoAlimentos(personal);
				tela.show();
			}
		});
		btnAlterarPlanoAlimentar.setBounds(272, 196, 191, 23);
		contentPane.add(btnAlterarPlanoAlimentar);
		
		JButton btnSelectTreino = new JButton("Ver Planos de Treino");
		btnSelectTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalPlanosTreino tela = new PersonalPlanosTreino();
				tela.show();
			}
		});
		btnSelectTreino.setBounds(46, 230, 191, 23);
		contentPane.add(btnSelectTreino);
		
		JButton btnSelectPlanoAlimentar = new JButton("Ver Planos de Dieta");
		btnSelectPlanoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalPlanosAlimento tela = new PersonalPlanosAlimento();
				tela.show();
			}
		});
		btnSelectPlanoAlimentar.setBounds(272, 230, 191, 23);
		contentPane.add(btnSelectPlanoAlimentar);
		
		JButton btnCadastroPlanoSemanal = new JButton("Adicionar Plano Semanal");
		btnCadastroPlanoSemanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPlanoSemanal tela = new CadastroPlanoSemanal(personal);
				tela.show();
			}
		});
		btnCadastroPlanoSemanal.setBounds(46, 277, 191, 23);
		contentPane.add(btnCadastroPlanoSemanal);
		
		JButton btnAlterarPlanoSemanal = new JButton("Alterar Plano Semanal");
		btnAlterarPlanoSemanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPlanoSemanal tela = new AlterarPlanoSemanal(personal);
				tela.show();
			}
		});
		btnAlterarPlanoSemanal.setBounds(272, 277, 191, 23);
		contentPane.add(btnAlterarPlanoSemanal);
		
		JButton btnCadastrarAtleta = new JButton("Cadastrar Atleta");
		btnCadastrarAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAtleta tela = new CadastrarAtleta();
				tela.show();
			}
		});
		btnCadastrarAtleta.setBounds(46, 324, 191, 23);
		contentPane.add(btnCadastrarAtleta);
		
		JButton btnCadastrarAvaliacao = new JButton("Cadastrar Avaliacao");
		btnCadastrarAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAvaliacao tela = new CadastroAvaliacao();
				tela.show();
			}
		});
		btnCadastrarAvaliacao.setBounds(272, 324, 191, 23);
		contentPane.add(btnCadastrarAvaliacao);
	}

}
