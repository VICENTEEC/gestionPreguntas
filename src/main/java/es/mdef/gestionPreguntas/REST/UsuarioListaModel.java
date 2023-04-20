package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.Usuario.Role;


// La clase UsuarioListaModel.java es otro modelo de representación diseñado para estructurar 
// y simplificar las respuestas de la API REST al trabajar con colecciones de usuarios. Al igual que la 
// clase UsuarioModel, esta clase también extiende RepresentationModel<UsuarioListaModel> del módulo Spring HATEOAS.

// La clase UsuarioListaModel es una representación simplificada de la entidad Usuario utilizada para estructurar las 
// respuestas de la API REST al trabajar con colecciones de usuarios. Al extender RepresentationModel, también permite agregar 
// enlaces HATEOAS a los recursos de usuario en la API.

// La principal diferencia entre UsuarioModel y UsuarioListaModel es la anotación @Relation. Mientras que UsuarioModel 
// utiliza itemRelation = "usuario" para representar un recurso individual, UsuarioListaModel utiliza collectionRelation = "usuarios" para 
// representar una colección de recursos de tipo "usuario".

// La anotación @Relation(collectionRelation = "usuarios") indica que este modelo representa una colección de recursos 
// de tipo "usuario" en las respuestas de la API. Esta anotación es útil para agregar información adicional sobre las relaciones 
// entre recursos al trabajar con colecciones.
@Relation(collectionRelation = "usuarios")
public class UsuarioListaModel extends RepresentationModel<UsuarioListaModel>{
	private String nombre;
	private Role role;
	
	public String getNombre() {
		return nombre;
	}
	
	public Role getRole() {
		return role;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsuarioListaModel [nombre=" + nombre + ", role=" + role + "]";
	}
	
}