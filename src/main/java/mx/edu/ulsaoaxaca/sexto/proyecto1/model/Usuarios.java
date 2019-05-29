package mx.edu.ulsaoaxaca.sexto.proyecto1.model;

import java.sql.Date;
import java.util.List;


public class Usuarios {
	private int user_id;
	private String user_name;
	private String user_password;
	private Date user_birthdate;
	private String user_role;
	
	public Usuarios(int user_id, String user_name, String user_password, Date user_birthdate, String rol) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_birthdate = user_birthdate;
		this.user_role = rol;
	}
	public Usuarios(String user_name, String user_password, Date user_birthdate, String rol) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_birthdate = user_birthdate;
		this.user_role = rol;
	}
	public Usuarios() {
		super();
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Date getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(Date user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getRol() {
		return user_role;
	}
	public void setRol(String rol) {
		this.user_role = rol;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
}
