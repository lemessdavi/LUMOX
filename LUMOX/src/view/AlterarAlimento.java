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

public class AlterarAlimento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCalorias;
	private JTextField textFieldPropriedades;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarAlimento frame = new AlterarAlimento();
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
	public AlterarAlimento() {
		setTitle("Cadastro de Alimento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 337);
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
		
		JLabel lblCalorias = new JLabel("Calorias:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 91, 14);
		contentPane.add(lblCalorias);
		
		textFieldCalorias = new JTextField();
		textFieldCalorias.setForeground(new Color(255, 255, 255));
		textFieldCalorias.setBackground(new Color(76, 76, 76));
		textFieldCalorias.setColumns(10);
		textFieldCalorias.setBounds(28, 123, 180, 20);
		contentPane.add(textFieldCalorias);
		
		JLabel lblPropriedades = new JLabel("Propriedades:");
		lblPropriedades.setForeground(new Color(255, 255, 255));
		lblPropriedades.setBounds(28, 152, 113, 14);
		contentPane.add(lblPropriedades);
		
		textFieldPropriedades = new JTextField();
		textFieldPropriedades.setForeground(new Color(255, 255, 255));
		textFieldPropriedades.setBackground(new Color(76, 76, 76));
		textFieldPropriedades.setColumns(10);
		textFieldPropriedades.setBounds(28, 169, 381, 68);
		contentPane.add(textFieldPropriedades);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(20, 167, 245));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(alimentoController.cadastrarAlimento(textFieldNome.getText(), Integer.parseInt(textFieldCalorias.getText()) , textFieldPropriedades.getText())) {
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
		btnCadastrar.setBounds(163, 257, 113, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Alimento");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(143, 10, 150, 36);
		contentPane.add(lblNewLabel);
	}

}
