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

import mx.edu.ulsaoaxaca.sexto.proyecto1.mappers.ProductoMapper;
import mx.edu.ulsaoaxaca.sexto.proyecto1.mappers.UsuarioMapper;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Categoria;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Producto;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Usuarios;

@RestController
public class ProductoController {
	@Autowired
	private ProductoMapper productoMapper;
	


	@GetMapping("/producto/read")
	public List<Producto> read() {
		return productoMapper.findAll();
	}

	@PostMapping("/producto/create")
	public List<Producto> create(@RequestParam String nombre, @RequestParam String categoria) {
		int idcategoria = productoMapper.getIdCategoria(categoria).get(0).getId();
		productoMapper.create(nombre, idcategoria);
		return productoMapper.findAll();
	}
	@RequestMapping(value = "/producto/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteEmployee(@PathVariable int id) {
		System.out.println("asdasdasdASDASD");
		productoMapper.delete(id);
	}
	@RequestMapping(value = "/colaborador/update/")
	public void update(@RequestParam String nombre, @RequestParam int id) {
		productoMapper.update(nombre, id);
	}
	/**
	 * TODO pasar datos a traves de la URL para el update
	 * iniciar proyecto para david
	 */
}
