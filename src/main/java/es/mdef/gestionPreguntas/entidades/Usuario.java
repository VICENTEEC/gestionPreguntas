package es.mdef.gestionPreguntas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                                               // @Entity y @Table: Estas anotaciones indican que esta clase es una entidad de base de datos y debe mapearse a una tabla llamada "USUARIOS" en la base de datos.
@Table(name="USUARIOS")
public class Usuario {
	public static enum Role {
		administrador,
		noAdministrador
	}

	@Id                                               // La anotación @Id indica que el campo "id" es la clave primaria de la tabla de usuarios. 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // La anotación @GeneratedValue indica que el valor de "id" se generará automáticamente al insertar un nuevo registro en la base de datos.
	@JsonIgnore                                       // indica que el campo "id" no debe incluirse en la serialización JSON. Esto podría ser útil si no deseas que el identificador se envíe al cliente cuando conviertes la entidad en una respuesta JSON.
	private Long id;
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	private Role role;
	
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
		return role;
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
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario
				+ ", contrasena=" + contrasena + ", role=" + role + "]";
	}
	
}
