package controller;

import java.sql.SQLException;

import dao.AtletaDAO;
import dao.PersonalDAO;
import model.Atleta;
import model.Personal;

public class CadastrarPersonal {
	
	private Personal personal;
	private PersonalDAO personalDAO;
	
	public boolean cadastrarPersonal(String nome, String cpf, String login, String senha) {
		personal = new Personal(nome, cpf,login,senha);
		personalDAO = new PersonalDAO();
		try {
			personal.setId(personalDAO.insertPersonal(personal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
