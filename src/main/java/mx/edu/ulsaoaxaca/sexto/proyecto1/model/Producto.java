package mx.edu.ulsaoaxaca.sexto.proyecto1.model;

public class Producto {
	private int id;
	private String nombre;
	private int categoria_id;
	
	
	public Producto() {
		super();
	}
	public Producto(int id, String nombre, int categoria_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria_id = categoria_id;
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
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
}
