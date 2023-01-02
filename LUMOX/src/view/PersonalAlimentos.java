package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Personal;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;

public class PersonalAlimentos extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	
	public PersonalAlimentos(Personal p) {
		personal = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 27, 609, 358);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBackground(new Color(20, 167, 245));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(267, 395, 107, 25);
		contentPane.add(btnNewButton);
	}

}
