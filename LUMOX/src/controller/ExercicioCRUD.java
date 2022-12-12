package controller;

import java.sql.SQLException;

import dao.ExercicioDAO;
import model.Exercicio;

public class ExercicioCRUD {
	Exercicio exercicio;
	ExercicioDAO exercicioDAO;
	
	public boolean cadastrarExercicio(String nome, String repet, String tempo,  String instru) {
		exercicio = new Exercicio(nome, repet, tempo, instru);
		exercicioDAO = new ExercicioDAO();
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
}
