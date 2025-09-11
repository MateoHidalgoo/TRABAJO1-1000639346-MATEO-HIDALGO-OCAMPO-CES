package com.mateo.conductor_vehiculos.repositories;

import com.mateo.conductor_vehiculos.models.Conductor;
import com.mateo.conductor_vehiculos.models.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class ConductorRepository {

    private List<Conductor> conductores;

    public ConductorRepository() {
        inicializarDatos();
    }

    private void inicializarDatos() {
        String[] nombres = {
                "Juan Pérez", "Ana Gómez", "Carlos Ramírez", "María López",
                "Luis Torres", "Sofía Castro", "Pedro Jiménez", "Laura Herrera",
                "Andrés Martínez", "Paula Ríos", "Felipe Duarte", "Camila Salazar",
                "Hernán Vargas", "Diana Pineda", "Jorge Gutiérrez", "Isabel Castaño",
                "Manuel Cardona", "Valeria Hoyos", "Ricardo Jaramillo", "Lucía Mejía"
        };

        String[] marcas = {"Toyota", "Mazda", "Renault", "Chevrolet", "Hyundai", "Kia", "Nissan"};
        String[] modelos = {"Corolla", "CX-5", "Duster", "Spark", "Tucson", "Rio", "Versa"};

        Random random = new Random();

        conductores = IntStream.range(0, 20)
                .mapToObj(i -> {
                    List<Vehiculo> vehiculos = IntStream.range(0, random.nextInt(4))
                            .mapToObj(j -> new Vehiculo(
                                    j + 1,
                                    marcas[random.nextInt(marcas.length)],
                                    modelos[random.nextInt(modelos.length)],
                                    2010 + random.nextInt(15) // entre 2010 y 2024
                            ))
                            .toList();

                    return new Conductor(
                            i + 1,
                            nombres[i],
                            "Lic-" + (1000 + i),
                            random.nextInt(20),
                            vehiculos
                    );
                })
                .toList();
    }

    // Todos los conductores
    public List<Conductor> findAll() {
        return conductores;
    }

    // Conductor por id
    public Conductor findById(int id) {
        return conductores.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Todos los vehículos de todos los conductores
    public List<Vehiculo> findAllVehiculos() {
        return conductores.stream()
                .flatMap(c -> c.getVehiculos().stream())
                .toList();
    }

    // Petición 1: nombres separados por coma
    public String obtenerNombresSeparadosPorComa() {
        return conductores.stream()
                .map(Conductor::getNombreCompleto)
                .collect(Collectors.joining(", "));
    }

    // Petición 2: estadísticas
    public String estadisticasVehiculos() {
        var todos = findAllVehiculos();

        if (todos.isEmpty()) {
            return "No hay vehículos registrados.";
        }

        var stats = todos.stream()
                .mapToInt(Vehiculo::getAnio)
                .summaryStatistics();

        return "Total vehículos: " + stats.getCount() +
                " | Año promedio: " + stats.getAverage() +
                " | Año más antiguo: " + stats.getMin() +
                " | Año más reciente: " + stats.getMax();
    }

    // Petición 3: marcas
    public List<String> obtenerMarcasVehiculos() {
        return findAllVehiculos().stream()
                .map(Vehiculo::getMarca)
                .toList();
    }

    // Petición 4: anyMatch / noneMatch
    public List<String> consultasMatch() {
        boolean haySinVehiculos = conductores.stream()
                .anyMatch(c -> c.getVehiculos().isEmpty());

        boolean hayConMasDeUno = conductores.stream()
                .anyMatch(c -> c.getVehiculos().size() > 1);

        boolean ningunoMasDeTres = conductores.stream()
                .noneMatch(c -> c.getVehiculos().size() > 3);

        return List.of(
                "¿Hay conductores sin vehículos?: " + (haySinVehiculos ? "Sí" : "No"),
                "¿Hay conductores con más de un vehículo?: " + (hayConMasDeUno ? "Sí" : "No"),
                "¿Ningún conductor tiene más de 3 vehículos?: " + (ningunoMasDeTres ? "Sí" : "No")
        );
    }

    // Petición 5: vehículo más nuevo
    public Vehiculo vehiculoMasNuevo() {
        return findAllVehiculos().stream()
                .max(Comparator.comparingInt(Vehiculo::getAnio))
                .orElse(null);
    }
}
