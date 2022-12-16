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

public class CadastroExercicio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRepeticoes;
	private JTextField textFieldInstrucoes;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private JTextField textFieldTempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroExercicio frame = new CadastroExercicio();
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
	public CadastroExercicio() {
		setTitle("Cadastro de Exercício");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 392);
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
		
		JLabel lblCalorias = new JLabel("Repetições:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 91, 14);
		contentPane.add(lblCalorias);
		
		textFieldRepeticoes = new JTextField();
		textFieldRepeticoes.setForeground(new Color(255, 255, 255));
		textFieldRepeticoes.setBackground(new Color(76, 76, 76));
		textFieldRepeticoes.setColumns(10);
		textFieldRepeticoes.setBounds(28, 123, 180, 20);
		contentPane.add(textFieldRepeticoes);
		
		JLabel lblPropriedades = new JLabel("Instruções:");
		lblPropriedades.setForeground(new Color(255, 255, 255));
		lblPropriedades.setBounds(28, 204, 113, 14);
		contentPane.add(lblPropriedades);
		
		textFieldInstrucoes = new JTextField();
		textFieldInstrucoes.setForeground(new Color(255, 255, 255));
		textFieldInstrucoes.setBackground(new Color(76, 76, 76));
		textFieldInstrucoes.setColumns(10);
		textFieldInstrucoes.setBounds(28, 230, 381, 68);
		contentPane.add(textFieldInstrucoes);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(20, 167, 245));
		btnCadastrar.addActionListener(new ActionListener() {
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
		btnCadastrar.setBounds(132, 317, 169, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Exercício");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(143, 10, 150, 36);
		contentPane.add(lblNewLabel);
		
		textFieldTempo = new JTextField();
		textFieldTempo.setForeground(Color.WHITE);
		textFieldTempo.setColumns(10);
		textFieldTempo.setBackground(new Color(76, 76, 76));
		textFieldTempo.setBounds(28, 172, 180, 20);
		contentPane.add(textFieldTempo);
		
		JLabel lblTempo = new JLabel("Tempo:");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setBounds(28, 155, 91, 14);
		contentPane.add(lblTempo);
	}

}
