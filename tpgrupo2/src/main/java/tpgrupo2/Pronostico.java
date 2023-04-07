package tpgrupo2;

public class Pronostico {
	private Participante persona;
	private Partido partido;
	private Equipo equipo;
	private ResultEnum resultado;

	public Pronostico(Partido partido, Equipo equipo, ResultEnum resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public Participante getPersona() {
		return persona;
	}

	public void setPersona(Participante persona) {
		this.persona = persona;
	}

	public Partido getPartido() {
		return partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public ResultEnum getResultado() {
		return resultado;
	}

	public int puntos() {
		if (resultado.equals(partido.resultado(equipo))) {
			return 1;
		} else
			return 0;
	}
}
