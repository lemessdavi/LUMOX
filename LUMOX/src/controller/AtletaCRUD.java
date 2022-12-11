package controller;

import java.sql.SQLException;

import dao.AtletaDAO;
import model.Atleta;
import model.PlanoSemanal;

public class AtletaCRUD {
	Atleta modelAtleta;
	AtletaDAO daoAtleta;
		
	public boolean cadastrarAtleta(String nome, String cpf, String login, String senha, PlanoSemanal planoSemanal) throws SQLException {
		modelAtleta = new Atleta(nome,cpf,login,senha);
		try {
			modelAtleta.setId(daoAtleta.insertAtleta(modelAtleta, planoSemanal));
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateAtleta(long id,String nome, String cpf, String login, String senha, PlanoSemanal planoSemanal) {
		modelAtleta = new Atleta(id,nome,cpf,login,senha);
		
		try {
			daoAtleta.updateAtleta(modelAtleta, planoSemanal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
