package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Atleta;
import model.DiaDaSemana;
import model.PlanoAlimentar;
import model.PlanoSemanal;
import model.PlanoTreino;

public class DiaDaSemanaDAO {
	
	public long insertDiaDaSemana(DiaDaSemana dia, PlanoAlimentar planoAlimentar, PlanoTreino planoTreino) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		String  SQL = "insert into diadasemana (diadasemananome, diadasemanaplanalim, diadasemanaplanexer)"
				+ "values  (?, ?, ?) ";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

        	pstmt.setString(1, dia.getDia());
            pstmt.setLong(2, planoAlimentar.getId());
            pstmt.setLong(3, planoAlimentar.getId());
           
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
}
