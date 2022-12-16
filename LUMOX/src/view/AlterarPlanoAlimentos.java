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

public class AlterarPlanoAlimentos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarPlanoAlimentos frame = new AlterarPlanoAlimentos();
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
	public AlterarPlanoAlimentos() {
		setTitle("Alterar Plano de Alimentos\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 346);
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Alimentos - Manhã");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
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
		btnConfirmar.setBounds(135, 267, 169, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("Alterar Plano de Alimentos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(115, 10, 210, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblTempo = new JLabel("Alimentos - Tarde");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setBounds(28, 156, 180, 14);
		contentPane.add(lblTempo);
		
		JLabel lblAlimentosNoite = new JLabel("Alimentos - Noite");
		lblAlimentosNoite.setForeground(Color.WHITE);
		lblAlimentosNoite.setBounds(28, 205, 180, 14);
		contentPane.add(lblAlimentosNoite);
		
		JComboBox cbAlimentoManha = new JComboBox();
		cbAlimentoManha.setBackground(new Color(76, 76, 76));
		cbAlimentoManha.setForeground(new Color(255, 255, 255));
		cbAlimentoManha.setBounds(28, 122, 180, 20);
		contentPane.add(cbAlimentoManha);
		
		JComboBox cbAlimentoTarde = new JComboBox();
		cbAlimentoTarde.setForeground(Color.WHITE);
		cbAlimentoTarde.setBackground(new Color(76, 76, 76));
		cbAlimentoTarde.setBounds(28, 173, 180, 20);
		contentPane.add(cbAlimentoTarde);
		
		JComboBox cbAlimentoNoite = new JComboBox();
		cbAlimentoNoite.setForeground(Color.WHITE);
		cbAlimentoNoite.setBackground(new Color(76, 76, 76));
		cbAlimentoNoite.setBounds(28, 225, 180, 20);
		contentPane.add(cbAlimentoNoite);
	}
}
