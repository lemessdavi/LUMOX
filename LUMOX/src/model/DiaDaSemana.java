package model;

public class DiaDaSemana {
	private int id;
	private int dia;
	private PlanoAlimentar planoAlimentar;
	private PlanoTreino planoTreino;
	
	public DiaDaSemana(int dia, PlanoAlimentar planoAlimentar, PlanoTreino planoTreino) {
		super();
		this.dia = dia;
		this.planoAlimentar = planoAlimentar;
		this.planoTreino = planoTreino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public PlanoAlimentar getPlanoAlimentar() {
		return planoAlimentar;
	}

	public void setPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		this.planoAlimentar = planoAlimentar;
	}

	public PlanoTreino getPlanoTreino() {
		return planoTreino;
	}

	public void setPlanoTreino(PlanoTreino planoTreino) {
		this.planoTreino = planoTreino;
	}
	
	
}
