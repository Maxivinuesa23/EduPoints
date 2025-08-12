package com.sistemapuntos.Sistema_De_Puntos.repository;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import com.sistemapuntos.Sistema_De_Puntos.model.Punto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PuntoRepository extends JpaRepository<Punto, Long> {

    @Query("SELECT SUM(p.cantidadDePuntos) FROM Punto p WHERE p.alumno.id = :alumnoId")
    Optional<Integer> sumarPuntosPorAlumno(@Param("alumnoId") Long alumnoId);


    @Modifying
    @Transactional
    @Query("UPDATE Punto p SET p.cantidadDePuntos = p.cantidadDePuntos - :cantidad WHERE p.alumno.id = :alumnoId")
    void quitarPuntos(@Param("alumnoId") Long alumnoId, @Param("cantidad") Integer cantidad);
}
