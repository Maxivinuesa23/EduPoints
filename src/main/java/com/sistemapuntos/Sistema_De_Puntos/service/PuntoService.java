package com.sistemapuntos.Sistema_De_Puntos.service;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import com.sistemapuntos.Sistema_De_Puntos.model.Punto;
import com.sistemapuntos.Sistema_De_Puntos.repository.PuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntoService {
    @Autowired
    private PuntoRepository repository;

    public Punto crearPunto(Punto punto) {
        return repository.save(punto);
    }


    public Optional<Integer> obtenerPuntoPorId(Long id) {
        return repository.sumarPuntosPorAlumno(id);
    }


    public Optional<Integer> quitarPuntos(Long alumnoId, Integer cantidad) {
        Optional<Integer> puntosActuales = repository.sumarPuntosPorAlumno(alumnoId);
        if (puntosActuales.isPresent() && puntosActuales.get() >= cantidad){
            repository.quitarPuntos(alumnoId, cantidad);
            return repository.sumarPuntosPorAlumno(alumnoId);
        } else {
            return Optional.empty();
        }
    }
}
