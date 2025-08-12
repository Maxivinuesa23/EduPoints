package com.sistemapuntos.Sistema_De_Puntos.repository;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    //Consulta que devuelve la id de un alumno por su email
    @Query("SELECT a.id FROM Alumno a WHERE a.email = :email")
    Optional<Long> findIdByEmail(String email);

}
