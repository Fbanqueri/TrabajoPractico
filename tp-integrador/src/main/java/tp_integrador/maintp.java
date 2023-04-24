package tp_integrador;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

public class maintp {

	public static void main(String[] args) {	
		String[] conf=configuracion(args[1]);
		Ronda ronda =new Ronda(null);		
		Path pathResultados = Paths.get(args[0]);
		List<String> lineasResultados = null;
		ArrayList<Participante> partpunto=new ArrayList<Participante>();
		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cantpart=cantidadpart(conf);
		for(int i=1;i<=cantpart;i++) {
			boolean salto=true;
			boolean aux=true;
			String nronda=null, nfase=null;
			int puntos=0,tpunextra=0,totalpunto=0,cantparfase=0,aciertos=0,sumpun=0,tacierto=0;
			for(String lineaResultado:lineasResultados) {				
				if (salto) {
					salto = false;
				} else {

					String[] campos = lineaResultado.split(",");
					Partido partido=cargarpartido(campos,lineaResultado);
					
					if(aux) {
						nronda=campos[1];
						nfase=campos[0];
						ronda.setNro(campos[1]);
						aux=false;
					}
					if(nronda.equals(campos[1])){
						aciertos=0;
						ronda.agregarPartido(partido);
						partido.setRonda(ronda);
					}else {
						Connection con=conexion(conf);
						try {
							Statement stmt=con.createStatement();
							int[] puntoronda=puntosporronda(stmt,ronda,conf,i,nfase);
							puntos+=puntoronda[0];
							aciertos+=puntoronda[1];
							cantparfase+=puntoronda[2];						
							if(aciertos==ronda.getPartidos().size()) {
								tpunextra+=Integer.parseInt(conf[6]);
								tacierto+=ronda.getPartidos().size();
							}
							if(tacierto==cantparfase) {
								tpunextra+=Integer.parseInt(conf[7]);
								
							}
							ronda.getPartidos().clear();
							ronda.setNro(campos[1]);
							ronda.agregarPartido(partido);
							con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
						
					}
				}
			
			}
			totalpunto=tpunextra+puntos;
			Connection con=conexion(conf);
			try {
				Statement stmt=con.createStatement();
				String nombre=null;
				ResultSet rs=stmt.executeQuery("SELECT * FROM participante WHERE idpart="+i);
				while(rs.next()) {
					nombre=rs.getString(2);
				}
				partpunto.add(new Participante(nombre,totalpunto));
				con.close();
			}catch(Exception e) {System.out.println(e);}
		}
		for(Participante part:partpunto) {
			System.out.println(part.getPersona()+" "+part.getPunto());
		}
	}
	public static int cantidadpart(String[] conf) {
		int i=0;
		try {
			Connection 
			con=conexion(conf);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from participante");
				while(rs.next()) {
					i=1+i;
				}
			con.close();
		}catch(Exception e) {System.out.println(e);}
		return i;
	}
	public static Connection conexion(String[] conf) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con=DriverManager.getConnection("jdbc:mysql://localhost:"+conf[0]+"/pronosticos",conf[1],conf[2]);
		}catch(Exception e) {System.out.println(e);}
		return con;
	}
	public static String[] configuracion(String args) {
		String[] conf = null;
		boolean salto=true;
		Path pathResultados = Paths.get(args);
		List<String>linconfigu=null;
		try {
			linconfigu = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String lineaResultado:linconfigu) {
			if (salto) {
				salto = false;
			} else {

				conf = lineaResultado.split(",");
			}
		}
		return conf;
	}
	public static int[] puntosporronda(Statement stmt, Ronda ronda, String[] conf, int i,String nfase) {
		int[] puntoporronda=new int[] {0,0,0};
		int sumpun=0;
		try {
		for(Partido ronpar:ronda.getPartidos()) { 
			ResultSet rs=stmt.executeQuery("SELECT * FROM pronostico WHERE idpart="+i);
			while(rs.next()) {
				if(ronpar.getEquipo1().getNombre().equals(rs.getString(1)) && rs.getString(5).equals(ronpar.getEquipo2().getNombre())){
					Equipo equipo = ronpar.getEquipo1();
					ResultEnum resultado = null;
					if ("X".equals(rs.getString(2))) {
						resultado = ResultEnum.GANADOR;
						sumpun=Integer.parseInt(conf[3]);

					}
					if ("X".equals(rs.getString(3))) {
						resultado = ResultEnum.EMPATE;
						sumpun=Integer.parseInt(conf[4]);

					}
					if ("X".equals(rs.getString(4))) {
						resultado = ResultEnum.PERDEDOR;
						sumpun=Integer.parseInt(conf[5]);

					}
					Pronostico pronostico = new Pronostico(ronpar, equipo, resultado);
					int pnutosa=pronostico.puntos(sumpun);
					if(pnutosa!=0) {
						puntoporronda[1]++;
						puntoporronda[0]+=pnutosa;
					}																																							
				}								
			}
			if(nfase.equals(ronpar.getFase())) {
						puntoporronda[2]++;										
					}																	
		}
		}catch(Exception e) {System.out.println(e);}
		return puntoporronda;
	}
	public static Partido cargarpartido(String[] resultado,String lineaResultado) {
			Equipo equipo1 = new Equipo(resultado[2]);
			Equipo equipo2 = new Equipo(resultado[5]);
			Partido partido = new Partido(equipo1, equipo2,resultado[0]);
			try {
				partido.setGolEquipo1(Integer.parseInt(resultado[3]));
				partido.setGolEquipo2(Integer.parseInt(resultado[4]));
			} catch (NumberFormatException e) {
				System.out
				.println("Error: cantidad de goles no es un número entero en la línea " + lineaResultado);
				System.exit(1);
			}
			return partido;
					
	}

}
