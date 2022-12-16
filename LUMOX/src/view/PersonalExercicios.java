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

public class PersonalExercicios extends JFrame {

	private JPanel contentPane;
	private Personal personal;
	private JTable table;

	
	public PersonalExercicios(Personal personal1) {
		personal = personal1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 378, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPouplateTable = new JButton("New button");
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
		btnPouplateTable.setBounds(490, 322, 89, 23);
		contentPane.add(btnPouplateTable);
		
		
	}

}
