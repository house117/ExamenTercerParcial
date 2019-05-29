package mx.edu.ulsaoaxaca.sexto.proyecto1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Categoria;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Producto;

@Mapper
public interface ProductoMapper {
	@Select("select id, nombre, categoria_id from producto")
	public List<Producto> findAll();
	@Select("select id from categoria where nombre=#{nombre}")
	public List<Categoria> getIdCategoria(@Param("nombre") String categoria);
	@Insert("INSERT INTO producto(nombre, categoria_id) values(#{nombre}, #{categoria_id})")
	public void create(@Param("nombre") String nombre, @Param("categoria_id") int categoria_id);
	@Delete("delete from producto where id = #{id}")
	public void delete(@Param("id") int id);
	@Update("UPDATE producto SET  nombre=#{nombre} where id=#{id}")
	public void update(@Param("nombre") String nombre, @Param("id") int id);
/*jdbc:h2:~/test*/
	/*jdbc:h2:tcp://localhost/~/test*/
}
