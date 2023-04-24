package tp_integrador;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private String nro;
	private List<Partido> partidos;
	
	
	public Ronda(String nro) {
		super();
		this.nro = nro;
		this.partidos = new ArrayList <Partido>();
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public List<Partido> getPartidos() {
		return partidos;
	}
	
	public boolean equivaleA(Ronda ronda) {
		return this.nro.equals(ronda.getNro());
	}
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
		
	}
}
