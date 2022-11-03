package test;

import java.sql.SQLException;

import dao.AlimentoDAO;
import model.Alimento;

public class App {
	public static void main(String[] args) {
		
		Alimento alimento = new Alimento("Batata", 10, "é uma batata ");
		AlimentoDAO alimentoDAO = new AlimentoDAO();
		try {
			alimento.setId(alimentoDAO.insertAlimento(alimento));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
