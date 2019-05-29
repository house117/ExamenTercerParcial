package mx.edu.ulsaoaxaca.sexto.proyecto1.model;    	


public class Materias {
	private int id;
	private String nombre;
	
	public Materias() {
		super();
	}
	public Materias(int id, String nombre, String semestre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
