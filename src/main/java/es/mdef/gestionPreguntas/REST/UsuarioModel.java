package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.NoAdministrador.Departamento;
import es.mdef.gestionPreguntas.entidades.NoAdministrador.Tipo;
import es.mdef.gestionPreguntas.entidades.Usuario.Role;


// La clase UsuarioModel.java es un modelo de representación utilizado para estructurar y simplificar la respuesta 
// de la API REST. Esta clase extiende la clase RepresentationModel<UsuarioModel>, que es parte del módulo Spring HATEOAS 
// y proporciona soporte para agregar enlaces a la representación de recursos.

//La anotación @Relation(itemRelation = "usuario") indica que este modelo representa un recurso individual de tipo "usuario" en las respuestas de la API. 
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