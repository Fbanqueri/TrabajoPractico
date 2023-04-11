package tpgrupo2;

import java.util.ArrayList;

public class Participante {
	private String persona;
	private int puntos;
	private ArrayList<Participante> puntopart;

	public Participante(String persona,int punto) {
		this.persona=persona;
		this.puntos=punto;
		this.puntopart=new ArrayList<Participante>();
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(Participante persona) {
		this.puntopart.add(persona);
	}
	public int getPunto() {
		return puntos;
	}
}
