package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Atleta;
import model.DiaDaSemana;
import model.Personal;
import model.PlanoAlimentar;
import model.PlanoSemanal;
import model.PlanoTreino;

public class PlanoSemanalDAO {

	public long insertPlanoSemanal(PlanoSemanal plano) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into planoSemanal(nome,segunda,terca,quarta,quinta,sexta,sabado,domingo) values (?,?,?,?,?,?,?,? );" ;
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

        	 pstmt.setString(1, plano.getNome());
             pstmt.setLong(2, plano.getSegunda().getId());
             pstmt.setLong(3, plano.getTerca().getId());
             pstmt.setLong(4, plano.getQuarta().getId());
             pstmt.setLong(5, plano.getQuinta().getId());
             pstmt.setLong(6, plano.getSexta().getId());
             pstmt.setLong(7, plano.getSabado().getId());
             pstmt.setLong(8, plano.getDomingo().getId());
           

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
	
	public boolean updatePlanoSemanal(PlanoSemanal plano) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "update planoSemanal set (nome,segunda,terca,quarta,quinta,sexta,sabado,domingo) = (?,?,?,?,?,?,?,? ) where planosemanalid = ?;" ;
		

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setString(1, plano.getNome());
            pstmt.setLong(2, plano.getSegunda().getId());
            pstmt.setLong(3, plano.getTerca().getId());
            pstmt.setLong(4, plano.getQuarta().getId());
            pstmt.setLong(5, plano.getQuinta().getId());
            pstmt.setLong(6, plano.getSexta().getId());
            pstmt.setLong(7, plano.getSabado().getId());
            pstmt.setLong(8, plano.getDomingo().getId());
            pstmt.setLong(9, plano.getId());
           

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

	public PlanoSemanal selectPlanoSemanal(long long1) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String query = "select * from planosemanal where planosemanal.planosemanalid = ?;";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		pstmt.setLong(1, long1);
        
		ResultSet rs = pstmt.executeQuery();
		
		DiaDaSemanaDAO diaDao = new DiaDaSemanaDAO();
		
		DiaDaSemana segunda = diaDao.selectDiaDaSemana(rs.getLong(2));
		DiaDaSemana terca = diaDao.selectDiaDaSemana(rs.getLong(3));
		DiaDaSemana quarta = diaDao.selectDiaDaSemana(rs.getLong(4));
		DiaDaSemana quinta = diaDao.selectDiaDaSemana(rs.getLong(5));
		DiaDaSemana sexta = diaDao.selectDiaDaSemana(rs.getLong(6));
		DiaDaSemana sabado = diaDao.selectDiaDaSemana(rs.getLong(7));
		DiaDaSemana domingo = diaDao.selectDiaDaSemana(rs.getLong(8));
		
		PlanoSemanal plano = new PlanoSemanal(rs.getLong(0), rs.getString(1), segunda, terca, quarta, quinta, sexta, sabado, domingo);
		return plano;
	}
	
}
