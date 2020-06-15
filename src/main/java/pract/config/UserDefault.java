package pract.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pract.model.Rol;
import pract.model.User;
import pract.service.ServicioRol;
import pract.service.ServiceUser;

import java.time.LocalDate;

@Controller
public class UserDefault {

    @Autowired
    private ServiceUser servicioUsuario;

    @Autowired
    private ServicioRol servicioRol;

    @Autowired
    public UserDefault(ServiceUser servicioUsuario, ServicioRol servicioRol) {
        User usuario = new User();
        usuario.setNombres("Jean");
        usuario.setApellidos("Marte");
        usuario.setCorreo("jeancmarte21@gmail.com");
        usuario.setFechaNacimiento(LocalDate.of(1992, 11, 21));
        usuario.setRol("Administrador");
        usuario.setNombreUsuario("admin");
        usuario.setContrasena("admin");
        usuario.setHabilitado(true);

        if (servicioUsuario.findAll().size() == 0) {
            servicioUsuario.save(usuario);
        }

        if (servicioRol.findAll().size() == 0) {
            Rol rol = new Rol();
            rol.setNombre("Administrador");
            rol.setDescripcion("admin.");
            servicioRol.save(rol);

            rol = new Rol();
            rol.setNombre("ROLE_USUARIO");
            rol.setDescripcion("user");
            servicioRol.save(rol);
        }
    }
}