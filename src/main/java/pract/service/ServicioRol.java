package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pract.model.Rol;

@Repository
public interface ServicioRol extends JpaRepository<Rol, Long> {
}
