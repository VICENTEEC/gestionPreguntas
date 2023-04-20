package es.mdef.gestionPreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gestionPreguntas.entidades.Usuario;

// La clase UsuarioAssembler.java es un componente que se utiliza para convertir entidades Usuario en modelos de 
// representación de la API REST (en este caso, EntityModel<Usuario>), y viceversa. Esta clase implementa la interfaz 
// RepresentationModelAssembler<Usuario, EntityModel<Usuario>> de Spring HATEOAS y anota con @Component para que Spring 
// la reconozca como un bean y la gestione automáticamente. 
@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>>{
	
	// Este método toma una entidad Usuario como argumento y crea un
	// EntityModel<Usuario> a partir de ella. El EntityModel se crea con el método
	// estático EntityModel.of(entity) y se le agrega un enlace HATEOAS con el
	// método add. El enlace HATEOAS apunta al método one del controlador
	// UsuarioController, permitiendo a los clientes de la API navegar fácilmente a
	// los detalles de un usuario específico.
	@Override
	public EntityModel<Usuario> toModel(Usuario entity) {
		EntityModel<Usuario> model = EntityModel.of(entity);
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				);
		return model;
	}
	
	// Este método hace lo contrario al método toModel. Toma un UsuarioModel como
	// argumento y crea una nueva instancia de la entidad Usuario a partir de él.
	// Copia los campos nombre, nombreUsuario y role del modelo al objeto de entidad
	// creado.
	public Usuario toEntity(UsuarioModel model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setRole(model.getRole());
		return usuario;
	}
}