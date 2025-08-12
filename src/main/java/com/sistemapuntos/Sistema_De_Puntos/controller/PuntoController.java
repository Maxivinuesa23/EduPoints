package com.sistemapuntos.Sistema_De_Puntos.controller;

import com.sistemapuntos.Sistema_De_Puntos.model.Alumno;
import com.sistemapuntos.Sistema_De_Puntos.model.Punto;
import com.sistemapuntos.Sistema_De_Puntos.service.PuntoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puntos")
public class PuntoController {

    @Autowired
    private PuntoService puntoService;

    @PostMapping
    public ResponseEntity<Punto> crearPunto(@RequestBody Punto punto){
        Punto nuevoPunto = puntoService.crearPunto(punto);
        return new ResponseEntity<>(nuevoPunto, HttpStatus.CREATED);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<Integer> obtenerPuntoPorId(@PathVariable Long alumnoId){
        Optional<Integer> totalPuntos = puntoService.obtenerPuntoPorId(alumnoId);
        if (totalPuntos.isPresent()){
            return new ResponseEntity<>(totalPuntos.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
    }

    @PostMapping("/quitar/{alumnoId}/{cantidad}")
    public ResponseEntity<Integer> quitarPuntos(@PathVariable Long alumnoId, @PathVariable Integer cantidad){
        Optional<Integer> puntoActualizado = puntoService.quitarPuntos(alumnoId, cantidad);
        if (puntoActualizado.isPresent()){
            return new ResponseEntity<>(puntoActualizado.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
    }
}
