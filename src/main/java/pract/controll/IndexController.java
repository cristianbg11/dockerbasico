package pract.controll;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pract.service.ServiceRent;
import pract.service.ServiceCustom;
import pract.service.ServiceEquip;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ServiceCustom servicioCliente;

    @Autowired
    private ServiceEquip servicioEquipo;

    @Autowired
    private ServiceRent servicioAlquiler;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("clientes", servicioCliente.findAll().size());
        model.addAttribute("equipos", servicioEquipo.findAll().size());
        model.addAttribute("alquileres", servicioAlquiler.findAll().size());

        List<String> labels = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (Object[] objects : servicioAlquiler.getPromedioAlquileresPorDia()) {
            labels.add(objects[0].toString());
            values.add(objects[1].toString());
        }

        model.addAttribute("equipo_label", new Gson().toJson(labels));
        model.addAttribute("historiales", new Gson().toJson(values));

        return "index";
    }
}
