package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("N")   ///////HERENCIA
public class NoAdministrador extends Usuario {

    private static final long serialVersionUID = 1L;
	public static enum Departamento {
        EMIES,
        CCESP
    }

    public static enum Tipo {
        alumno,
        docente,
        administracion
    }

    @NotNull(message="departamento es obligatorio en el usuario no administrador")
    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    @NotNull(message="tipo es obligatorio en el usuario no administrador")
    @Enumerated(EnumType.STRING)
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
        return Role.NoAdministrador;
    }
    @Override
    public String toString() {
        return "NoAdministrador [departamento=" + departamento + ", tipo=" + tipo + "]";
    }
}
