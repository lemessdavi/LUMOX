package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import dao.PersonalDAO;
import dao.PlanoTreinoDAO;
import model.Exercicio;
import model.Personal;
import model.PlanoTreino;

public class PlanoTreinoCRUD {
	PlanoTreino planoTreino;
	PlanoTreinoDAO planoTreinoDAO = new PlanoTreinoDAO();;
	
	public boolean cadastrarPlanoTreino(String nome, ArrayList<Exercicio> treino, Personal personal) {
		planoTreino = new PlanoTreino(nome, treino, personal);
		
		try {
			planoTreino.setId(planoTreinoDAO.insertPlanoTreino(planoTreino, personal));
			
			for (Exercicio exercicio : treino) {
				planoTreinoDAO.inserPlanoTreinoXExercicio(planoTreino, exercicio);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePlanoTreino(long id ,String nome, ArrayList<Exercicio> treino, Personal personal) {
		planoTreino = new PlanoTreino(id, nome, treino, personal);
		planoTreinoDAO = new PlanoTreinoDAO();
		try {
			planoTreinoDAO.updatePlanoTreino(planoTreino, personal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<PlanoTreino> selectPlanosTreinosToArray(){
		ArrayList<PlanoTreino> planos = new ArrayList<>();
		
		try {
			ResultSet rs = planoTreinoDAO.selectAllPlanos();
			
			long id = 0;
			String nome = null;
			Personal personal = null;
		
			while(rs.next()) {
		
				id = rs.getLong("planotreinoid");
				nome = rs.getString("planotreinonome");
		
				PersonalDAO personalDAO = new PersonalDAO();
				personal = personalDAO.selectPersonal(rs.getLong("planotreinopersonal"));
				PlanoTreino plano = new PlanoTreino(id, nome, personal);
				planos.add(plano);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return planos;
			
		
	}

	public String[] selectJTableModelTreino() {
		try {
			ResultSetMetaData rsmd = planoTreinoDAO.selectAllPlanosPersonalModel();
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

	public ResultSet selectPlanosTreinoToArrayPersonal() {
		try {
			ResultSet rs = planoTreinoDAO.selectAllPlanosPersonalContents();
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
