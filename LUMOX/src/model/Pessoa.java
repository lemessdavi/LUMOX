package model;

public abstract class Pessoa {
	protected int id;
	protected String nome;
	protected String cpf;
	protected String login;
	protected String senha;
	
	public Pessoa(String nome, String cpf, String login, String senha) {
		super();
		
		// fazer a insercao no banco antes com os valores recebidos
		
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		
		// pegar o id da criacao e retornar pra ca, e entao adicionalo no java
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
