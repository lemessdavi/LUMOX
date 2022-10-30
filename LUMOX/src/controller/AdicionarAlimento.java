package controller;

import java.sql.SQLException;

import dao.AlimentoDAO;
import model.Alimento;

public class AdicionarAlimento {
	private Alimento modelAlimento;
	private AlimentoDAO daoAlimento;
	
	public AdicionarAlimento() {
		daoAlimento = new AlimentoDAO();
	}
	
	public void btnCadastrarAlimento(String nome, int calorias, String propriedades) throws SQLException {
		Alimento alimento = new Alimento(nome,calorias,propriedades);
		alimento.setId(daoAlimento.insertAlimento(alimento));
		
	}
	
	
	
}
