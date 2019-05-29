package mx.edu.ulsaoaxaca.sexto.proyecto1.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.sexto.proyecto1.model.Usuarios;

@Mapper
public interface UsuarioMapper {
	@Select("select user_id, user_name, user_password, user_birthdate, user_role from usuarios")
	public List<Usuarios> findAll();
	@Insert("INSERT INTO usuarios(user_name, user_password, user_birthdate, user_role) values(#{user_name}, #{user_password}, #{user_birthdate}, #{rol})")
	public void create(@Param("user_name") String username, @Param("user_password") String password, @Param("user_birthdate") Date date, @Param("rol") String rol);
	@Delete("delete from usuarios where user_id = #{user_id}")
	public void delete(@Param("user_id") int id);
	@Update("UPDATE usuarios SET  user_name=#{user_name}, user_password=#{user_password}, user_birthdate=#{user_birthdate}, user_role=#{rol} where user_id=#{id}")
	public void update(@Param("user_name") String username, @Param("user_password") String password, @Param("user_birthdate") Date date, @Param("rol") String rol, @Param("id") int id);

}
