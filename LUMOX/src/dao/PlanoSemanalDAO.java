package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            pstmt.setLong(2, plano.getDiaSemana(0).getId());
            pstmt.setLong(3, plano.getDiaSemana(1).getId());
            pstmt.setLong(4, plano.getDiaSemana(2).getId());
            pstmt.setLong(5, plano.getDiaSemana(3).getId());
            pstmt.setLong(6, plano.getDiaSemana(4).getId());
            pstmt.setLong(7, plano.getDiaSemana(5).getId());
            pstmt.setLong(8, plano.getDiaSemana(6).getId());
           

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
            pstmt.setLong(2, plano.getDiaSemana(0).getId());
            pstmt.setLong(3, plano.getDiaSemana(1).getId());
            pstmt.setLong(4, plano.getDiaSemana(2).getId());
            pstmt.setLong(5, plano.getDiaSemana(3).getId());
            pstmt.setLong(6, plano.getDiaSemana(4).getId());
            pstmt.setLong(7, plano.getDiaSemana(5).getId());
            pstmt.setLong(8, plano.getDiaSemana(6).getId());
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
	
}
