package model;

public class Avaliacao {
	
	private int id;
	private Atleta atleta;
	private String avaliacao;
	
	public Avaliacao(Atleta atleta, String avaliacao) {
		super();
		this.atleta = atleta;
		this.avaliacao = avaliacao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

}
