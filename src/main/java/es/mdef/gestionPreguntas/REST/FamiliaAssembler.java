package es.mdef.gestionPreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gestionPreguntas.entidades.FamiliaImpl;


@Component
public class FamiliaAssembler implements RepresentationModelAssembler<FamiliaImpl, FamiliaModel>{

	public FamiliaModel toModel(FamiliaImpl entity) {
		FamiliaModel model = new FamiliaModel();
		
		model.setEnunciado(entity.getEnunciado());
		model.setTamano(entity.getTamano());
		model.add(
				linkTo(methodOn(FamiliaController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(FamiliaController.class).usuariosEnFamilias(entity.getId())).slash("usuarios").withRel("usuariosssssssssssssssssss"),
				linkTo(methodOn(FamiliaController.class).preguntasEnFamilias(entity.getId())).slash("preguntas").withRel("preguntassssssssssssssssss")
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
