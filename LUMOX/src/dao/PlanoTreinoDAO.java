package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DiaDaSemana;
import model.Exercicio;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoTreino;

public class PlanoTreinoDAO {
	
	public long insertPlanoTreino(PlanoTreino plano, Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into planotreino (planotreinonome, planotreinopersonal) "
				+ "values  (?,?)" ;
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, plano.getNome());
            pstmt.setLong(2, personal.getId());
           

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
		return id;
	}
	
	public boolean updatePlanoTreino(PlanoTreino plano, Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = " update planotreino "
				+ "set planotreinonome = ?,"
				+ "planotreinopersonal = ?"
				+ "where planotreinoid = ?;" ;
		

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, plano.getNome());
            pstmt.setLong(2, personal.getId());
            pstmt.setLong(3, plano.getId());
           

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
               return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       
		return false;
	}

	public PlanoTreino selectPlanoTreino(long ids) throws SQLException {
		
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from planotreinoxexercicio inner join planotreino on planotreinoxexercicio.planotreinoid = planotreino.planotreinoid where planotreino.planotreinoid = ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setLong(1, ids);
        
		ResultSet rs = pstmt.executeQuery();
		
		long id = 0;
		String nome = null;
		Personal personal = null;
		
		while(rs.next()) {
		
			id = rs.getLong("planotreinoid");
			nome = rs.getString("planotreinonome");
		
			PersonalDAO personalDAO = new PersonalDAO();
			personal = personalDAO.selectPersonal(rs.getLong("planotreinopersonal"));
		
		}
		
		ArrayList<Exercicio> exercicios = new ArrayList();
		
		List<Long> exerciciosids = new ArrayList<>();
		
		
		String sql = "select planotreinoxexercicio.exercicioid from planotreinoxexercicio inner join planotreino on planotreinoxexercicio.planotreinoid = planotreino.planotreinoid  where planotreino.planotreinoid = ?;";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, ids);
		
		ResultSet rs2 = stmt.executeQuery(); 
		
		while (rs2.next()) {
			exerciciosids.add(rs2.getLong("exercicioid"));
		}
		
		for (Long long1 : exerciciosids) {
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			Exercicio exercicio = exercicioDAO.selectExercicio(long1);
			exercicios.add(exercicio);
		}
		    
		
		PlanoTreino plano = new PlanoTreino(id, nome, exercicios, personal);
		
		
		return plano;
	}
}
