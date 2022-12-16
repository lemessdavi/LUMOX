package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AtletaCRUD;
import controller.PersonalCRUD;
import controller.PlanoAlimentarCRUD;
import controller.PlanoTreinoCRUD;
import dao.PersonalDAO;
import model.Personal;
import model.PlanoAlimentar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PersonalPlanosTreino extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	/**
	 * Create the frame.
	 */
	public PersonalPlanosTreino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 11, 609, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBackground(new Color(20, 167, 245));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				PlanoTreinoCRUD crud = new PlanoTreinoCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModelTreino());
				String planoalimentarnome=null, alimentonome = null,alimentocalorias = null,alimentopropriedades = null;
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
				
				ResultSet rs = crud.selectPlanosTreinoToArrayPersonal();
				
				try {
					while(rs.next()) {
						String nome = rs.getString(1);
						String nomeE = rs.getString(2);
						String rep = String.valueOf(rs.getInt(3));
						String tempo = rs.getString(4);
						String instr = rs.getString(5);
						
						String[] row = {nome, nomeE,rep,tempo,instr};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(267, 382, 107, 25);
		contentPane.add(btnNewButton);
	}

}
