package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PlanoAlimentarCRUD;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PersonalPlanosAlimento extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public PersonalPlanosAlimento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 609, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(20, 167, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				PlanoAlimentarCRUD crud = new PlanoAlimentarCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModelAlimento());
				String planoalimentarnome=null, alimentonome = null,alimentocalorias = null,alimentopropriedades = null;
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
				
				ResultSet rs = crud.selectPlanosAlimentaresToArrayPersonal();
				
				try {
					while(rs.next()) {
						String nome = rs.getString(1);
						String nomeA = rs.getString(2);
						String calorias = String.valueOf(rs.getInt(3));
						String prop = rs.getString(4);
						
						String[] row = {nome, nomeA,calorias,prop};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(267, 391, 107, 25);
		contentPane.add(btnNewButton);
	}

}
