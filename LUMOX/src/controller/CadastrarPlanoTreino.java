package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.PlanoTreinoDAO;
import model.Exercicio;
import model.Personal;
import model.PlanoTreino;

public class CadastrarPlanoTreino {
	PlanoTreino planoTreino;
	PlanoTreinoDAO planoTreinoDAO;
	
	public boolean cadastrarPlanoTreino(String nome, ArrayList<Exercicio> treino, Personal personal) {
		planoTreino = new PlanoTreino("Hipertrofia Teste", treino);
		planoTreinoDAO = new PlanoTreinoDAO();
		try {
			planoTreino.setId(planoTreinoDAO.insertPlanoTreino(planoTreino, personal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
