package mx.edu.ulsaoaxaca.sexto.proyecto1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Materias;
import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Pregunta;

@Mapper
public interface MateriaMapper {
	@Select("select id, nombre from materias")
	public List<Materias> findAll();
	@Select("SELECT  * FROM preguntas WHERE materia = #{materia}  ORDER BY RAND() LIMIT 1;")
	public Pregunta selectRandomRegister(@Param("materia") String materia);
	@Insert("INSERT INTO materias(nombre) values(#{nombre})")
	public void create(@Param("nombre") String nombre);
	@Insert("INSERT INTO preguntas(pregunta, respuestas, materia, correcta ) values(#{pregunta},#{respuestas},#{materia},#{correcta})")
	public void createPregunta(@Param("pregunta") String pregunta,@Param("respuestas") String respuestas,@Param("materia") String materia,@Param("correcta") String correcta);
	@Delete("delete from materias where id = #{id}")
	public void delete(@Param("id") int id);
	@Update("UPDATE materias SET  name=#{name} where id=#{id}")
	public void update(@Param("nombre") String nombre, @Param("id") int id);
/*jdbc:h2:~/test*/
	/*jdbc:h2:tcp://localhost/~/test*/
}
