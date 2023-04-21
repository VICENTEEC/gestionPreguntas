package es.mdef.gestionPreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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

    @Enumerated(EnumType.STRING)
    private Departamento departamento;

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
