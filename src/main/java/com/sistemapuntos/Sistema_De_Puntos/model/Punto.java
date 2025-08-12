package com.sistemapuntos.Sistema_De_Puntos.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "puntos")
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidadDePuntos;
    private String descripcion;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    public Punto() {
    }

    public Punto(Long id, Integer cantidadDePuntos, String descripcion, Date fecha, Alumno alumno, Asignatura asignatura) {
        this.id = id;
        this.cantidadDePuntos = cantidadDePuntos;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadDePuntos() {
        return cantidadDePuntos;
    }

    public void setCantidadDePuntos(Integer cantidadDePuntos) {
        this.cantidadDePuntos = cantidadDePuntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
