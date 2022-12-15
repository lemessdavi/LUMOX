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
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 674, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 22, 398, 366);
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
		comboBoxDia.setBounds(465, 41, 141, 22);
		contentPane.add(comboBoxDia);
		
		JButton btnPopulaTabela = new JButton("New button");
		btnPopulaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				AtletaCRUD crud = new AtletaCRUD();
				
				model.setColumnIdentifiers(crud.selectJTableModelTreino((String) comboBoxDia.getSelectedItem(), atleta));
				
				while(model.getRowCount() > 0)
				{
					model.removeRow(0);
				}
			}
		});
		btnPopulaTabela.setBounds(494, 162, 89, 23);
		contentPane.add(btnPopulaTabela);
		
		
	}

}
