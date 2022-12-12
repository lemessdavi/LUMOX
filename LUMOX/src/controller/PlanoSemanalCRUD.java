package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ExercicioDAO;
import dao.PlanoSemanalDAO;
import model.DiaDaSemana;
import model.Exercicio;
import model.PlanoSemanal;

public class PlanoSemanalCRUD {
	PlanoSemanal planoSemanal;
	PlanoSemanalDAO planoSemanalDAO;
	
	public boolean cadastrarExercicio(String nome, ArrayList<DiaDaSemana> semana) {
		planoSemanal = new PlanoSemanal(nome, semana);
		planoSemanalDAO = new PlanoSemanalDAO();
		try {
			planoSemanal.setId(planoSemanalDAO.insertPlanoSemanal(planoSemanal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateExercicio(long id, String nome, ArrayList<DiaDaSemana> semana) {
		planoSemanal = new PlanoSemanal(id, nome, semana);
		planoSemanalDAO = new PlanoSemanalDAO();
		try {
			planoSemanalDAO.updatePlanoSemanal(planoSemanal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
