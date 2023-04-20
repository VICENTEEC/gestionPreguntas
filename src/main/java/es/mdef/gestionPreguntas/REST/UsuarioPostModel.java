package es.mdef.gestionPreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gestionPreguntas.entidades.NoAdministrador.Departamento;
import es.mdef.gestionPreguntas.entidades.NoAdministrador.Tipo;
import es.mdef.gestionPreguntas.entidades.Usuario.Role;

@Relation(itemRelation="usuario")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	private Departamento departamento;
	private Tipo tipo;
	private String telefono;
	private Role role;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
				+ ", departamento=" + departamento + ", tipo=" + tipo + ", telefono=" + telefono + ", role=" + role
				+ "]";
	}
	
	
	
}
