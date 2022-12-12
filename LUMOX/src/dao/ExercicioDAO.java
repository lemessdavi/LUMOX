package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Exercicio;

public class ExercicioDAO {
	
	public long insertExercicio(Exercicio exercicio) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into exercicio (exercicionome, exerciciorepeticoes, exerciciotempo, exercicioinstrucoes)"
				+ "values  (?, ?, ?, ? )";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, exercicio.getNome());
            pstmt.setString(2, exercicio.getRepeticoes());
            pstmt.setString(3, exercicio.getTempo());
            pstmt.setString(4, exercicio.getInstrucoes());

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

	public boolean updateExercicio(Exercicio exercicio) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update exercicio "
				+ "set exercicionome = ?"
				+ ", exerciciorepeticoes = ?"
				+ ", exerciciotempo = ?"
				+ ", exercicioinstrucoes = ?"
				+ "where exercicioid = ?;";
		
        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, exercicio.getNome());
            pstmt.setString(2, exercicio.getRepeticoes());
            pstmt.setString(3, exercicio.getTempo());
            pstmt.setString(4, exercicio.getInstrucoes());
            pstmt.setLong(5, exercicio.getId());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
              return true;
            }
        }
		return false;
	}
}
