package controller;

import java.sql.SQLException;

import dao.DiaDaSemanaDAO;
import model.DiaDaSemana;
import model.PlanoAlimentar;
import model.PlanoTreino;

public class CadastrarDiaDaSemana {
	
	DiaDaSemana dia;
	DiaDaSemanaDAO diaDAO;
	
	public boolean cadastrarDiaDaSemana(String diaNome, PlanoAlimentar planoAlimentar, PlanoTreino planoTreino) {
		dia = new DiaDaSemana(diaNome, planoAlimentar, planoTreino);
		diaDAO= new DiaDaSemanaDAO();
		try {
			dia.setId(diaDAO.insertDiaDaSemana(dia, planoAlimentar, planoTreino));
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
