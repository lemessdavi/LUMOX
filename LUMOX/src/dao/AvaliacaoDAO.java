package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Atleta;
import model.Avaliacao;

public class AvaliacaoDAO {

	public long insertAvaliacao(Avaliacao avaliacao, Atleta atelta) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into avaliacao (avaliacaodescricao, avaliacaoatleta)"
				+ "values  (?, ?)";
		
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, avaliacao.getAvaliacao());
            pstmt.setLong(2, atelta.getId());

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
	
	public boolean updateAvaliacao(Avaliacao avaliacao, Atleta atelta) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update avaliacao "
				+ "		set avaliacaodescricao = ?"
				+ "		, avaliacaoatleta  = ?"
				+ "		where avaliacaoid = ?;";;
		

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, avaliacao.getAvaliacao());
            pstmt.setLong(2, atelta.getId());
            pstmt.setLong(3, avaliacao.getId());

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
