package controller;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.*;
import javax.swing.*;
import dao.AlimentoDAO;
import model.Alimento;

public class AlimentoCRUD {
	private Alimento modelAlimento;
	private AlimentoDAO daoAlimento;
	
	
	public AlimentoCRUD(Alimento modelAlimento) {
		daoAlimento = new AlimentoDAO();
		this.modelAlimento = modelAlimento;
	}
	
	public AlimentoCRUD() {
		daoAlimento = new AlimentoDAO();
	}
	
	
	public boolean cadastrarAlimento(String nome, int calorias, String propriedades) throws SQLException {
		modelAlimento = new Alimento(nome,calorias,propriedades);
		try {
			modelAlimento.setId(daoAlimento.insertAlimento(modelAlimento));
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateAlimento(long id, String nome, int calorias, String propriedades) {
		Alimento alimento = new Alimento (id, nome, calorias, propriedades);
		try {
			daoAlimento.updateAlimento(alimento);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Alimento getAlimento() {
		return modelAlimento;
	}
	
	
	public String[] selectJTable() {
		
		try {
			ResultSetMetaData rsmd = daoAlimento.selectAlimento();
			int cols = rsmd.getColumnCount();
			String[] colName =  new String[cols];
			
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			
			return colName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Alimento> selectAllAlimentosToArray(){
		try {
			return daoAlimento.allAlimentosToArray();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
