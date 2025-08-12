package com.sistemapuntos.Sistema_De_Puntos.service;

import com.sistemapuntos.Sistema_De_Puntos.model.Profesor;
import com.sistemapuntos.Sistema_De_Puntos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository repository;

    public Profesor crearProfesor(Profesor profesor) {
        return repository.save(profesor);
    }

    public void borrarProfesor(Profesor profesor) {
        repository.delete(profesor);
    }
}
