package com.sistemapuntos.Sistema_De_Puntos.service;

import com.sistemapuntos.Sistema_De_Puntos.model.Asignatura;
import com.sistemapuntos.Sistema_De_Puntos.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository repository;

    public Asignatura crearAsignatura(Asignatura asignatura) {
        return repository.save(asignatura);
    }
}
