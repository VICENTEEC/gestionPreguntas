package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(itemRelation="familia")
public class FamiliaModel extends RepresentationModel <FamiliaModel>{

	private String enunciado;
	private long tamano;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public long getTamano() {
		return tamano;
	}
	public void setTamano(long tamano) {
		this.tamano = tamano;
	}
	@Override
	public String toString() {
		return "FamiliaModel [enunciado=" + enunciado + ", tamano=" + tamano + "]";
	}
	
	
}
