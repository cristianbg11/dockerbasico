package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pract.model.User;

@Repository
public interface ServiceUser extends JpaRepository<User, Long>{
    User findUsuarioBy(String nombreUsuario);


    User save(User entity);
}
