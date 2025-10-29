package com.mateo.conductor_vehiculos.web;

import com.mateo.conductor_vehiculos.trabajo2.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;

@Controller
public class Trabajo2Controller {

    @GetMapping("/trabajo2")
    public String mostrarTrabajo2(Model model) {

        // ---------- PUNTO 1 ----------
        Conductor c1 = new Conductor("Mateo", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c2 = new Conductor("Daniel", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c3 = new Conductor("Camila", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c4 = new Conductor("Laura", CategoriaLicencia.B2, TipoVehiculo.CARRO);
        Conductor c5 = new Conductor("Andrés", CategoriaLicencia.B2, TipoVehiculo.CAMION);

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

        // ---------- PUNTO 4 ----------
        Function<Conductor, Integer> sumaKilometros = c ->
                c.getKilometrajes().stream().mapToInt(Integer::intValue).sum();

        // Pasar datos al HTML
        model.addAttribute("conductores", conductores);
        model.addAttribute("supervisor", supervisor);
        model.addAttribute("sumaKilometros", sumaKilometros);
        model.addAttribute("camioneros", dequeConductores.stream()
                .filter(c -> c.getTipoVehiculo() == TipoVehiculo.CAMION)
                .toList());

        return "trabajo2"; // Nombre del archivo HTML
    }
}
