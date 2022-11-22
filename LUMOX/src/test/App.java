package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;

import dao.AlimentoDAO;
import dao.AtletaDAO;
import dao.ExercicioDAO;
import dao.PersonalDAO;
import dao.PlanoAlimentarDAO;
import dao.PlanoTreinoDAO;
import model.Alimento;
import model.Atleta;
import model.DiaDaSemana;
import model.Exercicio;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoSemanal;
import model.PlanoTreino;

public class App {
	public static void main(String[] args) throws SQLException {
		
		Personal personal = new Personal("PersonalTeste", "3242342", "email@email", "senha");
		PersonalDAO personalDAO = new PersonalDAO();
		try {
			personal.setId(personalDAO.insertPersonal(personal));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Alimento alimento = new Alimento("Batata", 10, "é uma batata ");
		AlimentoDAO alimentoDAO = new AlimentoDAO();
		try {
			alimento.setId(alimentoDAO.insertAlimento(alimento));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Exercicio exercicio = new Exercicio("Abnominal","3x15", "0","Ate a falha");
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		try {
			exercicio.setId(exercicioDAO.insertExercicio(exercicio));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Exercicio> treino = new ArrayList();
		treino.add(exercicio);
		
		PlanoTreino planoTreino = new PlanoTreino("Hipertrofia Teste", treino);
		PlanoTreinoDAO planoTreinoDAO = new PlanoTreinoDAO();
		try {
			planoTreino.setId(planoTreinoDAO.insertPlanoTreino(planoTreino, personal));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Alimento> manha = new ArrayList();
		ArrayList<Alimento> tarde = new ArrayList();
		ArrayList<Alimento> noite = new ArrayList();
		
		manha.add(alimento);
		tarde.add(alimento);
		noite.add(alimento);
		
		PlanoAlimentar planoAlimentar = new PlanoAlimentar("So carbo", manha, tarde, noite);
		PlanoAlimentarDAO planoAlimentarDAO = new PlanoAlimentarDAO();
		try {
			planoAlimentar.setId(planoAlimentarDAO.insertPlanoAlimentar(planoAlimentar,personal));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		DiaDaSemana domingo = new DiaDaSemana("segunda", planoAlimentar, planoTreino);
		
		ArrayList<DiaDaSemana> semana = new ArrayList();
		
		PlanoSemanal planoSemanal = new PlanoSemanal("Semana Carbo", semana);
		
		Atleta atleta = new Atleta("Teste", "28394298", "teste@gmail.com", "123");
		AtletaDAO atletaDao = new AtletaDAO();
		alimentoDAO.selectAlimentos().forEach(new Consumer<Alimento>() {
			@Override
			public void accept(Alimento a) {
				System.out.println(a.getId());
			}
		});;
		
	}
}	
