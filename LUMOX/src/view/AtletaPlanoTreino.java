package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AtletaCRUD;
import model.Atleta;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AtletaPlanoTreino extends JFrame {

	private JPanel contentPane;
	private Atleta atleta;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public AtletaPlanoTreino(Atleta a) {
		atleta = a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		comboBoxDia.setBounds(700, 88, 181, 22);
		contentPane.add(comboBoxDia);
		
		JButton btnPopulaTabela = new JButton("Atualizar");
		btnPopulaTabela.setForeground(new Color(255, 255, 255));
		btnPopulaTabela.setBackground(new Color(20, 167, 245));
		btnPopulaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				AtletaCRUD crud = new AtletaCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModelTreino((String) comboBoxDia.getSelectedItem(), atleta));
				String exercicionome, exerciciorepeticoes, exerciciotempo, exercicioinstrucoes;
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
				
				ResultSet rs = crud.selectJtableContentsTreino((String) comboBoxDia.getSelectedItem(), atleta);
				
				try {
					while(rs.next()) {
						exercicionome =rs.getString("exercicionome");
						exerciciorepeticoes =rs.getString("exerciciorepeticoes");
						exerciciotempo =rs.getString("exerciciotempo");
						exercicioinstrucoes = rs.getString("exercicioinstrucoes");
						String[] row = {exercicionome,exerciciorepeticoes,exerciciotempo,exercicioinstrucoes};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPopulaTabela.setBounds(745, 416, 107, 25);
		contentPane.add(btnPopulaTabela);
		
		
	}

}
