package mx.edu.ulsaoaxaca.sexto.proyecto1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.sexto.proyecto1.mappers.CategoriaMapper;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Categoria;

@RestController
public class CategoriaController {
	@Autowired
	private CategoriaMapper productoMapper;
	


	@GetMapping("/categoria/read")
	public List<Categoria> read() {
		return productoMapper.findAll();
	}

	@PostMapping("/categoria/create")
	public List<Categoria> create(@RequestParam String nombre) {
		productoMapper.create(nombre);
		return productoMapper.findAll();
	}
	@RequestMapping(value = "/categoria/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteEmployee(@PathVariable int id) {
		System.out.println("asdasdasdASDASD");
		productoMapper.delete(id);
	}
	@RequestMapping(value = "/categoria/update/")
	public void update(@RequestParam String nombre, @RequestParam int id) {
		productoMapper.update(nombre, id);
	}
	/**
	 * TODO pasar datos a traves de la URL para el update
	 * iniciar proyecto para david
	 */
}
