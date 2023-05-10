package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("A")   ///////HERENCIA
public class Administrador extends Usuario{
	private static final long serialVersionUID = 1L;
	
    @NotNull(message="telefono es obligatorio en el usuario administrador")
	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public Role getRole() {
		return Role.Administrador;
	}

	@Override
	public String toString() {
		return "Administrador [telefono=" + telefono + "]";
	}
	
}
