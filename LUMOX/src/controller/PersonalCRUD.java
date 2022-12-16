package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import dao.AtletaDAO;
import dao.PersonalDAO;
import model.Atleta;
import model.Personal;

public class PersonalCRUD {
	
	private Personal personal;
	private PersonalDAO personalDAO = new PersonalDAO();;
	
	public boolean cadastrarPersonal(String nome, String cpf, String login, String senha) {
		personal = new Personal(nome, cpf,login,senha);
		try {
			personal.setId(personalDAO.insertPersonal(personal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePersonal(long id, String nome, String cpf, String login, String senha) {
		personal = new Personal(id, nome, cpf,login,senha);
		personalDAO = new PersonalDAO();
		try {
			personalDAO.updatePersonal(personal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Personal verifyLogin(String login, String senha) {
		try {
			return personalDAO.createPersonalOnLogin(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}

	
}
