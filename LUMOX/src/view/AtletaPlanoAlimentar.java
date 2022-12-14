package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Atleta;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.*;

import controller.AtletaCRUD;
import dao.AtletaDAO;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AtletaPlanoAlimentar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	Atleta atleta;



	/**
	 * Create the frame.
	 */
	public AtletaPlanoAlimentar(Atleta atleta1) {
		atleta = atleta1;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 919, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 35, 655, 465);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ArrayList<String> dias = new ArrayList<>();
		dias.add("segunda");
		dias.add("terca");
		dias.add("quarta");
		dias.add("quinta");
		dias.add("sexta");
		dias.add("sabado");
		dias.add("domingo");
		
		final JComboBox comboBoxDia = new JComboBox(dias.toArray());
		comboBoxDia.setForeground(new Color(255, 255, 255));
		comboBoxDia.setBackground(new Color(76, 76, 76));
		comboBoxDia.setToolTipText("DiaDaSemana");
		comboBoxDia.setBounds(700, 88, 181, 22);
		contentPane.add(comboBoxDia);
		
		btnNewButton = new JButton("Visualizar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(20, 167, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				AtletaCRUD crud = new AtletaCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModelAlimento((String) comboBoxDia.getSelectedItem(), atleta));
				String alimentonome = null,alimentocalorias = null,alimentopropriedades = null;
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
				
				ResultSet rs = crud.selectJtableContentsAlimento((String) comboBoxDia.getSelectedItem(), atleta);
				
				try {
					while(rs.next()) {
						alimentonome =rs.getString("alimentonome");
						alimentocalorias =rs.getString("alimentocalorias");
						alimentopropriedades =rs.getString("alimentopropriedades");
						String[] row = {alimentonome,alimentocalorias,alimentopropriedades};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(745, 416, 107, 25);
		contentPane.add(btnNewButton);
	}
}
