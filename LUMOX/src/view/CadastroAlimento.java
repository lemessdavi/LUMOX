package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CRUDAlimento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroAlimento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCalorias;
	private JTextField textFieldPropriedades;
	private CRUDAlimento alimentoController = new CRUDAlimento();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlimento frame = new CadastroAlimento();
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
	public CadastroAlimento() {
		setTitle("Cadastro de Alimento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(28, 49, 113, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 32, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Calorias");
		lblCalorias.setBounds(28, 106, 91, 14);
		contentPane.add(lblCalorias);
		
		textFieldCalorias = new JTextField();
		textFieldCalorias.setColumns(10);
		textFieldCalorias.setBounds(28, 123, 113, 20);
		contentPane.add(textFieldCalorias);
		
		JLabel lblPropriedades = new JLabel("Propriedades");
		lblPropriedades.setBounds(242, 32, 113, 14);
		contentPane.add(lblPropriedades);
		
		textFieldPropriedades = new JTextField();
		textFieldPropriedades.setColumns(10);
		textFieldPropriedades.setBounds(242, 49, 162, 94);
		contentPane.add(textFieldPropriedades);
		
		JButton btnCadastrar = new JButton("Cadastrar Alimento");
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
		btnCadastrar.setBounds(132, 208, 169, 23);
		contentPane.add(btnCadastrar);
	}

}
