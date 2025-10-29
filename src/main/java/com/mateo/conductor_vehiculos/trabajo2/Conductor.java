package com.mateo.conductor_vehiculos.trabajo2;

import java.util.Stack;
import java.util.function.Function;

public class Conductor {
    private String nombre;
    private CategoriaLicencia licencia;
    private TipoVehiculo tipoVehiculo;
    private Stack<Integer> kilometrajes;

    // Constructor vacío
    public Conductor() {
        this.kilometrajes = new Stack<>();
    }

    // Constructor con parámetros
    public Conductor(String nombre, CategoriaLicencia licencia, TipoVehiculo tipoVehiculo) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.tipoVehiculo = tipoVehiculo;
        this.kilometrajes = new Stack<>();
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

    public Stack<Integer> getKilometrajes() {
        return kilometrajes;
    }

    public void setKilometrajes(Stack<Integer> kilometrajes) {
        this.kilometrajes = kilometrajes;
    }

    // Agregar recorrido al Stack
    public void agregarKilometraje(int km) {
        this.kilometrajes.push(km);
    }

    // Punto 5: verTotalKilometros
    public void verTotalKilometros(Function<Conductor, Integer> funcionSuma) {
        int total = funcionSuma.apply(this);
        System.out.println("Conductor: " + this.nombre + " - Total kilómetros recorridos: " + total + " km");
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", licencia=" + licencia +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }
}
