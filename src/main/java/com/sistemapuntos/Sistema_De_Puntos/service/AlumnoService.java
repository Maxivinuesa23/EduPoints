package com.sistemapuntos.Sistema_De_Puntos.service;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import com.sistemapuntos.Sistema_De_Puntos.model.Asignatura;
import com.sistemapuntos.Sistema_De_Puntos.repository.AlumnoRepository;
import com.sistemapuntos.Sistema_De_Puntos.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository repository;
    @Autowired
    private AsignaturaRepository asignaturaRepository;


    public Alumno crearAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    public Alumno asignarAsignatura(Long alumnoId, Long asignaturaId) {
        Alumno alumno = repository.findById(alumnoId)
                .orElseThrow( () -> new RuntimeException("Alumno no encontrado con ID: " + alumnoId));

        Asignatura asignatura = asignaturaRepository.findById(asignaturaId)
                .orElseThrow( () -> new RuntimeException("Asignatura no encontrada con ID: " + asignaturaId));

        alumno.getAsignaturas().add(asignatura);

        return repository.save(alumno);
    }
}
