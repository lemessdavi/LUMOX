package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Personal;
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
}
