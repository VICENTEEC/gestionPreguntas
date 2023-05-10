package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="PREGUNTAS")

public class Pregunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="enunciado es obligatorio en la clase Pregunta")
	private String enunciado;
	
	@NotNull(message="usuario es obligatorio en la clase Pregunta")
	@ManyToOne(fetch=FetchType.LAZY)            //RELACIONES
	@JoinColumn(name="UsuarioId")               //RELACIONES. ESTO CREA UNA NUEVA COLUMNA EN LA BASE DE DATOS
	private Usuario usuario;
	
	@NotNull(message="familia es obligatoria en la clase Pregunta")
	@ManyToOne(fetch=FetchType.LAZY)            //RELACIONES
	@JoinColumn(name="FamiliaId")               //RELACIONES. ESTO CREA UNA NUEVA COLUMNA EN LA BASE DE DATOS
	private FamiliaImpl familia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public FamiliaImpl getFamilia() {
		return familia;
	}
	public void setFamilia(FamiliaImpl familia) {
		this.familia = familia;
	}
	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", enunciado=" + enunciado + ", usuario=" + usuario + "]";
	}

	
}
