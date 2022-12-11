package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Alimento;
import model.Atleta;
import model.PlanoSemanal;

public class AtletaDAO {

	public long insertAtleta(Atleta atleta, PlanoSemanal planoSemanal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into atleta (atletanome, atletacpf, atletaemail, atletasenha, atletaplanosemanal)"
				+ "values  (?, ?, ?, ?, ?) ";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

        	pstmt.setString(1, atleta.getNome());
            pstmt.setString(2, atleta.getCpf());
            pstmt.setString(3, atleta.getLogin());
            pstmt.setString(4, atleta.getSenha());
            pstmt.setInt(5, planoSemanal.getId());

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
	
	public boolean updateAtleta(Atleta atleta, PlanoSemanal planoSemanal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update atleta "
				+ "set atletanome = ?"
				+ ", atletacpf  = ?"
				+ ", atletaemail  = ?"
				+ ", atletasenha  = ?"
				+ ", atletaplanosemanal  = ?"
				+ "where atletaid = ?;";
		
        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

        	pstmt.setString(1, atleta.getNome());
            pstmt.setString(2, atleta.getCpf());
            pstmt.setString(3, atleta.getLogin());
            pstmt.setString(4, atleta.getSenha());
            pstmt.setLong(5, planoSemanal.getId());
            pstmt.setLong(6, atleta.getId());

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
