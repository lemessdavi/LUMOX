package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import dao.ExercicioDAO;
import model.Atleta;
import model.Exercicio;

public class ExercicioCRUD {
	Exercicio exercicio;
	ExercicioDAO exercicioDAO = new ExercicioDAO();;
	
	public boolean cadastrarExercicio(String nome, String repet, String tempo,  String instru) {
		exercicio = new Exercicio(nome, repet, tempo, instru);
		try {
			exercicio.setId(exercicioDAO.insertExercicio(exercicio));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateExercicio(long id,String nome, String repet, String tempo,  String instru) {
		exercicio = new Exercicio(id,nome, repet, tempo, instru);
		exercicioDAO = new ExercicioDAO();
		try {
			exercicioDAO.updateExercicio(exercicio);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public String[] selectJTableModel() {
		
		try {
			ResultSetMetaData rsmd = exercicioDAO.selectAllExerciciosModel();
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
	
	
	public ResultSet selectJtableContent() {
		
		
		try {
			ResultSet rs = exercicioDAO.selectAllExerciciosContent();
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Exercicio> selectAllExerciciosToArray(){
		ArrayList<Exercicio> exercicios = new ArrayList<>();
		try {
			ResultSet rs = exercicioDAO.selectAllExerciciosContent();
			while(rs.next()) {
				long id = rs.getLong("exercicioid");
				String nome = rs.getString("exercicionome");
				String rep = String.valueOf(rs.getInt("exerciciorepeticoes")); //mudar no banco para string, tirar o valuof daqui e dar um getString
				String tempo = rs.getString("exerciciotempo");
				String  instr = rs.getString("exercicioinstrucoes");
			
				Exercicio exercicio = new Exercicio(id, nome, rep, tempo, instr);
				exercicios.add(exercicio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exercicios;
	}
}
