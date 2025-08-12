package com.sistemapuntos.Sistema_De_Puntos.controller;

import com.sistemapuntos.Sistema_De_Puntos.model.Asignatura;
import com.sistemapuntos.Sistema_De_Puntos.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping
    public Asignatura crearAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.crearAsignatura(asignatura);
    }
}
