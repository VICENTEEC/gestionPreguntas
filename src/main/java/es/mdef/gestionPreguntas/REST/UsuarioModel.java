package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.NoAdministrador.Departamento;
import es.mdef.gestionPreguntas.entidades.NoAdministrador.Tipo;
import es.mdef.gestionPreguntas.entidades.Usuario.Role;

@Relation(itemRelation="usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{
	
	private String nombre;
	private String nombreUsuario;
	private Departamento departamento;
	private Tipo tipo;
	private String telefono;
	private Role role;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public String getTelefono() {
		return telefono;
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
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}