package tp_integrador;

public class Equipo {
		private String nombre;
		private String descripcion;
		public Equipo(String nombre) {
			super();
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getNombre() {
			return nombre;
		}
		public boolean equivaleA(Equipo equipo) {
			return this.getNombre().equals(equipo.getNombre());
		}
	
}
