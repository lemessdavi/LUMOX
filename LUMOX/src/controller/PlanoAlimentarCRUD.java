package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.PlanoAlimentarDAO;
import model.Alimento;
import model.Personal;
import model.PlanoAlimentar;

public class PlanoAlimentarCRUD {
	
	PlanoAlimentar planoAlimentar;
	PlanoAlimentarDAO planoAlimentarDAO;
	
	public boolean cadastrarPlanoAlimentar(String nome, ArrayList<Alimento> manha,ArrayList<Alimento> tarde,ArrayList<Alimento> noite, Personal personal) {
		planoAlimentar = new PlanoAlimentar(nome, manha, tarde, noite);
		planoAlimentarDAO = new PlanoAlimentarDAO();
		try {
			planoAlimentar.setId(planoAlimentarDAO.insertPlanoAlimentar(planoAlimentar,personal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean cadastrarPlanoAlimentar(long id, String nome, ArrayList<Alimento> manha,ArrayList<Alimento> tarde,ArrayList<Alimento> noite, Personal personal) {
		planoAlimentar = new PlanoAlimentar(id, nome, manha, tarde, noite);
		planoAlimentarDAO = new PlanoAlimentarDAO();
		try {
			planoAlimentarDAO.updatePlanoAlimentar(planoAlimentar, personal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}