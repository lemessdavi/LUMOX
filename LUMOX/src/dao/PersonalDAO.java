package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DiaDaSemana;
import model.Personal;
import model.PlanoSemanal;

public class PersonalDAO {
	
	public long insertPersonal(Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into personal (personalnome, personalcpf, personalemail, personalsenha)"
				+ "values  (?,?,?,?)";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, personal.getNome());
            pstmt.setString(2, personal.getCpf());
            pstmt.setString(3, personal.getLogin());
            pstmt.setString(4, personal.getSenha());

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
	
	public boolean updatePersonal(Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update personal "
				+ "set personalnome = ?"
				+ "set personalcpf = ?"
				+ "set personalemail = ?"
				+ "set personalsenha = ?"
				+ "where personalid = ?;";
		

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, personal.getNome());
            pstmt.setString(2, personal.getCpf());
            pstmt.setString(3, personal.getLogin());
            pstmt.setString(4, personal.getSenha());
            pstmt.setLong(5, personal.getId());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
               return true;
            }
        }
		return false;
	}

	public Personal selectPersonal(long long1) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from personal where personal.personalid = ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setLong(1, long1);
        
		ResultSet rs = pstmt.executeQuery();
		
		long id = 0 ;
		String nome = null ;
		String cpf = null ;
		String email = null ;
		String senha = null ;
		
		while (rs.next()) {
		id = rs.getLong("personalid");
		nome = rs.getString("personalnome");
		cpf = rs.getString("personalcpf");
		email = rs.getString("personalemail");
		senha = rs.getString("personalsenha");
		}
		
		Personal personal = new Personal (id, nome, cpf, email, senha);
		return personal;
	}

	public Personal createPersonalOnLogin(String login, String senha1) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from personal where personal.personalemail like ? and personal.personalsenha like ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setString(1, login);
		pstmt.setString(2, senha1);
        
		ResultSet rs = pstmt.executeQuery();
		
		
		long id = 0 ;
		String nome = null ;
		String cpf = null ;
		String email = null ;
		String senha = null ;
		
		while(rs.next()) {
			id = rs.getLong("personalid");
			nome = rs.getString("personalnome");
			cpf = rs.getString("personalcpf");
			email = rs.getString("personalemail");
			senha = rs.getString("personalsenha");
		}
		
		Personal personal = new Personal (id, nome, cpf, email, senha);
		
		return personal;
	}
}
