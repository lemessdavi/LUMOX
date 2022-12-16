package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Personal;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PersonalAlimentos extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	
	public PersonalAlimentos(Personal p) {
		personal = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 437, 358);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(496, 339, 89, 23);
		contentPane.add(btnNewButton);
	}

}
