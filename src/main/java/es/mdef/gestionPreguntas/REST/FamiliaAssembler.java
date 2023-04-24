package es.mdef.gestionPreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import es.mdef.gestionPreguntas.entidades.FamiliaImpl;
import es.mdef.support.Familia;

@Component
public class FamiliaAssembler implements RepresentationModelAssembler<FamiliaImpl, FamiliaModel>{

	public FamiliaModel toModel(FamiliaImpl entity) {
		FamiliaModel model = new FamiliaModel();
		
		model.setEnunciado(entity.getEnunciado());
		model.setTamano(entity.getTamano());
		model.add(
				linkTo(methodOn(FamiliaController.class).one(entity.getId())).withSelfRel(),
		     	linkTo(methodOn(FamiliaController.class).preguntasDeFamilia(entity.getId())).withRel("preguntas"),
		     	linkTo(methodOn(FamiliaController.class).usuariosDeFamilia(entity.getId())).withRel("usuarios")
				);
		return model;		
	}
	
	public FamiliaImpl toEntity(FamiliaModel model) {
		FamiliaImpl familiaImpl = new FamiliaImpl();
		familiaImpl.setEnunciado(model.getEnunciado());
		familiaImpl.setTamano(model.getTamano());
		return familiaImpl;
	}

	
	
}
