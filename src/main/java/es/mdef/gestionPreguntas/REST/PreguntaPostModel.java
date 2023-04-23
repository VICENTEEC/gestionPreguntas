package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.Usuario;

@Relation(itemRelation="pregunta")
public class PreguntaPostModel extends RepresentationModel<PreguntaPostModel>{
	
	private String enunciado;
	private Usuario usuario;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "PreguntaPostModel [enunciado=" + enunciado + ", usuario=" + usuario + "]";
	}
	
	

}
