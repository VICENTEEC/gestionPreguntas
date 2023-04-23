package es.mdef.gestionPreguntas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.gestionPreguntas.entidades.Pregunta;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Long> {

}

