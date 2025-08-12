package com.sistemapuntos.Sistema_De_Puntos.controller;

import com.sistemapuntos.Sistema_De_Puntos.model.Profesor;
import com.sistemapuntos.Sistema_De_Puntos.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor){
        return profesorService.crearProfesor(profesor);
    }

    @DeleteMapping
    public void borrarProfesor(@RequestBody Profesor profesor){
        profesorService.borrarProfesor(profesor);
    }
}
