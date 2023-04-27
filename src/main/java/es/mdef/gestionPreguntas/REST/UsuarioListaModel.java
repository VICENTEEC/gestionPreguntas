package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.Usuario.Role;

@Relation(collectionRelation = "usuarios")
public class UsuarioListaModel extends RepresentationModel<UsuarioListaModel>{
	private String nombre;
	private String nombreUsuario;
	private Role role;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public Role getRole() {
		return role;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsuarioListaModel [nombre=" + nombre + ", role=" + role + "]";
	}
	
}