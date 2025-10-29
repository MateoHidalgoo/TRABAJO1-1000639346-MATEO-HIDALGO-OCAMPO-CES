package com.mateo.conductor_vehiculos.trabajo2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Supervisor {
    private String nombre;
    private CategoriaLicencia licencia;
    private TipoVehiculo tipoVehiculo;
    private int añosExperiencia;
    private Deque<Conductor> conductores;

    // Constructor vacío
    public Supervisor() {
        this.conductores = new ArrayDeque<>();
    }

    // Constructor con parámetros
    public Supervisor(String nombre, CategoriaLicencia licencia, TipoVehiculo tipoVehiculo, int añosExperiencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.tipoVehiculo = tipoVehiculo;
        this.añosExperiencia = añosExperiencia;
        this.conductores = new ArrayDeque<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaLicencia getLicencia() {
        return licencia;
    }

    public void setLicencia(CategoriaLicencia licencia) {
        this.licencia = licencia;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public Deque<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(Deque<Conductor> conductores) {
        this.conductores = conductores;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "nombre='" + nombre + '\'' +
                ", licencia=" + licencia +
                ", tipoVehiculo=" + tipoVehiculo +
                ", añosExperiencia=" + añosExperiencia +
                '}';
    }
}
