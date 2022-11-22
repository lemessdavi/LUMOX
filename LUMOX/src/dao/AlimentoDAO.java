package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Alimento;

public class AlimentoDAO {

	Connection connection;
	ConnectionFactory cFactory;
	
	public AlimentoDAO() throws SQLException {
		cFactory = new ConnectionFactory();
		connection = cFactory.recuperarConexao();
	}
	
	public long insertAlimento(Alimento alimento) throws SQLException {
		
		
		String  SQL = "insert into alimento (alimentonome, alimentocalorias, alimentopropriedades)"
				+ "values  (?, ?, ? )";
		
        long id = 0;

        try (
                PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

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
	
	public ArrayList<Alimento> selectAlimentos(){
		
		ArrayList<Alimento> alimentos = new ArrayList();
		
		try { 
			 
			
			 String sql = "SELECT * FROM alimento";
			 PreparedStatement ps = connection.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
			 
			 Alimento alimento = new Alimento(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			 alimentos.add(alimento);
		
			}
			 
			} catch (Exception e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
			}
		return alimentos;
	}
	
}
