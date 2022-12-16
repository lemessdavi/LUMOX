package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class VisualizarPlanoTreinos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarPlanoTreinos frame = new VisualizarPlanoTreinos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizarPlanoTreinos() {
		setTitle("Visualizar Plano de Treino");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 296);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(255, 255, 255));
		textFieldNome.setBackground(new Color(76, 76, 76));
		textFieldNome.setBounds(28, 76, 180, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Exercícios");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 153, 161, 14);
		contentPane.add(lblCalorias);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(20, 167, 245));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(alimentoController.cadastrarAlimento(textFieldNome.getText(), Integer.parseInt(textFieldRepeticoes.getText()) , textFieldInstrucoes.getText())) {
						PopUp telaOk = new PopUp("Cadastro Realizado");
						telaOk.show(true);
					}else {
						PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
					}
				} catch (NumberFormatException | SQLException e1) {
					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
					telaErro.show(true);
				}
			}
		});
		btnConfirmar.setBounds(137, 216, 169, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("Visualizar Plano de Treinos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(118, 10, 203, 36);
		contentPane.add(lblNewLabel);
		
		JComboBox cbExercicios = new JComboBox();
		cbExercicios.setBackground(new Color(76, 76, 76));
		cbExercicios.setForeground(new Color(255, 255, 255));
		cbExercicios.setBounds(28, 169, 180, 20);
		contentPane.add(cbExercicios);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(new Color(76, 76, 76));
		textField.setBounds(28, 125, 180, 20);
		contentPane.add(textField);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da semana");
		lblDiaDaSemana.setForeground(Color.WHITE);
		lblDiaDaSemana.setBounds(28, 108, 101, 14);
		contentPane.add(lblDiaDaSemana);
	}
}
