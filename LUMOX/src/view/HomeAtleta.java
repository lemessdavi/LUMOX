package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Atleta;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAtleta extends JFrame {

	private JPanel contentPane;
	Atleta atleta;

	/**
	 * Create the frame.
	 */
	public HomeAtleta(Atleta atleta1) {
		 atleta =  atleta1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlanoTreinos = new JButton("Ver Plano de Treinos");
		btnPlanoTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaPlanoTreino tela = new AtletaPlanoTreino(atleta);
				tela.show();
			}
		});
		btnPlanoTreinos.setBounds(68, 164, 187, 23);
		contentPane.add(btnPlanoTreinos);
		
		JButton btnPlanoAlimentos = new JButton("Ver Plano de Alimentos");
		btnPlanoAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletaPlanoAlimentar tela = new AtletaPlanoAlimentar(atleta);
				tela.show();
			}
		});
		btnPlanoAlimentos.setBounds(364, 164, 187, 23);
		contentPane.add(btnPlanoAlimentos);
	}

}
