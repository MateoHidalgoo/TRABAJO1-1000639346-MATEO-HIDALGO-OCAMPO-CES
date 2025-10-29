//package → debe corresponder a la carpeta: src/main/java/com/mateo/conductor_vehiculos/controles/.
// import → importa clases externas.
// public class → definición de la clase.
// Comentario: todo archivo .java debe tener el package correcto para compilar.

package com.mateo.conductor_vehiculos.controles; // indica la carpeta donde vive el archivo

import com.mateo.conductor_vehiculos.repositories.ConductorRepository;
import com.mateo.conductor_vehiculos.models.Conductor;
import com.mateo.conductor_vehiculos.models.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // import: trae clases de otras librerías para funcionar
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller                               // anotación que marca la clase como componente Spring
public class ConductorController {          // declaración de clase public

    @Autowired  //Spring inyecta automáticamente la dependencia.
    private ConductorRepository conductorRepository; //permite acceder a los datos de conductores y vehículos desde la base de datos


    //Cada método en este controlador responde a una URL específica y devuelve una vista HTML con datos.
    @GetMapping("/conductores")
    public String listarConductores(Model model) {
        model.addAttribute("conductores", conductorRepository.findAll());
        return "conductores";
    }

    @GetMapping("/conductores/{id}")
    public String detalleConductor(@PathVariable int id, Model model) {
        Conductor conductor = conductorRepository.findById(id);
        if (conductor == null) {
            model.addAttribute("error", "Conductor no encontrado con ID " + id);
            return "detalle-conductor";
        }
        model.addAttribute("conductor", conductor);
        return "detalle-conductor";
    }

    @GetMapping("/vehiculos")
    public String listarVehiculos(Model model) {
        model.addAttribute("vehiculos", conductorRepository.findAllVehiculos());
        return "vehiculos";
    }

    @GetMapping("/conductores/nombres")
    public String nombresConductores(Model model) {
        model.addAttribute("nombres", conductorRepository.obtenerNombresSeparadosPorComa());
        return "nombres-conductores";
    }

    @GetMapping("/vehiculos/estadisticas")
    public String estadisticasVehiculos(Model model) {
        model.addAttribute("estadisticas", conductorRepository.estadisticasVehiculos());
        return "estadisticas-vehiculos";
    }

    @GetMapping("/vehiculos/marcas")
    public String marcasVehiculos(Model model) {
        model.addAttribute("marcas", conductorRepository.obtenerMarcasVehiculos());
        return "marcas-vehiculos";
    }

    @GetMapping("/consultas/match")
    public String consultasMatch(Model model) {
        model.addAttribute("resultados", conductorRepository.consultasMatch());
        return "consultas-match";
    }

    @GetMapping("/vehiculos/mas-nuevo")
    public String vehiculoMasNuevo(Model model) {
        model.addAttribute("vehiculo", conductorRepository.vehiculoMasNuevo());
        return "vehiculo-mas-nuevo";
    }

    @GetMapping("/")
    public String menuPrincipal() {
        return "index-menu";
    }
}
