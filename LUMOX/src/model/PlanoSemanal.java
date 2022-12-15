package model;

import java.util.ArrayList;

public class PlanoSemanal {
	private long id;
	private String nome;
	private DiaDaSemana segunda;
	private DiaDaSemana terca;
	private DiaDaSemana quarta;
	private DiaDaSemana quinta;
	private DiaDaSemana sexta;
	private DiaDaSemana sabado;
	private DiaDaSemana domingo;
	
	
	public PlanoSemanal(String nome) {
		super();
		this.nome = nome;
	}
	
	public PlanoSemanal(long id, String nome ) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public DiaDaSemana getSegunda() {
		return segunda;
	}

	public void setSegunda(DiaDaSemana segunda) {
		this.segunda = segunda;
	}

	public DiaDaSemana getTerca() {
		return terca;
	}

	public void setTerca(DiaDaSemana terca) {
		this.terca = terca;
	}

	public DiaDaSemana getQuarta() {
		return quarta;
	}

	public void setQuarta(DiaDaSemana quarta) {
		this.quarta = quarta;
	}

	public DiaDaSemana getQuinta() {
		return quinta;
	}

	public void setQuinta(DiaDaSemana quinta) {
		this.quinta = quinta;
	}

	public DiaDaSemana getSexta() {
		return sexta;
	}

	public void setSexta(DiaDaSemana sexta) {
		this.sexta = sexta;
	}

	public DiaDaSemana getSabado() {
		return sabado;
	}

	public void setSabado(DiaDaSemana sabado) {
		this.sabado = sabado;
	}

	public DiaDaSemana getDomingo() {
		return domingo;
	}

	public void setDomingo(DiaDaSemana domingo) {
		this.domingo = domingo;
	}

	public PlanoSemanal(long id, String nome, DiaDaSemana segunda, DiaDaSemana terca, DiaDaSemana quarta,
			DiaDaSemana quinta, DiaDaSemana sexta, DiaDaSemana sabado, DiaDaSemana domingo) {
		super();
		this.id = id;
		this.nome = nome;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.domingo = domingo;
	}

	public PlanoSemanal( String nome, DiaDaSemana segunda, DiaDaSemana terca, DiaDaSemana quarta,
			DiaDaSemana quinta, DiaDaSemana sexta, DiaDaSemana sabado, DiaDaSemana domingo) {
		super();
		this.nome = nome;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.domingo = domingo;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
