package mx.edu.ulsaoaxaca.sexto.proyecto1.model;

public class PreguntaYRespuestas {
	private String pregunta;
	private String [] respuestas;
	
	
	public PreguntaYRespuestas() {
		super();
	}
	public PreguntaYRespuestas(String pregunta, String[] respuestas) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String[] getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}
	
	
}
