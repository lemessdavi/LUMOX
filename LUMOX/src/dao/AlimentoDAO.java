package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Alimento;

public class AlimentoDAO {

	public long insertAlimento(Alimento alimento) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into alimento (alimentonome, alimentocalorias, alimentopropriedades)"
				+ "values  (?, ?, ? )";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, alimento.getNome());
            pstmt.setDouble(2, alimento.getCalorias());
            pstmt.setString(3, alimento.getPropriedades());

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
	

	public boolean updateAlimento(Alimento alimento) throws SQLException{
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update alimento "
				+ "set alimentonome = ? "
				+ ", alimentocalorias = ? "
				+ ", alimentopropriedades  = ? "
				+ "where alimentoid = ?;";

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, alimento.getNome());
            pstmt.setDouble(2, alimento.getCalorias());
            pstmt.setString(3, alimento.getPropriedades());
            pstmt.setLong(4, alimento.getId());

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
