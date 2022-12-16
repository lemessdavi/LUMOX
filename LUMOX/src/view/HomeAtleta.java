package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Atleta;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HomeAtleta extends JFrame {

	private JPanel contentPane;
	Atleta atleta;

	/**
	 * Create the frame.
	 */
	public HomeAtleta(Atleta atleta1) {
		 atleta =  atleta1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 203, 433);
		panel.setBackground(new Color(76, 76, 76));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeAtleta = new JLabel("NomeAtleta");
		lblNomeAtleta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeAtleta.setForeground(new Color(255, 255, 255));
		lblNomeAtleta.setBounds(20, 72, 108, 18);
		panel.add(lblNomeAtleta);
		
		JLabel lblAtleta = new JLabel("Atleta");
		lblAtleta.setForeground(new Color(126, 126, 126));
		lblAtleta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtleta.setBounds(20, 89, 84, 18);
		panel.add(lblAtleta);
		
		JButton btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(76, 76, 76));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setBounds(20, 138, 183, 21);
		panel.add(btnHome);
		
		JButton btnAvalicoes = new JButton("Avaliação");
		btnAvalicoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(atleta);
				System.out.println(atleta.getAvaliacao());
				VisualizarAvaliacao tela = new VisualizarAvaliacao(atleta);
				tela.show();
			}
		});
		btnAvalicoes.setHorizontalAlignment(SwingConstants.LEFT);
		btnAvalicoes.setForeground(Color.WHITE);
		btnAvalicoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAvalicoes.setBackground(new Color(76, 76, 76));
		btnAvalicoes.setBounds(19, 241, 184, 21);
		panel.add(btnAvalicoes);
		
		JButton btnPlanoTreinos = new JButton("Ver Plano de Treinos");
		btnPlanoTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaPlanoTreino tela = new AtletaPlanoTreino(atleta);
				tela.show();
			}
		});
		btnPlanoTreinos.setBounds(68, 164, 187, 23);

		btnPlanoTreinos.setBackground(new Color(76, 76, 76));
		btnPlanoTreinos.setForeground(new Color(255, 255, 255));
		btnPlanoTreinos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlanoTreinos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlanoTreinos.setBounds(20, 171, 183, 23);
		panel.add(btnPlanoTreinos);

		
		JButton btnPlanoAlimentos = new JButton("Ver Plano de Alimentos");
		btnPlanoAlimentos.setBackground(new Color(76, 76, 76));
		btnPlanoAlimentos.setForeground(new Color(255, 255, 255));
		btnPlanoAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlanoAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlanoAlimentos.setBounds(20, 206, 183, 23);
		panel.add(btnPlanoAlimentos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.setBackground(new Color(76, 76, 76));
		btnSair.setBounds(12, 400, 60, 21);
		panel.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo de volta!");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(126, 126, 126));
		lblNewLabel.setBounds(234, 173, 242, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeAtleta2 = new JLabel("NomeAtleta");
		lblNomeAtleta2.setForeground(new Color(20, 167, 245));
		lblNomeAtleta2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeAtleta2.setBounds(234, 206, 155, 25);
		contentPane.add(lblNomeAtleta2);
		btnPlanoAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaPlanoAlimentar tela = new AtletaPlanoAlimentar(atleta);
				tela.show();
			}
		});
	}
}
