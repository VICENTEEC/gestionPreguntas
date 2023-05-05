package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario{
	private static final long serialVersionUID = 1L;
	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return Role.Administrador;
	}

	@Override
	public String toString() {
		return "Administrador [telefono=" + telefono + "]";
	}
	
}
