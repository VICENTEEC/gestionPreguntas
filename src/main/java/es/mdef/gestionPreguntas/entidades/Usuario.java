package es.mdef.gestionPreguntas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity                                               // @Entity y @Table: Estas anotaciones indican que esta clase es una entidad de base de datos y debe mapearse a una tabla llamada "USUARIOS" en la base de datos.
@Table(name="USUARIOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="tipo_role", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("null")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Usuario {
	public static enum Role {
		Administrador,
		NoAdministrador
	}

	@Id                                               // La anotación @Id indica que el campo "id" es la clave primaria de la tabla de usuarios. 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // La anotación @GeneratedValue indica que el valor de "id" se generará automáticamente al insertar un nuevo registro en la base de datos.
	@JsonIgnore                                       // indica que el campo "id" no debe incluirse en la serialización JSON. Esto podría ser útil si no deseas que el identificador se envíe al cliente cuando conviertes la entidad en una respuesta JSON.
	private Long id;
	private String nombre;
	private String nombreUsuario;
	private String contrasena;

	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public Role getRole() {
		return null;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena="
				+ contrasena + "]";
	}

}
