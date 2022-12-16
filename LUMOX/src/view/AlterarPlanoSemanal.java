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

public class AlterarPlanoSemanal extends JFrame {

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
					AlterarPlanoSemanal frame = new AlterarPlanoSemanal();
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
	public AlterarPlanoSemanal() {
		setTitle("Alterar Plano Semanal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(255, 255, 255));
		textFieldNome.setBackground(new Color(76, 76, 76));
		textFieldNome.setBounds(28, 76, 279, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(28, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCalorias = new JLabel("Atleta:");
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
		btnConfirmar.setBounds(334, 334, 169, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("Alterar Plano Semanal");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(335, 10, 167, 36);
		contentPane.add(lblNewLabel);
		
		JComboBox cbAtleta = new JComboBox();
		cbAtleta.setBackground(new Color(76, 76, 76));
		cbAtleta.setForeground(new Color(255, 255, 255));
		cbAtleta.setBounds(28, 122, 279, 20);
		contentPane.add(cbAtleta);
		
		JLabel lblSegundafeira = new JLabel("Segunda-feira");
		lblSegundafeira.setForeground(Color.WHITE);
		lblSegundafeira.setBounds(28, 233, 100, 14);
		contentPane.add(lblSegundafeira);
		
		JLabel lblCalorias_1_1 = new JLabel("Terça-feira");
		lblCalorias_1_1.setForeground(Color.WHITE);
		lblCalorias_1_1.setBounds(158, 233, 68, 14);
		contentPane.add(lblCalorias_1_1);
		
		JLabel lblCalorias_1_2 = new JLabel("Quarta-feira");
		lblCalorias_1_2.setForeground(Color.WHITE);
		lblCalorias_1_2.setBounds(270, 233, 70, 14);
		contentPane.add(lblCalorias_1_2);
		
		JLabel lblCalorias_1_3 = new JLabel("Quinta-feira");
		lblCalorias_1_3.setForeground(Color.WHITE);
		lblCalorias_1_3.setBounds(393, 233, 83, 14);
		contentPane.add(lblCalorias_1_3);
		
		JLabel lblCalorias_1_4 = new JLabel("Sexta-feira");
		lblCalorias_1_4.setForeground(Color.WHITE);
		lblCalorias_1_4.setBounds(511, 233, 83, 14);
		contentPane.add(lblCalorias_1_4);
		
		JLabel lblCalorias_1_5 = new JLabel("Sábado");
		lblCalorias_1_5.setForeground(Color.WHITE);
		lblCalorias_1_5.setBounds(637, 233, 68, 14);
		contentPane.add(lblCalorias_1_5);
		
		JLabel lblCalorias_1_6 = new JLabel("Domingo");
		lblCalorias_1_6.setForeground(Color.WHITE);
		lblCalorias_1_6.setBounds(744, 233, 70, 14);
		contentPane.add(lblCalorias_1_6);
		
		JComboBox cbPlanAliSegunda = new JComboBox();
		cbPlanAliSegunda.setForeground(Color.WHITE);
		cbPlanAliSegunda.setBackground(new Color(76, 76, 76));
		cbPlanAliSegunda.setBounds(28, 259, 89, 20);
		contentPane.add(cbPlanAliSegunda);
		
		JComboBox cbPlanTreiSegunda = new JComboBox();
		cbPlanTreiSegunda.setForeground(Color.WHITE);
		cbPlanTreiSegunda.setBackground(new Color(76, 76, 76));
		cbPlanTreiSegunda.setBounds(28, 291, 89, 20);
		contentPane.add(cbPlanTreiSegunda);
		
		JComboBox cbPlanAliTerca = new JComboBox();
		cbPlanAliTerca.setForeground(Color.WHITE);
		cbPlanAliTerca.setBackground(new Color(76, 76, 76));
		cbPlanAliTerca.setBounds(150, 259, 89, 20);
		contentPane.add(cbPlanAliTerca);
		
		JComboBox cbPlanTreiTerca = new JComboBox();
		cbPlanTreiTerca.setForeground(Color.WHITE);
		cbPlanTreiTerca.setBackground(new Color(76, 76, 76));
		cbPlanTreiTerca.setBounds(150, 291, 89, 20);
		contentPane.add(cbPlanTreiTerca);
		
		JComboBox cbPlanAliQuarta = new JComboBox();
		cbPlanAliQuarta.setForeground(Color.WHITE);
		cbPlanAliQuarta.setBackground(new Color(76, 76, 76));
		cbPlanAliQuarta.setBounds(261, 259, 89, 20);
		contentPane.add(cbPlanAliQuarta);
		
		JComboBox cbPlanTreiQuarta = new JComboBox();
		cbPlanTreiQuarta.setForeground(Color.WHITE);
		cbPlanTreiQuarta.setBackground(new Color(76, 76, 76));
		cbPlanTreiQuarta.setBounds(261, 291, 89, 20);
		contentPane.add(cbPlanTreiQuarta);
		
		JComboBox cbPlanAliQuinta = new JComboBox();
		cbPlanAliQuinta.setForeground(Color.WHITE);
		cbPlanAliQuinta.setBackground(new Color(76, 76, 76));
		cbPlanAliQuinta.setBounds(387, 259, 89, 20);
		contentPane.add(cbPlanAliQuinta);
		
		JComboBox cbPlanTreiQuinta = new JComboBox();
		cbPlanTreiQuinta.setForeground(Color.WHITE);
		cbPlanTreiQuinta.setBackground(new Color(76, 76, 76));
		cbPlanTreiQuinta.setBounds(387, 291, 89, 20);
		contentPane.add(cbPlanTreiQuinta);
		
		JComboBox cbPlanAliSexta = new JComboBox();
		cbPlanAliSexta.setForeground(Color.WHITE);
		cbPlanAliSexta.setBackground(new Color(76, 76, 76));
		cbPlanAliSexta.setBounds(505, 259, 89, 20);
		contentPane.add(cbPlanAliSexta);
		
		JComboBox cbPlanTreiSexta = new JComboBox();
		cbPlanTreiSexta.setForeground(Color.WHITE);
		cbPlanTreiSexta.setBackground(new Color(76, 76, 76));
		cbPlanTreiSexta.setBounds(505, 291, 89, 20);
		contentPane.add(cbPlanTreiSexta);
		
		JComboBox cbPlanAliSabado = new JComboBox();
		cbPlanAliSabado.setForeground(Color.WHITE);
		cbPlanAliSabado.setBackground(new Color(76, 76, 76));
		cbPlanAliSabado.setBounds(616, 259, 89, 20);
		contentPane.add(cbPlanAliSabado);
		
		JComboBox cbPlanTreiSabado = new JComboBox();
		cbPlanTreiSabado.setForeground(Color.WHITE);
		cbPlanTreiSabado.setBackground(new Color(76, 76, 76));
		cbPlanTreiSabado.setBounds(616, 291, 89, 20);
		contentPane.add(cbPlanTreiSabado);
		
		JComboBox cbPlanAliDomingo = new JComboBox();
		cbPlanAliDomingo.setForeground(Color.WHITE);
		cbPlanAliDomingo.setBackground(new Color(76, 76, 76));
		cbPlanAliDomingo.setBounds(725, 259, 89, 20);
		contentPane.add(cbPlanAliDomingo);
		
		JComboBox cbPlanTreiDomingo = new JComboBox();
		cbPlanTreiDomingo.setForeground(Color.WHITE);
		cbPlanTreiDomingo.setBackground(new Color(76, 76, 76));
		cbPlanTreiDomingo.setBounds(725, 291, 89, 20);
		contentPane.add(cbPlanTreiDomingo);
		
		JLabel lblSemanaPlano = new JLabel("Dia / Planos");
		lblSemanaPlano.setForeground(Color.WHITE);
		lblSemanaPlano.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSemanaPlano.setBounds(369, 165, 100, 36);
		contentPane.add(lblSemanaPlano);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(51, 213, 736, 5);
		contentPane.add(panel);
	}
}
