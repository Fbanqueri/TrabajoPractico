package tpgrupo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Collection<Partido> partidos = new ArrayList<Partido>();
		Path pathResultados = Paths.get(args[0]);
		List<String> lineasResultados = null;
		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean salto = true;
		List<Ronda> rondas = new ArrayList<Ronda>();
		for (String lineaResulatado : lineasResultados) {
			if (salto) {
				salto = false;
			} else {

				String[] campos = lineaResulatado.split(",");
				Equipo equipo1 = new Equipo(campos[1]);
				Equipo equipo2 = new Equipo(campos[4]);
				Partido partido = new Partido(equipo1, equipo2);
				try {
					partido.setGolEquipo1(Integer.parseInt(campos[2]));
					partido.setGolEquipo2(Integer.parseInt(campos[3]));
				} catch (NumberFormatException e) {
					System.out
							.println("Error: cantidad de goles no es un número entero en la línea " + lineaResulatado);
					System.exit(1);
				}
				String nroRonda = campos[0];
				for (Ronda ronda : rondas) {
					if (ronda.getNro().equals(nroRonda)) {
						ronda.agregarPartido(partido);
						partido.setRonda(ronda);

					}

				}
				if (partido.getRonda() == null) {
					Ronda rondanueva = new Ronda(nroRonda);
					rondanueva.agregarPartido(partido);
					rondas.add(rondanueva);
					partido.setRonda(rondanueva);
				}
				partidos.add(partido);
			}

		}
		int puntos = 0;
		boolean i=true;
		Path pathPronosticos = Paths.get(args[1]);
		ArrayList<Participante> partpuntos=new ArrayList<Participante>();
		List<String> lineasPronosticos = null;
		try {
			lineasPronosticos = Files.readAllLines(pathPronosticos);
		} catch (IOException e) {

			e.printStackTrace();
		}
		salto = true;
		String aux=null;
		for (String lineaPronostico : lineasPronosticos) {
			
			if (salto) {
				salto = false;
			} else {
				String[] campos = lineaPronostico.split(",");
				Equipo equipo1 = new Equipo(campos[1]);
				Equipo equipo2 = new Equipo(campos[5]);
				Partido partido= new Partido(null,null);
				if(i) {
					aux=campos[0];
					i=false;
				}
				for (Partido partidoCol : partidos) {
					if (partidoCol.getEquipo1().equivaleA(equipo1) && partidoCol.getEquipo2().equivaleA(equipo2)) {
						partido = partidoCol;

					}

				}

				Equipo equipo = equipo1;
				ResultEnum resultado = null;
				if ("X".equals(campos[2])) {
					resultado = ResultEnum.GANADOR;

				}
				if ("X".equals(campos[3])) {
					resultado = ResultEnum.EMPATE;

				}
				if ("X".equals(campos[4])) {
					resultado = ResultEnum.PERDEDOR;

				}
				Pronostico pronostico = new Pronostico(partido, equipo, resultado);
				
				if(!aux.equals(campos[0])) {
					partpuntos.add(new Participante(aux,puntos));
					aux=campos[0];
					puntos=0;

				}
				puntos += pronostico.puntos();

			}

		}
		partpuntos.add(new Participante(aux,puntos));
		for(Participante totalpart:partpuntos) {
			System.out.println(totalpart.getPersona()+" "+totalpart.getPunto());
		}


	}
}
