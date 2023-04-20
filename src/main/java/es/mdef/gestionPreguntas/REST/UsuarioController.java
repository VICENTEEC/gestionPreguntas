package es.mdef.gestionPreguntas.REST;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.gestionPreguntas.GestionPreguntasApplication;
import es.mdef.gestionPreguntas.entidades.Usuario;
import es.mdef.gestionPreguntas.repositorios.UsuarioRepositorio;



	// La clase UsuarioController es la capa de presentación para la API REST de usuario 
	// y se encarga de procesar las solicitudes HTTP, interactuar con el repositorio y 
	// convertir las entidades en modelos de respuesta adecuados para el cliente.
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
	private final UsuarioListaAssembler listaAssembler;
	private final Logger log;
	
	
	// El constructor toma como parámetros un UsuarioRepositorio, un
	// UsuarioAssembler y un UsuarioListaAssembler. Estos componentes son necesarios
	// para interactuar con la base de datos y realizar conversiones entre entidades
	// y modelos. Además, el constructor inicializa un objeto Logger para realizar
	// registros de eventos durante el ciclo de vida del controlador.
	UsuarioController(UsuarioRepositorio repositorio, UsuarioAssembler assembler, UsuarioListaAssembler listaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		log = GestionPreguntasApplication.log;
	}
	
	// Este método @GetMapping maneja las solicitudes GET para un usuario específico
	// por su ID. Recupera la entidad Usuario del repositorio utilizando el ID
	// proporcionado y convierte la entidad en un modelo EntityModel<Usuario>
	// utilizando el ensamblador. Si el usuario no se encuentra, se lanza una
	// excepción RegisterNotFoundException.
	@GetMapping("{id}")
	public EntityModel<Usuario> one(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Recuperado " + usuario);
		return assembler.toModel(usuario);
	}
	
	// Este método @GetMapping maneja las solicitudes GET para todos los usuarios.
	// Recupera todas las entidades Usuario del repositorio y las convierte en una
	// colección de modelos UsuarioListaModel utilizando el ensamblador de lista.
	@GetMapping
	public CollectionModel<UsuarioListaModel> all() {
		log.info("llegaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	// Este método @GetMapping maneja las solicitudes GET para buscar usuarios por
	// su nombre de usuario. Utiliza el repositorio para encontrar usuarios que
	// coincidan con el nombre de usuario proporcionado y convierte las entidades
	// encontradas en una colección de modelos UsuarioListaModel utilizando el
	// ensamblador de lista.
	@GetMapping("porNombreUsuario")
	public CollectionModel<UsuarioListaModel> usuariosPorNombreUsuario(@RequestParam String nombreUsuario) {
		return listaAssembler.toCollection(
				repositorio.findUsuarioByNombreUsuario(nombreUsuario)
				);
	}
	
	// Este método @PostMapping maneja las solicitudes POST para agregar un nuevo
	// usuario. Convierte el UsuarioModel proporcionado en una entidad Usuario
	// utilizando el ensamblador, luego guarda la entidad en el repositorio y
	// devuelve un modelo EntityModel<Usuario> para el usuario recién creado
	@PostMapping
	public EntityModel<Usuario> add(@RequestBody UsuarioModel model) {
		Usuario usuario = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + usuario);
		return assembler.toModel(usuario);
	}
	
	
	// Este método @PutMapping maneja las solicitudes PUT para actualizar un usuario
	// existente por su ID. Busca la entidad Usuario en el repositorio, actualiza
	// sus campos utilizando el UsuarioModel proporcionado y guarda la entidad
	// actualizada en el repositorio. Devuelve un modelo EntityModel<Usuario> para
	// el usuario actualizado. Si el usuario no se encuentra, se lanza una excepción
	// RegisterNotFoundException.
	@PutMapping("{id}")
	public EntityModel<Usuario> edit(@PathVariable Long id, @RequestBody UsuarioModel model) {
		Usuario usuario = repositorio.findById(id).map(usr -> {
			usr.setNombre(model.getNombre());
			usr.setNombreUsuario(model.getNombreUsuario());
			usr.setRole(model.getRole());
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "pedido"));
		log.info("Actualizado " + usuario);
		return assembler.toModel(usuario);
	}

	// Este método @DeleteMapping maneja las solicitudes DELETE para eliminar un
	// usuario por su ID. Utiliza el repositorio para eliminar la entidad Usuario
	// asociada con el ID proporcionado.
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado usuario " + id);
		repositorio.deleteById(id);
	}
}