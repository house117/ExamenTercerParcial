package mx.edu.ulsaoaxaca.sexto.proyecto1.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Categoria;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Materias;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Usuarios;

@Mapper
public interface CategoriaMapper {
	@Select("select id, nombre from categoria")
	public List<Categoria> findAll();
	@Insert("INSERT INTO categoria(nombre) values(#{nombre})")
	public void create(@Param("nombre") String nombre);
	@Delete("delete from categoria where id = #{id}")
	public void delete(@Param("id") int id);
	@Update("UPDATE usuarios SET  nombre=#{nombre} where id=#{id}")
	public void update(@Param("nombre") String nombre, @Param("id") int id);
/*jdbc:h2:~/test*/
	/*jdbc:h2:tcp://localhost/~/test*/
}
