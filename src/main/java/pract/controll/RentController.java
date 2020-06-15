package pract.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pract.model.Custom;
import pract.model.Equip;
import pract.model.Rent;
import pract.service.ServiceRent;
import pract.service.ServiceCustom;
import pract.service.ServiceEquip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RentController {

    @Autowired
    private ServiceRent servicioAlquiler;

    @Autowired
    private ServiceCustom servicioCliente;

    @Autowired
    private ServiceEquip servicioEquipo;

    @RequestMapping(value = "/alquileres", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("alquileres", servicioAlquiler.findAll());
        model.addAttribute("clientes", servicioCliente.findAll());
        model.addAttribute("equipos", servicioEquipo.findAll());

        return "rentals";
    }

    @Secured({"Administrador"})
    @RequestMapping(value = "/registrar/alquiler", method = RequestMethod.POST)
    public String post(@RequestParam(name = "cliente") long cliente,
                       @RequestParam(name = "fechaentrega") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaEntrega,
                       @RequestParam(name = "codigo") String codigo) {
        Rent alquiler = new Rent();
        alquiler.setEquipo(servicioEquipo.findByCodigo(codigo));
        alquiler.setFechaRealizado(LocalDate.now());
        alquiler.setCliente(servicioCliente.findOne(cliente));
        alquiler.setFechaEntrega(fechaEntrega);

        servicioAlquiler.save(alquiler);

        return "redirect:/alquileres/";
    }
}
