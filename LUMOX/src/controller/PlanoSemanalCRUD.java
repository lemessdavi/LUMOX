package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DiaDaSemanaDAO;
import dao.ExercicioDAO;
import dao.PersonalDAO;
import dao.PlanoSemanalDAO;
import model.DiaDaSemana;
import model.Exercicio;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoSemanal;

public class PlanoSemanalCRUD {
	PlanoSemanal planoSemanal;
	PlanoSemanalDAO planoSemanalDAO = new PlanoSemanalDAO();;
	
	public boolean cadastrarPlanoSemanal(String nome, DiaDaSemana segunda, DiaDaSemana terca, DiaDaSemana quarta,
			DiaDaSemana quinta, DiaDaSemana sexta, DiaDaSemana sabado, DiaDaSemana domingo) {
		planoSemanal = new PlanoSemanal(nome, segunda, terca, quarta, quinta, sexta, sabado, domingo);
		
		try {
			planoSemanal.setId(planoSemanalDAO.insertPlanoSemanal(planoSemanal));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePlanoSemanal(long id, String nome, DiaDaSemana segunda, DiaDaSemana terca, DiaDaSemana quarta,
			DiaDaSemana quinta, DiaDaSemana sexta, DiaDaSemana sabado, DiaDaSemana domingo) {
		planoSemanal = new PlanoSemanal(id, nome, segunda, terca, quarta, quinta, sexta, sabado, domingo);
		try {
			planoSemanalDAO.updatePlanoSemanal(planoSemanal);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<PlanoSemanal> selectAllPlanosToArray() {
		ArrayList<PlanoSemanal> planos = new ArrayList<PlanoSemanal>();
		
		try {
			ResultSet rs = planoSemanalDAO.selectAllPlanosAlimentares();
			
			DiaDaSemanaDAO diaDao = new DiaDaSemanaDAO();
			
			PlanoSemanal plano = null;
			
			while(rs.next()) {
			DiaDaSemana segunda = diaDao.selectDiaDaSemana(rs.getLong("segunda"));
			DiaDaSemana terca = diaDao.selectDiaDaSemana(rs.getLong("terca"));
			DiaDaSemana quarta = diaDao.selectDiaDaSemana(rs.getLong("quarta"));
			DiaDaSemana quinta = diaDao.selectDiaDaSemana(rs.getLong("quinta"));
			DiaDaSemana sexta = diaDao.selectDiaDaSemana(rs.getLong("sexta"));
			DiaDaSemana sabado = diaDao.selectDiaDaSemana(rs.getLong("sabado"));
			DiaDaSemana domingo = diaDao.selectDiaDaSemana(rs.getLong("domingo"));
			
			plano = new PlanoSemanal(rs.getLong("planosemanalid"), rs.getString("nome"), segunda, terca, quarta, quinta, sexta, sabado, domingo);
			planos.add(plano);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return planos;
	}
}
