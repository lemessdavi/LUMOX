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
		setBounds(100, 100, 505, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExercicios = new JButton("Exercicios");
		btnExercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalExercicios tela = new PersonalExercicios(personal);
				tela.show();
			}
		});
		btnExercicios.setBounds(76, 135, 89, 23);
		contentPane.add(btnExercicios);
	}

}
