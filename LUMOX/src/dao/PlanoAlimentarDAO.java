package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Alimento;
import model.Exercicio;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoTreino;

public class PlanoAlimentarDAO {

	public long insertPlanoAlimentar(PlanoAlimentar plano, Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into planoalimentar (planoalimentarnome, planoalimentarpersonal) "
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
	
	public long insertPlanoAlimentarXAlimento(PlanoAlimentar plano, Alimento alimento) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into planoalimentarxalimento (planoalimentarid, alimentoid, planoalimentarxalimentotipo) "
				+ "values  (?,?,1)" ;
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, plano.getId());
            pstmt.setLong(2, alimento.getId());
           

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
	
	
	public boolean updatePlanoAlimentar(PlanoAlimentar plano, Personal personal) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update planoalimentar "
				+ "set planoalimentarnome = ?"
				+ ",planoalimentarpersonal = ? "
				+ " where planoalimentarid = ?;" ;
		

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

	public PlanoAlimentar selectPlanoAlimentar(long long1) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from planoalimentarxalimento inner join planoalimentar on planoalimentarxalimento.planoalimentarid = planoalimentar.planoalimentarid where planoalimentar.planoalimentarid = ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setLong(1, long1);
        
		ResultSet rs = pstmt.executeQuery();
		
		long id =0;
		String nome = null;
		Personal personal = null;		
		while(rs.next()) {
		id = rs.getLong("planoalimentarid");
		nome = rs.getString("planoalimentarnome");
		
		PersonalDAO personalDAO = new PersonalDAO();
		personal = personalDAO.selectPersonal(rs.getLong("planoalimentarpersonal"));
		}
		
		ArrayList<Alimento> alimentos = new ArrayList();
		
		List<Long> alimentosids = new ArrayList<>();
		
		
		String sql = "select planoalimentarxalimento.alimentoid from planoalimentarxalimento inner join planoalimentar on planoalimentarxalimento.planoalimentarid = planoalimentar.planoalimentarid where planoalimentar.planoalimentarid = ?;";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, long1);
		
		ResultSet rs2 = stmt.executeQuery(); 
		
		while (rs2.next()) {
			alimentosids.add(rs2.getLong("alimentoid"));
		}
		
		for (Long long2 : alimentosids) {
			AlimentoDAO alimentoDAO = new AlimentoDAO();
			Alimento alimento = alimentoDAO.selectAlimento(long2);
			alimentos.add(alimento);
		}
		    
		PlanoAlimentar plano = new PlanoAlimentar(id, nome, alimentos, personal);
		
		return plano;
	}
	
	public ResultSet selectAllPlanosAlimentares() throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from planoalimentar;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs;
		
	}
	
	public ResultSet selectAllPlanosAlimentaresPersonal() throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select  planoalimentar.planoalimentarnome, alimento.alimentonome, alimento.alimentocalorias, alimento.alimentopropriedades from planosemanal "
				+ "	inner join atleta on atleta.atletaplanosemanal = planosemanal.planosemanalid "
				+ "	inner join diadasemana on planosemanal.segunda = diadasemana.diadasemanaid "
				+ "	inner join planoalimentar on planoalimentar.planoalimentarid = diadasemana.diadasemanaplanalim "
				+ "	inner join planoalimentarxalimento on planoalimentar.planoalimentarid = planoalimentarxalimento.planoalimentarid "
				+ "	inner join alimento on planoalimentarxalimento.alimentoid = alimento.alimentoid; ";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs;
	}

	public ResultSetMetaData selectAllPlanosPersonalModel() throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select  planoalimentar.planoalimentarnome, alimento.alimentonome, alimento.alimentocalorias, alimento.alimentopropriedades from planosemanal "
				+ "	inner join atleta on atleta.atletaplanosemanal = planosemanal.planosemanalid "
				+ "	inner join diadasemana on planosemanal.segunda = diadasemana.diadasemanaid "
				+ "	inner join planoalimentar on planoalimentar.planoalimentarid = diadasemana.diadasemanaplanalim "
				+ "	inner join planoalimentarxalimento on planoalimentar.planoalimentarid = planoalimentarxalimento.planoalimentarid "
				+ "	inner join alimento on planoalimentarxalimento.alimentoid = alimento.alimentoid; ";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs.getMetaData();
	}
	
}
