package model;

import java.util.ArrayList;

public class PlanoAlimentar {
	private long id;
	private String nome;
	private ArrayList<Alimento> manha;
	private ArrayList<Alimento> tarde;
	private ArrayList<Alimento> noite;
	
	public PlanoAlimentar(String nome, ArrayList<Alimento> manha, ArrayList<Alimento> tarde,
			ArrayList<Alimento> noite) {
		super();
		this.nome = nome;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
	}
	
	public PlanoAlimentar(long id, String nome, ArrayList<Alimento> manha, ArrayList<Alimento> tarde, ArrayList<Alimento> noite) {
		super();
		this.id = id;
		this.nome = nome;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
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

	public ArrayList<Alimento> getManha() {
		return manha;
	}

	public void setManha(ArrayList<Alimento> manha) {
		this.manha = manha;
	}

	public ArrayList<Alimento> getTarde() {
		return tarde;
	}

	public void setTarde(ArrayList<Alimento> tarde) {
		this.tarde = tarde;
	}

	public ArrayList<Alimento> getNoite() {
		return noite;
	}

	public void setNoite(ArrayList<Alimento> noite) {
		this.noite = noite;
	}

	
	
	
	
}
