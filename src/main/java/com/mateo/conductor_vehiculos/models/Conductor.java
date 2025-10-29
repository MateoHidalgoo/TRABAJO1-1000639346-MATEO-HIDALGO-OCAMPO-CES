package com.mateo.conductor_vehiculos.models;

import java.util.List;

//Modelo conductor
public class Conductor {
    private int id;     // identificador primario
    private String nombreCompleto;  //Variable de texto
    private String licencia;
    private int aniosExperiencia;   //variable de años de experiencia numerica
    private List<Vehiculo> vehiculos; // relación uno a muchos

    // Constructor vacío y luego llenarlo con los setters
    public Conductor() {
    }

    // Constructor con parámetros, recibe los parametros MELOOO ESTOY APRENDIENDO JAJAJJA y los asigna al objeto. crea un objeto conductor completamente inicializado
    public Conductor(int id, String nombreCompleto, String licencia, int aniosExperiencia, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.licencia = licencia;
        this.aniosExperiencia = aniosExperiencia;
        this.vehiculos = vehiculos;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public List<Vehiculo> getVehiculos() { return vehiculos; }
    public void setVehiculos(List<Vehiculo> vehiculos) { this.vehiculos = vehiculos; }
}
