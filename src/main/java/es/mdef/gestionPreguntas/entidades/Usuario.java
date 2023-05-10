package es.mdef.gestionPreguntas.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity                         ////PRIMER VIDEO CREACION USUARIOS
@Table(name="USUARIOS")         ////PRIMER VIDEO CREACION USUARIOS
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)                             ////HERENCIA 
@DiscriminatorColumn(name="tipo_role", discriminatorType = DiscriminatorType.CHAR)////HERENCIA
@DiscriminatorValue("null")                                                       ////HERENCIA
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})            ////HERENCIA
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;///////////////////
    public static enum Role {
        Administrador,
        NoAdministrador
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    
    @NotBlank(message="nombre es obligatorio en la clase Usuario")
    private String nombre;
    
    @NotBlank(message="username es obligatorio en la clase Usuario")
    private String username;
    
    @NotBlank(message="contraseña es obligatoria en la clase Usuario")
    private String password;
    
	@Column(name="cuenta_activa")
	private boolean accountNonExpired = true;
	@Column(name="cuenta_desbloqueada")
	private boolean accountNonLocked = true;
	@Column(name="credenciales_activas")
	private boolean credentialsNonExpired = true;
	@Column(name="habilitada")
	private boolean enabled = true;
    
    @OneToMany(mappedBy = "usuario")                //RELACIONES
    List<Pregunta> preguntas;

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
    
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return null;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String contrasena) {
        this.password = contrasena;
    }
    
    public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", usename=" + username + ", password="
                + password + "]";
    }
	
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<SimpleGrantedAuthority>(
				Arrays.asList(new SimpleGrantedAuthority(getRole().toString()))
				);
	}
}
