package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.DiaDaSemana;
import model.Exercicio;
import model.PlanoSemanal;

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
            pstmt.setInt(2, Integer.valueOf(exercicio.getRepeticoes()));
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
				+ ", exercicioinstrucoes = ? "
				+ "where exercicioid = ?;";
		
        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, exercicio.getNome());
            pstmt.setInt(2, Integer.valueOf(exercicio.getRepeticoes()));
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

	public Exercicio selectExercicio(Long long1) throws SQLException {
		
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from exercicio where exercicio.exercicioid = ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setLong(1, long1);
        
		ResultSet rs = pstmt.executeQuery();
		
		Exercicio exercicio = null;
		
		while(rs.next()) {
			long id = rs.getLong("exercicioid");
			String nome = rs.getString("exercicionome");
			String rep = String.valueOf(rs.getInt("exerciciorepeticoes")); //mudar no banco para string, tirar o valuof daqui e dar um getString
			String tempo = rs.getString("exerciciotempo");
			String  instr = rs.getString("exercicioinstrucoes");
		
			exercicio = new Exercicio(id, nome, rep, tempo, instr);
		}
		
		return exercicio;
	}

	public ResultSetMetaData selectAllExerciciosModel() throws SQLException {

		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from exercicio;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
        
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rsmd= rs.getMetaData();
		
		return rsmd;
	}
	
	public ResultSet selectAllExerciciosContent() throws SQLException {

		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from exercicio;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
        
		ResultSet rs = pstmt.executeQuery();
		
		
		return rs;
	}

	
}
