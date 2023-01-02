package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlimentoCRUD;
import model.Atleta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class SolicitarAlteracao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescricao;
	private AlimentoCRUD alimentoController = new AlimentoCRUD();
	private JTextField textFieldNomePlano;

	
	public SolicitarAlteracao(Atleta atlea) {
		setTitle("Solicitar Alteração");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setForeground(new Color(255, 255, 255));
		textFieldDescricao.setBackground(new Color(76, 76, 76));
		textFieldDescricao.setBounds(28, 120, 434, 111);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome do plano:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 95, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Descrição:");
		lblCalorias.setForeground(new Color(255, 255, 255));
		lblCalorias.setBounds(28, 106, 161, 14);
		contentPane.add(lblCalorias);
		
		JButton btnEnviarSolicitacao = new JButton("Enviar Solicitação");
		btnEnviarSolicitacao.setForeground(new Color(255, 255, 255));
		btnEnviarSolicitacao.setBackground(new Color(20, 167, 245));
//		btnEnviarSolicitacao.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					if(alimentoController.cadastrarAlimento(textFieldDescricao.getText(), Integer.parseInt(textFieldRepeticoes.getText()) , textFieldInstrucoes.getText())) {
//						PopUp telaOk = new PopUp("Cadastro Realizado");
//						telaOk.show(true);
//					}else {
//						PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
//					telaErro.show(true);
//					}
//				} catch (NumberFormatException | SQLException e1) {
//					PopUp telaErro = new PopUp("Erro, Cadastro Não Realizado");
//					telaErro.show(true);
//				}
//			}
//		});
		btnEnviarSolicitacao.setBounds(159, 243, 169, 23);
		contentPane.add(btnEnviarSolicitacao);
		
		JLabel lblNewLabel = new JLabel("Solicitar Alteração");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(168, 10, 150, 36);
		contentPane.add(lblNewLabel);
		
		textFieldNomePlano = new JTextField();
		textFieldNomePlano.setEditable(false);
		textFieldNomePlano.setForeground(Color.WHITE);
		textFieldNomePlano.setColumns(10);
		textFieldNomePlano.setBackground(new Color(76, 76, 76));
		textFieldNomePlano.setBounds(28, 74, 180, 20);
		contentPane.add(textFieldNomePlano);
	}
}
