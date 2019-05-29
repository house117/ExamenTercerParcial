package mx.edu.ulsaoaxaca.sexto.proyecto1.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.sexto.proyecto1.mappers.MateriaMapper;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Materias;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Pregunta;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.PreguntaYRespuestas;

@RestController
public class MateriaController {
	@Autowired
	private MateriaMapper materiaMapper;
	

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hola mundo desde Spring Boot!";
	}

	@GetMapping("/materia/findAll")
	public List<Materias> findAll() {
		return materiaMapper.findAll();
	}
	
	@GetMapping("/materia/generarExamen")
	public PreguntaYRespuestas[] generarExamen(@RequestParam String materia) {
		PreguntaYRespuestas[] listaPR = new PreguntaYRespuestas[5];
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int insertados = 0;
		while(insertados < 5) {
			Pregunta preguntita = materiaMapper.selectRandomRegister(materia);
			Integer id = preguntita.getId();
			System.out.println(preguntita.getPregunta());
			Boolean contiene = false;
			for (int i = 0; i < lista.size(); i++) {
				if(id == lista.get(i)) {
					contiene = true;
				}
			}
			if(lista.isEmpty()) {
				System.out.println("A entrar: "+preguntita.getPregunta());
				listaPR[insertados] = new PreguntaYRespuestas();
				listaPR[insertados].setPregunta(preguntita.getPregunta());
				String respuestas[] = preguntita.getRespuestas().split("·");
				listaPR[insertados].setRespuestas(respuestas);
				insertados++;
				lista.add(preguntita.getId());
			}else if(!contiene) {
				System.out.println("A entrar: "+preguntita.getPregunta());

				listaPR[insertados] = new PreguntaYRespuestas();
				listaPR[insertados].setPregunta(preguntita.getPregunta());
				String respuestas[] = preguntita.getRespuestas().split("·");
				listaPR[insertados].setRespuestas(respuestas);
				insertados++;
				lista.add(preguntita.getId());

			}
			
		}
		for(int i = 0; i<5; i++) {
			System.out.println(listaPR[i].getPregunta());
		}
		System.out.println("aaaa");
		return listaPR;
		
	}

	@PostMapping("/materia/create")
	public void createPregunta(@RequestParam String data) {
		String preguntas[] = data.split("\n");
		
		for(int i = 0; i< preguntas.length; i++) {
			String [] parametros = preguntas[i].split("¬");
			String pregunta = parametros[0];
			String respuestas = parametros[2];
			String materia = parametros[1];
			String correcta = parametros[3];
			materiaMapper.createPregunta(pregunta, respuestas, materia, correcta);
		}
		
	}
	@RequestMapping(value = "/materia/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteEmployee(@PathVariable int id) {
		System.out.println("asdasdasdASDASD");
		materiaMapper.delete(id);
	}
	@RequestMapping(value = "/materia/update/")
	public void update(@RequestParam String username, @RequestParam int id){
		
	}
	/**
	 * TODO pasar datos a traves de la URL para el update
	 * iniciar proyecto para david
	 */
}
