package com.sistemapuntos.Sistema_De_Puntos.controller;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import com.sistemapuntos.Sistema_De_Puntos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService servicio;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        return servicio.crearAlumno(alumno);
    }

    @PostMapping("/{alumnoId}/asignaturas/{asignaturaId}")
    public ResponseEntity<Alumno> asignarAsignatura(
            @PathVariable Long alumnoId,
            @PathVariable Long asignaturaId
    ){
        Alumno alumnoActualizado = servicio.asignarAsignatura(alumnoId, asignaturaId);
        return ResponseEntity.ok(alumnoActualizado);
    }

}
