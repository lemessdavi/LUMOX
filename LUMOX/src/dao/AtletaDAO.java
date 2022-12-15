package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
            pstmt.setLong(5, planoSemanal.getId());

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
	
	
	public ResultSetMetaData selectAlimentosDoDia(Atleta atleta, String dia) throws SQLException {
		
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select  alimento.alimentonome, alimento.alimentocalorias, alimento.alimentopropriedades from planosemanal \r\n"
				+ "	inner join atleta on atleta.atletaplanosemanal = planosemanal.planosemanalid\r\n"
				+ "	inner join diadasemana on planosemanal.?= diadasemana.diadasemanaid\r\n"
				+ "	inner join planoalimentar on planoalimentar.planoalimentarid = diadasemana.diadasemanaplanalim\r\n"
				+ "	inner join planoalimentarxalimento on planoalimentar.planoalimentarid = planoalimentarxalimento.planoalimentarid\r\n"
				+ "	inner join alimento on planoalimentarxalimento.alimentoid = alimento.alimentoid \r\n"
				+ "	where atleta.atletaid = ? \r\n"
				+ "	group by diadasemana.diadasemanaid,alimento.alimentonome, alimento.alimentocalorias, alimento.alimentopropriedades  ;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setString(1, dia);
        pstmt.setLong(2, atleta.getId());
        
 		
		ResultSet rs = pstmt.executeQuery();
		
		return rs.getMetaData();
		
	}
	
	public Atleta createAtletaOnLogin(String login, String senha1) throws SQLException {
		

		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from atleta where atleta.atletaemail like ? and atleta.atletasenha like ?";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setString(1, login);
        pstmt.setString(2, senha1);
        
		ResultSet rs = pstmt.executeQuery();
		
		PlanoSemanal plano = null;
		
		while(rs.next()) {
			PlanoSemanalDAO dao = new PlanoSemanalDAO();
			plano = dao.selectPlanoSemanal(rs.getLong("atletaplanosemanal"));
		}
	
		
		
		
		System.out.println(plano);
		
		long id = 0 ;
		String nome = null ;
		String cpf = null ;
		String email = null ;
		String senha = null ;
		
		while(rs.next()) {
			id = rs.getLong("atletaid");
			nome = rs.getString("atletanome");
			cpf = rs.getString("atletacpf");
			email = rs.getString("atletaemail");
			senha = rs.getString("atletasenha");
		}
		
		
		Atleta atleta = new Atleta(id, nome, cpf, email, senha, plano);
		
		System.out.println(atleta);
		
		return atleta;
	}
}
