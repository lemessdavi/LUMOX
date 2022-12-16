package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AtletaCRUD;
import controller.ExercicioCRUD;
import model.Personal;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PersonalExercicios extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	private JTable table;

	
	public PersonalExercicios(Personal personal1) {
		personal = personal1;
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
		
		JButton btnPouplateTable = new JButton("Atualizar");
		btnPouplateTable.setForeground(new Color(255, 255, 255));
		btnPouplateTable.setBackground(new Color(20, 167, 245));
		btnPouplateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				ExercicioCRUD crud = new ExercicioCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModel());
				String exercicioid, exercicionome, exerciciorepeticoes, exerciciotempo, exercicioinstrucoes;
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
				
				ResultSet rs = crud.selectJtableContent();
				
				try {
					while(rs.next()) {
						exercicioid = String.valueOf(rs.getString("exercicioid"));
						exercicionome =rs.getString("exercicionome");
						exerciciorepeticoes =rs.getString("exerciciorepeticoes");
						exerciciotempo =rs.getString("exerciciotempo");
						exercicioinstrucoes = rs.getString("exercicioinstrucoes");
						String[] row = {exercicioid, exercicionome,exerciciorepeticoes,exerciciotempo,exercicioinstrucoes};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPouplateTable.setBounds(267, 390, 107, 25);
		contentPane.add(btnPouplateTable);
		
		
	}

}
