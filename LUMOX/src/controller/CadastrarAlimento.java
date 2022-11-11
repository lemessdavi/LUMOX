package controller;

import java.sql.SQLException;

import dao.AlimentoDAO;
import model.Alimento;

public class CadastrarAlimento {
	private Alimento modelAlimento;
	private AlimentoDAO daoAlimento;
	
	
	public boolean cadastrarAlimento(String nome, int calorias, String propriedades) throws SQLException {
		modelAlimento = new Alimento(nome,calorias,propriedades);
		daoAlimento = new AlimentoDAO();
		try {
			modelAlimento.setId(daoAlimento.insertAlimento(modelAlimento));
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
}
