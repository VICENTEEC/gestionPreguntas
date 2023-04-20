package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class NoAdministrador extends Usuario {
	public static enum Departamento {
		EMIES,
		CCESP
	}
	
	public static enum Tipo {
		alumno,
		docente,
		administracion
	}
	
	private Departamento departamento;
	private Tipo tipo;
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return Role.NoAdministrador;
	}
	@Override
	public String toString() {
		return "NoAdministrador [departamento=" + departamento + ", tipo=" + tipo + "]";
	}
	
	
}
