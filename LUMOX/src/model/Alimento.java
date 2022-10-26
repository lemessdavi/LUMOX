package model;

public class Alimento {
	private int id;
	private String nome;
	private int calorias;
	private String propriedades;
	
	public Alimento(String nome, int calorias, String propriedades) {
		super();
		this.nome = nome;
		this.calorias = calorias;
		this.propriedades = propriedades;
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
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public String getPropriedades() {
		return propriedades;
	}
	public void setPropriedades(String propriedades) {
		this.propriedades = propriedades;
	}
	
	
}
