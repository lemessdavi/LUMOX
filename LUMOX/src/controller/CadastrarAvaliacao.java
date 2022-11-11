package controller;

import dao.AvaliacaoDAO;
import model.Atleta;
import model.Avaliacao;

public class CadastrarAvaliacao {
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
}
