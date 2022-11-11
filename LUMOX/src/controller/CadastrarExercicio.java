package controller;

import java.sql.SQLException;

import dao.ExercicioDAO;
import model.Exercicio;

public class CadastrarExercicio {
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
}
