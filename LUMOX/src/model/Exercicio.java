package model;

public class Exercicio {
	
	private long id;
	private String nome;
	private String repeticoes;
	private String tempo;
	private String instrucoes;
	
	public Exercicio(String nome, String repeticoes, String tempo, String instrucoes) {
		super();
		this.nome = nome;
		this.repeticoes = repeticoes;
		this.tempo = tempo;
		this.instrucoes = instrucoes;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}


	
}
