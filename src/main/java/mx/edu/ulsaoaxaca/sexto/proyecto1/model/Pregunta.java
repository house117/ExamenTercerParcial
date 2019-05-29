package mx.edu.ulsaoaxaca.sexto.proyecto1.model;

public class Pregunta {
	private int id;
	private String pregunta;
	private String respuestas;
	private String materia;
	private String correcta;
	
	
	public Pregunta() {
		super();
	}
	public Pregunta(int id, String pregunta, String respuestas, String materia, String correcta) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.materia = materia;
		this.correcta = correcta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getCorrecta() {
		return correcta;
	}
	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}
}
