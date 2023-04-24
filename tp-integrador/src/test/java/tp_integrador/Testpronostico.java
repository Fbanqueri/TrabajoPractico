package tp_integrador;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class Testpronostico {
	private Equipo equipo1;
	private Equipo equipo2;
	
	@BeforeEach
	public void setup() {
		this.equipo1=new Equipo("argentina");
		this.equipo2=new Equipo("bolivia");
	}
	@Test
	public void acertado() {
		Partido partido=new Partido(equipo1,equipo2,"2");
		partido.setGolEquipo1(3);
		partido.setGolEquipo2(0);
		Pronostico pronos=new Pronostico(partido,equipo1,ResultEnum.GANADOR);
		int puntos=pronos.puntos(1);
		Assertions.assertEquals(1,puntos,"acertado");
	}
	@Test
	public void equivocado() {
		Partido partido=new Partido(equipo1,equipo2,"2");
		partido.setGolEquipo1(3);
		partido.setGolEquipo2(5);
		Pronostico pronos=new Pronostico(partido,equipo1,ResultEnum.GANADOR);
		int puntos=pronos.puntos(1);
		Assertions.assertEquals(0,puntos,"acertado");
	}
	@Test
	public void test() {
		boolean a=true;
		int puntos=0;
		int[] puntoronda=new int[3];
		Ronda ronda=new Ronda(null);
		Partido partido;
		Path pathresultados=Paths.get("C:\\Users\\fegil\\OneDrive\\Desktop\\configuracion.txt");
		Path pathResultados = Paths.get("C:\\Users\\fegil\\OneDrive\\Desktop\\curso java ejercicios\\tp-integrador\\target\\test-classes\\prueba.txt");
		List<String> configuracion=null;
		List<String> lineasResultados = null;
		try {
			configuracion=Files.readAllLines(pathresultados);
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String configu:configuracion) {
			if(a) {
				a=false;
			}else {
			String[] conf=configu.split(",");
		for(String linea:lineasResultados) {
			String[] resultados=linea.split(",");
			partido=maintp.cargarpartido(resultados, linea);
			ronda.agregarPartido(partido);
			partido.setRonda(ronda);
		}
			Connection con=maintp.conexion(conf);
			try {
					Statement stmt=con.createStatement();
					puntoronda=maintp.puntosporronda(stmt,ronda,conf,1,"1");
					puntos+=puntoronda[0];
				}catch(Exception e) {System.out.println(e);}
			}
		}		
		Assertions.assertEquals(4, puntos);
	}	
}