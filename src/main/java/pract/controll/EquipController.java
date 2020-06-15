package pract.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pract.model.Equip;
import pract.service.ServiceEquip;

@Controller
public class EquipController {

    @Autowired
    private ServiceEquip servicioEquipo;

    @RequestMapping(value = "/equipos", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("equipos", servicioEquipo.findAll());

        return "equip";
    }

    @Secured({"Administrador"})
    @RequestMapping(value = "/registrar/equipo", method = RequestMethod.POST)
    public String post(@RequestParam(name = "codigo") String codigo,
                        @RequestParam(name = "nombre") String nombre,
                        @RequestParam(name = "cantidadexistencia") int cantidadExistencia,
                       @RequestParam(name = "costoalquilerpordia") int costoAlquilerPorDia) {
        Equip equipo = new Equip();
        equipo.setCodigo(codigo);
        equipo.setNombre(nombre);
        equipo.setCantidadExistencia(cantidadExistencia);
        equipo.setCostoAlquilerPorDia(costoAlquilerPorDia);
        equipo.setEntregado(false);

        servicioEquipo.save(equipo);

        return "redirect:/equipos";
    }


    @RequestMapping(value = "/borrar/equipo", method = RequestMethod.GET)
    public String borrar(@RequestParam(name = "id") long id) {
        servicioEquipo.delete(id);

        return "redirect:/equipos";
    }
}
