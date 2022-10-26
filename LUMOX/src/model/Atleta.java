package model;

public class Atleta extends Pessoa {
	
	private PlanoSemanal plano;
	private Avaliacao avaliacao;
	
	public Atleta(String nome, String cpf, String login, String senha) {
		super(nome, cpf, login, senha);
		// TODO Auto-generated constructor stub
	}

	public PlanoSemanal getPlano() {
		return plano;
	}


	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	private void atribuirPlano(PlanoSemanal plano) { //mudar para boolean
		this.plano = plano;
	}
	
	// FALTA AS SOLICITACOES DE ALTERACAO

}
