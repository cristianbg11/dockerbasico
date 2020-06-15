package pract.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pract.model.Custom;
import pract.model.Photo;
import pract.service.ServiceCustom;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.stream.Stream;

@Controller
public class CustomController {

    @Autowired
    private ServiceCustom servicioCliente;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("clientes", servicioCliente.findAll());
        model.addAttribute("error", "");

        return "custom";
    }

    @Secured({"Administrador"})
    @RequestMapping(value = "/registrar/cliente", method = RequestMethod.POST)
    public String registrar(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "cedula") String cedula,
            @RequestParam(value = "foto") MultipartFile foto,
            Model model
    ) throws Exception {
        Photo f = new Photo();
        f.setNombre(foto.getOriginalFilename());
        f.setData(foto.getBytes());

        Custom cliente = new Custom();
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setFoto(f);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Stream violaciones = validator.validate(cliente).stream();

        if (violaciones.count() > 0) {
            violaciones = validator.validate(cliente).stream();

            model.addAttribute("clientes", servicioCliente.findAll());
            model.addAttribute("error", ((ConstraintViolation) violaciones.findFirst().get()).getMessage());

            return "clientes";
        } else {
            servicioCliente.save(cliente);

            return "redirect:/clientes";
        }
    }

    @RequestMapping(value = "/borrar/cliente", method = RequestMethod.GET)
    public String borrar(@RequestParam(name = "id") String id) {
        servicioCliente.delete(Long.parseLong(id));

        return "redirect:/clientes";
    }
}

