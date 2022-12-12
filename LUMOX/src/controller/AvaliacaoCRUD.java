package controller;

import dao.AvaliacaoDAO;
import model.Atleta;
import model.Avaliacao;

public class AvaliacaoCRUD {
	private Avaliacao avaliacaoModel;
	private AvaliacaoDAO avaliacaoDAO;
	
	public boolean cadastrarAvaliacao(Atleta atleta, String texto) {
		avaliacaoModel = new Avaliacao(atleta, texto);
		avaliacaoDAO = new AvaliacaoDAO();
		try {
			avaliacaoModel.setId(avaliacaoDAO.insertAvaliacao(avaliacaoModel, atleta));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateAvaliacao(Atleta atleta, String texto, long id) {
		avaliacaoModel = new Avaliacao(id, atleta, texto);
		avaliacaoDAO = new AvaliacaoDAO();
		try {
			avaliacaoDAO.updateAvaliacao(avaliacaoModel, atleta);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
