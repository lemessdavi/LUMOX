package model;

import java.util.ArrayList;

public class PlanoAlimentar {
	private long id;
	private String nome;
	private ArrayList<Alimento> alimentos;
	private Personal personal;
	
	public PlanoAlimentar(String nome, ArrayList<Alimento> alimentos, Personal personal) {
		super();
		this.nome = nome;
		this.alimentos = alimentos;
		this.personal = personal;
	}
	
	public PlanoAlimentar(long id, String nome, ArrayList<Alimento> alimentos, Personal personal) {
		super();
		this.id = id;
		this.nome = nome;
		this.alimentos = alimentos;
		this.personal = personal;
	}
	
	public Personal getPersonal() {
		return personal;
	}
	
	public void setPersonal(Personal personal) {
		this.personal = personal;
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

	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
	public void addAlimento(Alimento alimento) {
		alimentos.add(alimento);
	}

	
	
	
	
}
