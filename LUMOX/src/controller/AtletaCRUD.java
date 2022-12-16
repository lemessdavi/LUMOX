package controller;

import java.sql.ResultSet;
import javax.swing.table.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import dao.AtletaDAO;
import model.Atleta;
import model.PlanoSemanal;

public class AtletaCRUD {
	Atleta modelAtleta;
	AtletaDAO daoAtleta = new AtletaDAO();
		
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
	
	public String[] selectJTableModelAlimento(String dia, Atleta atleta) {
		
		try {
			ResultSetMetaData rsmd = daoAtleta.selectAlimentosDoDiaModel(atleta,dia);
			int cols = rsmd.getColumnCount();
			String[] colName =  new String[cols];
			
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			
			return colName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Atleta verifyLogin(String login, String senha) {
		
		try {
			return daoAtleta.createAtletaOnLogin(login,senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet selectJtableContentsAlimento(String dia, Atleta atleta) {
		try {
			ResultSet rs = daoAtleta.selectAlimentosDoDiaContent(atleta,dia);
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[] selectJTableModelTreino(String dia, Atleta atleta) {
		try {
			ResultSetMetaData rsmd = daoAtleta.selectExerciciosDoDiaModel(atleta,dia);
			int cols = rsmd.getColumnCount();
			String[] colName =  new String[cols];
			
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			
			return colName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet selectJtableContentsTreino(String dia, Atleta atleta) {
		
		
		try {
			ResultSet rs = daoAtleta.selectExerciciosDoDiaContent(atleta,dia);
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
