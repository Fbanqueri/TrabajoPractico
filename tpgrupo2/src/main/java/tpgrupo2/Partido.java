package tpgrupo2;

public class Partido {
	private Ronda ronda;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golEquipo1;
	private int golEquipo2;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	public Ronda getRonda() {
		return ronda;
	}
	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGolEquipo1() {
		return golEquipo1;
	}
	public void setGolEquipo1(int golEquipo1) {
		this.golEquipo1 = golEquipo1;
	}
	public int getGolEquipo2() {
		return golEquipo2;
	}
	public void setGolEquipo2(int golEquipo2) {
		this.golEquipo2 = golEquipo2;
	}
	public ResultEnum resultado(Equipo equipo) {
		if(golEquipo1 == golEquipo2) {
			return ResultEnum.EMPATE;
		}
		if(equipo.getNombre().equals(equipo1.getNombre())) {
			if(golEquipo1>golEquipo2) {
				return ResultEnum.GANADOR;
				
			}else {
				return ResultEnum.PERDEDOR;
			}
			
		}
		return null;
	}
}
