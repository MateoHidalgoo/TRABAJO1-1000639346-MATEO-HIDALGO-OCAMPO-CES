package com.mateo.conductor_vehiculos.trabajo2;

import java.util.*;
import java.util.function.Function;

public class MainTrabajo2 {
    public static void main(String[] args) {

        // --------------------------
        // PUNTO 1: Crear conductores y supervisor
        // --------------------------
        Conductor c1 = new Conductor("Mateo", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c2 = new Conductor("Daniel", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c3 = new Conductor("Camila", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c4 = new Conductor("Laura", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c5 = new Conductor("Andrés", CategoriaLicencia.B2, TipoVehiculo.CARRO);

        // Kilometrajes de los últimos 5 viajes
        int[][] kmRecorridos = {
                {20, 35, 40, 50, 25},
                {15, 30, 45, 40, 20},
                {25, 20, 30, 50, 45},
                {10, 15, 25, 20, 30},
                {30, 40, 20, 25, 35}
        };

        Conductor[] conductoresArray = {c1, c2, c3, c4, c5};
        for (int i = 0; i < conductoresArray.length; i++) {
            for (int km : kmRecorridos[i]) {
                conductoresArray[i].agregarKilometraje(km);
            }
        }

        Stack<Conductor> conductores = new Stack<>();
        conductores.addAll(Arrays.asList(c1, c2, c3, c4, c5));

        Supervisor supervisor = new Supervisor("Fabian Restrepo", CategoriaLicencia.B2, TipoVehiculo.CARRO, 10);
        Deque<Conductor> dequeConductores = new ArrayDeque<>(conductores);
        supervisor.setConductores(dequeConductores);

        System.out.println("=== PUNTO 1: Creación completada ===");

        // --------------------------
        // PUNTO 2: Iteradores
        // --------------------------
        System.out.println("\n=== PUNTO 2.a: ListIterator sobre Stack 'conductores' ===");
        ListIterator<Conductor> listIt = conductores.listIterator();
        while (listIt.hasNext()) {
            Conductor c = listIt.next();
            System.out.println("Nombre: " + c.getNombre() + " - Licencia: " + c.getLicencia() + " - Tipo: " + c.getTipoVehiculo());
        }

        System.out.println("\n=== PUNTO 2.b: Iterator sobre Deque del supervisor ===");
        Iterator<Conductor> it = supervisor.getConductores().iterator();
        while (it.hasNext()) {
            Conductor c = it.next();
            System.out.println("Nombre: " + c.getNombre() + " - Licencia: " + c.getLicencia() + " - Tipo: " + c.getTipoVehiculo());
        }

        // --------------------------
        // PUNTO 3: Programación funcional con Deque
        // --------------------------
        System.out.println("\n=== PUNTO 3: Conductores que manejan CAMION ===");
        dequeConductores.stream()
                .filter(c -> c.getTipoVehiculo() == TipoVehiculo.CAMION)
                .map(Conductor::getNombre)
                .forEach(System.out::println);

        // --------------------------
        // PUNTO 4: Function<Conductor,Integer> que suma todos los kilómetros
        // --------------------------
        System.out.println("\n=== PUNTO 4: Función que suma kilómetros ===");
        Function<Conductor, Integer> sumaKilometros = c ->
                c.getKilometrajes().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma total de kilómetros de " + c1.getNombre() + ": " + sumaKilometros.apply(c1));

        // --------------------------
        // PUNTO 5: Método verTotalKilometros()
        // --------------------------
        System.out.println("\n=== PUNTO 5: Método verTotalKilometros ===");
        c1.verTotalKilometros(sumaKilometros);

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
