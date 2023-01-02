package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PersonalDAO;
import dao.PlanoAlimentarDAO;
import model.Alimento;
import model.Personal;
import model.PlanoAlimentar;

public class PlanoAlimentarCRUD {
	
	PlanoAlimentar planoAlimentar;
	PlanoAlimentarDAO planoAlimentarDAO = new PlanoAlimentarDAO();
	
	public boolean cadastrarPlanoAlimentar(String nome, ArrayList<Alimento> alimentos, Personal personal) {
		planoAlimentar = new PlanoAlimentar(nome, alimentos, personal);
		planoAlimentarDAO = new PlanoAlimentarDAO();
		try {
			planoAlimentar.setId(planoAlimentarDAO.insertPlanoAlimentar(planoAlimentar,personal));
			
			for (Alimento alimento : alimentos) {
				planoAlimentarDAO.insertPlanoAlimentarXAlimento(planoAlimentar, alimento);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePlanoAlimentar(long id, String nome,  ArrayList<Alimento> alimentos, Personal personal) {
		planoAlimentar = new PlanoAlimentar(id, nome, alimentos, personal);
		try {
			planoAlimentarDAO.updatePlanoAlimentar(planoAlimentar, personal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<PlanoAlimentar> selectPlanosAlimentaresToArray() {
		
		ArrayList<PlanoAlimentar> planos = new ArrayList<PlanoAlimentar>();
		
		try {
			ResultSet rs = planoAlimentarDAO.selectAllPlanosAlimentares();
			
			long id =0;
			String nome = null;
			Personal personal = null;
			
			while(rs.next()) {
				id = rs.getLong("planoalimentarid");
				nome = rs.getString("planoalimentarnome");
			
				PersonalDAO personalDAO = new PersonalDAO();
				personal = personalDAO.selectPersonal(rs.getLong("planoalimentarpersonal"));
				
				PlanoAlimentar plano = new PlanoAlimentar(id, nome , personal);
				planos.add(plano);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return planos;
	}
	
	public ResultSet selectPlanosAlimentaresToArrayPersonal() {
		try {
			ResultSet rs = planoAlimentarDAO.selectAllPlanosAlimentaresPersonal();
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String[] selectJTableModelAlimento() {
		
		try {
			ResultSetMetaData rsmd = planoAlimentarDAO.selectAllPlanosPersonalModel();
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
	
	
}
