package mx.edu.ulsaoaxaca.sexto.proyecto1.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.sexto.proyecto1.mappers.UsuarioMapper;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Usuarios;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioMapper usuarioMapper;
	


	@GetMapping("/usuario/findAll.json")
	public List<Usuarios> findAll() {
		return usuarioMapper.findAll();
	}

	@PostMapping("/usuario/create")
	public void create(@RequestParam String username, @RequestParam String password, @RequestParam Date birthdate,
			@RequestParam String rol) {
		usuarioMapper.create(username, password, birthdate, rol);
	}
	@RequestMapping(value = "/usuario/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteEmployee(@PathVariable int id) {
		System.out.println("asdasdasdASDASD");
		usuarioMapper.delete(id);
	}
	@RequestMapping(value = "/usuario/update/")
	public void update(@RequestParam String username, @RequestParam String password, @RequestParam Date birthdate, 
			@RequestParam String rol){
		
	}
	/**
	 * TODO pasar datos a traves de la URL para el update
	 * iniciar proyecto para david
	 */
}
