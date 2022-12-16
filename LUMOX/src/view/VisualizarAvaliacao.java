package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import controller.AvaliacaoCRUD;
import model.Atleta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class VisualizarAvaliacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescricao;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private Atleta atleta;
	
	
	public VisualizarAvaliacao(Atleta a) {
		atleta = a;
		setTitle("Visualizar Avaliação");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AvaliacaoCRUD crudAv = new AvaliacaoCRUD();
		crudAv.updateAvaliacaoAtleta(atleta);
		
		textFieldDescricao = new JTextField(atleta.getAvaliacao().getAvaliacao());
		textFieldDescricao.setEditable(false);
		textFieldDescricao.setForeground(new Color(255, 255, 255));
		textFieldDescricao.setBackground(new Color(76, 76, 76));
		textFieldDescricao.setBounds(30, 71, 434, 111);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblCalorias = new JLabel("Descrição:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(30, 57, 161, 14);
		contentPane.add(lblCalorias);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(20, 167, 245));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(154, 209, 169, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("Visualizar Avaliação");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(169, 10, 149, 36);
		contentPane.add(lblNewLabel);
	}
}
