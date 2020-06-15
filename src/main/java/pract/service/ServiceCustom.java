package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pract.model.Custom;

@Repository
public interface ServiceCustom extends JpaRepository<Custom, Long> {

}
