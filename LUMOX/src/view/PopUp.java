package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class PopUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PopUp(String text) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtA = new JTextField();
		txtA.setText(text);
		txtA.setEditable(false);
		txtA.setBounds(136, 103, 154, 46);
		contentPane.add(txtA);
		txtA.setColumns(10);
	}

}
