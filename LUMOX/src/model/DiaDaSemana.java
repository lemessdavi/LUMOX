package model;

public class DiaDaSemana {
	private long id;
	private String dia;
	private PlanoAlimentar planoAlimentar;
	private PlanoTreino planoTreino;
	
	public DiaDaSemana(String dia, PlanoAlimentar planoAlimentar, PlanoTreino planoTreino) {
		super();
		this.dia = dia;
		this.planoAlimentar = planoAlimentar;
		this.planoTreino = planoTreino;
	}
	
	public DiaDaSemana(long id, String dia, PlanoAlimentar planoAlimentar, PlanoTreino planoTreino) {
		super();
		this.id = id;
		this.dia = dia;
		this.planoAlimentar = planoAlimentar;
		this.planoTreino = planoTreino;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
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
